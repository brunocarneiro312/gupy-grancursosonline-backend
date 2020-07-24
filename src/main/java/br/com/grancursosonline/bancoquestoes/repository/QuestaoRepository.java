package br.com.grancursosonline.bancoquestoes.repository;

import br.com.grancursosonline.bancoquestoes.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

}
