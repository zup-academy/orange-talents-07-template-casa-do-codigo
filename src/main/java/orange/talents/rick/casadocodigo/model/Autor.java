package orange.talents.rick.casadocodigo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    @Column(nullable = false)
    private LocalDateTime instante;

    @PrePersist
    protected void onCreate() {
        instante = LocalDateTime.now();;
    }

    @Deprecated
    public Autor() {
    }

    public Autor(Long id, String nome, String email, String descricao, LocalDateTime instante) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.instante = instante;
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
