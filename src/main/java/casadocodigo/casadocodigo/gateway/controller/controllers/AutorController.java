package casadocodigo.casadocodigo.gateway.controller.controllers;

import casadocodigo.casadocodigo.dto.AutorDTO;
import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.gateway.controller.repositories.AutorRepository;
import casadocodigo.casadocodigo.util.validators.AutorValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public class AutorController {


    private AutorRepository autorRepository;
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraAutor(@RequestBody @Validated(AutorValidator.class) @Valid AutorDTO request){

        Autor autor = request.toModel();
        autorRepository.save(autor);
    }
}
