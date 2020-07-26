package br.com.grancursosonline.bancoquestoes.service.impl;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.PlanoEstudoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Questao;
import br.com.grancursosonline.bancoquestoes.repository.QuestaoRepository;
import br.com.grancursosonline.bancoquestoes.service.CrudService;
import br.com.grancursosonline.bancoquestoes.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class QuestaoServiceImpl implements QuestaoService, CrudService<Questao> {

    private QuestaoRepository questaoRepository;

    @Autowired
    public QuestaoServiceImpl(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    @Override
    public Questao save(Questao questao) {
        return this.questaoRepository.save(questao);
    }

    @Override
    public Questao getById(Integer id) {
        return this.getById(id);
    }

    @Override
    public Collection<Questao> list() {
        return this.questaoRepository.findAll();
    }

    @Override
    public Questao update(Questao questao) {
        return this.questaoRepository.saveAndFlush(questao);
    }

    @Override
    public Questao delete(Integer id) {
        Questao questao = this.getById(id);
        if (questao == null) {
            return null;
        }
        this.questaoRepository.deleteById(id);
        return questao;
    }

    public List<PlanoEstudoResponse> getPlanoEstudo(Integer bancaId, Integer orgaoId) {
        List<Object[]> planoEstudo = this.questaoRepository.getPlanoEstudo(bancaId, orgaoId);
        List<PlanoEstudoResponse> planoEstudoResponse = new ArrayList<>();
        planoEstudo.forEach(p -> {
            PlanoEstudoResponse dto = new PlanoEstudoResponse();
            dto.setAssunto(p[0].toString());
            dto.setCount(Integer.parseInt(p[1].toString()));
            planoEstudoResponse.add(dto);
        });
        return planoEstudoResponse;
    }
}
