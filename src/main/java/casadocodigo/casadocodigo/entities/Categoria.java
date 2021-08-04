package casadocodigo.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private long idCategoria;

    @NotNull
    @NotBlank
    @Column(name = "NOME_CATEGORIA")
    private String nomeCategoria;


    public Categoria(long idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria() {
    }

    public Categoria(String nomeCategoria) {

        this.nomeCategoria = nomeCategoria;
    }
}