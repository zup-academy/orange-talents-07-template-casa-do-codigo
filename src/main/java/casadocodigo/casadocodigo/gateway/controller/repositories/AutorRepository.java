package casadocodigo.casadocodigo.gateway.controller.repositories;

import casadocodigo.casadocodigo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository  extends JpaRepository<Autor, Long> {

    @Query("select a from Autor a where a.emailAutor = :email")
    List<Autor> findByEmail (@Param("email")String email);
}

