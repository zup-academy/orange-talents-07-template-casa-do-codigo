package casadocodigo.casadocodigo.gateway.controllers;

import casadocodigo.casadocodigo.dto.LivroDTO;
import casadocodigo.casadocodigo.entities.Livro;
import casadocodigo.casadocodigo.gateway.repositories.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {


    @PersistenceContext
    EntityManager manager;

    private LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {}

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastraLivro(@RequestBody @Valid LivroDTO request) {

        Livro livro = request.toModel(manager);
        livroRepository.save(livro);
    }


    @GetMapping
    public List<LivroDTO> lista(String titulo) {
        if (titulo == null) {
            List<Livro> livro = livroRepository.findAll();
            return LivroDTO.converter(livro);
        } else {
            List<Livro> livro = livroRepository.findByTitulo(titulo);
            return LivroDTO.converter(livro);
        }
    }

}