package br.com.alura.casadocodigo.model;

import br.com.alura.casadocodigo.dto.AutorRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

    public Autor(){ }

    public Autor(AutorRequest cadastraAutorDto){
        this.email = cadastraAutorDto.getEmail();
        this.nome = cadastraAutorDto.getNome();
        this.descricao = cadastraAutorDto.getDescricao();
    }


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data = LocalDateTime.now();

    private String email;

    private String nome;

    private String descricao;

    public Long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

