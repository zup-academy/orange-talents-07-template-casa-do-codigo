package br.com.alura.casadocodigo.controller;

import br.com.alura.casadocodigo.dto.AutorRequest;
import br.com.alura.casadocodigo.model.Autor;
import br.com.alura.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livraria")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    @Transactional
    void cadastra (@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.converte(autorRequest);
        autorRepository.save(autor);
    }

}


