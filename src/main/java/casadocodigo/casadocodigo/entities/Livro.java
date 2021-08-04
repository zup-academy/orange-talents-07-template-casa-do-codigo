package casadocodigo.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLivro;

    @NotNull @NotBlank //Titulo é obrigatório
    @Column(name = "TITULO")
    private String titulo;

    @NotNull @NotBlank //Resumo é obrigatório
    @Column(name = "RESUMO")
    private String resumo;

    @NotNull @NotBlank //Sumário é de tamanho livre.
    @Column(name = "SUMARIO")
    private String sumario;

    @NotNull @NotBlank //Preço é obrigatório e o mínimo é de 20
    @Column(name = "PRECO")
    @Length(min = 20)
    private BigDecimal preco;

    @NotNull @NotBlank //Número de páginas é obrigatória e o mínimo é de 100
    @Column(name = "NUMERO_PAGINAS")
    @Length(min = 100)
    private int numeroPaginas;

    @NotBlank @NotNull //Isbn é obrigatório, formato livre - Isbn é único
    @Column(name = "isbn")
    private String isbn;


    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    @NotBlank @NotNull // Data que vai entrar no ar precisa ser no futuro
    @Column(name = "DATA_PUBLICACAO")
    private LocalDate data_publicacao;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    @NotNull //A categoria não pode ser nula
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "ID_AUTOR")
    @NotNull //O autor não pode ser nulo
    private Autor autor;


    public Livro(long idLivro,
                 String titulo,
                 String resumo,
                 String sumario,
                 BigDecimal preco,
                 int numeroPaginas,
                 String isbn,
                 LocalDate data_publicacao,
                 Categoria categoria,
                 Autor autor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.data_publicacao = data_publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro() {
    }

    public Livro(String titulo,
                 String resumo,
                 String sumario,
                 int preco,
                 int numero_paginas,
                 String isbn,
                 LocalDate data_publicacao,
                 Categoria categoria,
                 Autor autor) {
    }



    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
