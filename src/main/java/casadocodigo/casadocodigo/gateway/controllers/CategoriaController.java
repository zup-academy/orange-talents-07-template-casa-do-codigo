package casadocodigo.casadocodigo.gateway.controllers;

import casadocodigo.casadocodigo.dto.CategoriaDTO;
import casadocodigo.casadocodigo.entities.Categoria;
import casadocodigo.casadocodigo.gateway.repositories.CategoriaRepository;
import casadocodigo.casadocodigo.util.validators.CategoriaValidator;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {


    @PersistenceContext
    private EntityManager manager;

    private CategoriaRepository categoriaRepository                                                                                                                                                                                                                                                                 ;
    public CategoriaController(CategoriaRepository categoriaRepository) {this.categoriaRepository = categoriaRepository;}

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public String cadastraCategoria(@RequestBody @Validated(CategoriaValidator.class) @Valid CategoriaDTO request){

        Categoria categoria = new Categoria(request.getNome());
        manager.persist(categoria);
        return categoria.toString();
    }
}