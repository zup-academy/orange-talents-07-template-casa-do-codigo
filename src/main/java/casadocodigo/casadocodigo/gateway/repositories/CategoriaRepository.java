package casadocodigo.casadocodigo.gateway.repositories;

import casadocodigo.casadocodigo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

    @Query("select a from Categoria a where a.nomeCategoria = :nome")
    List<Categoria> findByNome (@Param("nome")String nome);
}