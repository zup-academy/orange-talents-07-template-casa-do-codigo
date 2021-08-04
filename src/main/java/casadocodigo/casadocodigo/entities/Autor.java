package casadocodigo.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "TB_AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AUTOR")
    private long idAutor;

    @NotNull
    @NotBlank
    @Column(name = "NOME_AUTOR")
    private String nomeAutor;

    @NotNull @NotBlank
    @Column(name = "EMAIL_AUTOR")
    private String emailAutor;

    @NotNull @NotBlank
    @Column(name = "DESC_AUTOR", length = 400)
    private String descAutor;

    @Column(name = "LOCAL")
    private LocalDateTime local;

    public Autor(String nomeAutor, String emailAutor, String descAutor) {
    }


    public Autor(long idAutor, String nomeAutor, String emailAutor, String descAutor, LocalDateTime local) {
        this.idAutor = idAutor;
        this.nomeAutor = nomeAutor;
        this.emailAutor = emailAutor;
        this.descAutor = descAutor;
        this.local = local;
    }

    public Autor() {

    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricao() {
        return descAutor;
    }
}
