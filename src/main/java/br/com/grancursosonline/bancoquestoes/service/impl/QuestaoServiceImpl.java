package br.com.grancursosonline.bancoquestoes.service.impl;

import br.com.grancursosonline.bancoquestoes.entity.Questao;
import br.com.grancursosonline.bancoquestoes.repository.QuestaoRepository;
import br.com.grancursosonline.bancoquestoes.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuestaoServiceImpl implements CrudService<Questao> {

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
}
