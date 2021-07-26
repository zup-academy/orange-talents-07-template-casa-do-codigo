package orange.talents.rick.casadocodigo.rest.dto;

import orange.talents.rick.casadocodigo.model.Autor;
import orange.talents.rick.casadocodigo.rest.validator.EmailNaoDuplicado;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AutorPostDto {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Email
    @EmailNaoDuplicado
    private String email;
    @NotBlank
    @NotNull
    @Length(max = 400)
    private String descricao;

    @Deprecated
    public AutorPostDto() {
    }

    public Autor toModel(){
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
