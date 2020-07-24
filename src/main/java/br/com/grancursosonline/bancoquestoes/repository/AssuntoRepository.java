package br.com.grancursosonline.bancoquestoes.repository;

import br.com.grancursosonline.bancoquestoes.entity.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuntoRepository extends JpaRepository<Assunto, Integer> {

}
