package orange.talents.rick.casadocodigo.rest.validator;

import orange.talents.rick.casadocodigo.model.Autor;
import orange.talents.rick.casadocodigo.repository.AutorRepository;
import orange.talents.rick.casadocodigo.rest.dto.AutorPostDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class EmailNaoDuplicadoValidator implements ConstraintValidator<EmailNaoDuplicado, String> {

    private String value;
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(EmailNaoDuplicado constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Autor> autor = autorRepository.findByEmail(value);

        if (autor.isPresent()) {
            return false;
        }
        return true;
    }
}