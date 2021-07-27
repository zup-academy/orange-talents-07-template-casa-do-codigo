package br.com.alura.casadocodigo.repository;

import br.com.alura.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
