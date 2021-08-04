package casadocodigo.casadocodigo.util.validators;

import casadocodigo.casadocodigo.dto.CategoriaDTO;
import casadocodigo.casadocodigo.gateway.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return CategoriaDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "nomeCategoria", "O nome da categoria não pode estar vazio");

        CategoriaDTO categoriaDTO  = (CategoriaDTO) o;

        var listaCategorias = categoriaRepository.findByNome(categoriaDTO.getNomeCategoria());

        if (!listaCategorias.isEmpty()){
            errors.rejectValue("nomeCategoria", "Essa categoria já existe!");
        }
    }
}