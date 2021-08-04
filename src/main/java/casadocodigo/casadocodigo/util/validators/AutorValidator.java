package casadocodigo.casadocodigo.util.validators;


import casadocodigo.casadocodigo.dto.AutorDTO;
import casadocodigo.casadocodigo.gateway.controller.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return AutorDTO.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "nomeAutor", "O nome do autor não pode estar vazio");
        ValidationUtils.rejectIfEmpty(errors, "emailAutor", "O e-mail do autor não pode estar vazio");
        ValidationUtils.rejectIfEmpty(errors, "descAutor", "A descrição do autor não pode estar vazia");


        AutorDTO autorDTO = (AutorDTO) o;

        var listaAutores = autorRepository.findByEmail(autorDTO.getEmailAutor());

        if (!listaAutores.isEmpty()){
            errors.rejectValue("emailAutor", "O e-mail já existe!");
        }
    }

}