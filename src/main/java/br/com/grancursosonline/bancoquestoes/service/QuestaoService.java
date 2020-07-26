package br.com.grancursosonline.bancoquestoes.service;

import br.com.grancursosonline.bancoquestoes.entity.Questao;

import java.util.List;

public interface QuestaoService extends CrudService<Questao> {

    List<Object> getPlanoEstudo(Integer bancaId, Integer orgaoId);

}
