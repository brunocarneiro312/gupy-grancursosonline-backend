package br.com.grancursosonline.bancoquestoes.repository;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.PlanoEstudoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

    @Query(
        value = "SELECT A.TOPICO, COUNT(Q.ENUNCIADO) " +
                "FROM questao Q, assunto A " +
                "WHERE Q.BANCA_ID = :bancaId " +
                "AND Q.ORGAO_ID = :orgaoId " +
                "AND A.ID  = Q.ASSUNTO_ID " +
                "GROUP BY A.TOPICO",
        nativeQuery = true
    )
    List<Object[]> getPlanoEstudo(
            @Param("bancaId") Integer bancaId,
            @Param("orgaoId") Integer orgaoId);
}
