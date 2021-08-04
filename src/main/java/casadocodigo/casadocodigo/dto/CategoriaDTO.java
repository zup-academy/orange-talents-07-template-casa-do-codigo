package casadocodigo.casadocodigo.dto;

import casadocodigo.casadocodigo.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {


    @NotBlank
   // @UniqueValue(domainClass = Categoria.class, fieldName = "nomeCategoria")
    private String nomeCategoria;

    public CategoriaDTO(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }


    public String getNome() {

        return nomeCategoria;
    }

    public String getNomeCategoria() {

        return nomeCategoria;
    }
}