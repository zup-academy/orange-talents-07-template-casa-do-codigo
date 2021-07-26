package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorPostDto {

    @NotNull
    @NotEmpty
    private String nome;
    @NotNull
    @Email
    private String email;
    @NotEmpty
    @NotNull
    @Length(max = 400)
    private String descricao;

    @Deprecated
    public AutorPostDto() {
    }

    public Autor converter(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
