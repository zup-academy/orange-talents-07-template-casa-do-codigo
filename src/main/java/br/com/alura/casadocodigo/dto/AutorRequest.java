package br.com.alura.casadocodigo.dto;

import br.com.alura.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class AutorRequest {


    @NotEmpty @Email
    String email;

    @NotEmpty
    String nome;

    @NotEmpty @Length(max = 400)
    String descricao;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converte(AutorRequest autorRequest){
        return new Autor(autorRequest);
    }
}
