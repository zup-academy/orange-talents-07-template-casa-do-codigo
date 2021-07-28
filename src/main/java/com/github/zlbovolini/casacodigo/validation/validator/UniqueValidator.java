package com.github.zlbovolini.casacodigo.validation.validator;

import com.github.zlbovolini.casacodigo.validation.constraint.EnableUnique;
import com.github.zlbovolini.casacodigo.validation.constraint.Unique;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class UniqueValidator implements ConstraintValidator<EnableUnique, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<?> entity;

    @Override
    public void initialize(EnableUnique constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        entity = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Object object, final ConstraintValidatorContext context) {
        
        if (Objects.isNull(object.getClass())) {
            return false;
        }
        
        List<Field> fields = List.of(object.getClass().getDeclaredFields());

        return fields.stream().filter(field -> {
            try {
                field.setAccessible(true);
                boolean shouldBeUnique = field.isAnnotationPresent(Unique.class);

                if (shouldBeUnique) {
                    Object fieldValue = field.get(object);

                    StringBuilder stringBuilder = new StringBuilder()
                            .append("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM ")
                            .append(entity.getName())
                            .append(" e WHERE e.")
                            .append(field.getName())
                            .append(" = :fieldValue");

                    TypedQuery<Boolean> query = entityManager.createQuery(stringBuilder.toString(), Boolean.class);
                    query.setParameter("fieldValue", fieldValue);

                    return query.getSingleResult();
                }

                return false;
            } catch (IllegalAccessException e) {
                return false;
            }
        })
        .map(invalidField -> {
            String message = invalidField.getAnnotation(Unique.class).message();

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(invalidField.getName())
                    .addConstraintViolation();

            return false;
        })
        .count() == 0;
    }
}
