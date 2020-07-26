package br.com.grancursosonline.bancoquestoes.service;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.PlanoEstudoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Questao;

import java.util.List;

public interface QuestaoService extends CrudService<Questao> {

    List<PlanoEstudoResponse> getPlanoEstudo(Integer bancaId, Integer orgaoId);

}
