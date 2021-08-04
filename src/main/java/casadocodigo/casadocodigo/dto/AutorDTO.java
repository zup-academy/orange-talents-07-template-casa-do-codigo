package casadocodigo.casadocodigo.dto;


import casadocodigo.casadocodigo.entities.Autor;
import casadocodigo.casadocodigo.util.validators.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotBlank
    private String nomeAutor;

    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "emailAutor")
    private String emailAutor;

    @NotBlank
    @Size(max=400)
    private String descAutor;

    public @NotBlank String getEmailAutor() {
        return emailAutor;
    }


    public Autor toModel() {
        return new Autor(this.nomeAutor, this.emailAutor, this.descAutor);
    }
}
