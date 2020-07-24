package br.com.grancursosonline.bancoquestoes.service.impl;

import br.com.grancursosonline.bancoquestoes.entity.Assunto;
import br.com.grancursosonline.bancoquestoes.repository.AssuntoRepository;
import br.com.grancursosonline.bancoquestoes.service.AssuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AssuntoServiceImpl implements AssuntoService {

    private AssuntoRepository assuntoRepository;

    @Autowired
    public AssuntoServiceImpl(AssuntoRepository assuntoRepository) {
        this.assuntoRepository = assuntoRepository;
    }

    @Override
    public Assunto save(Assunto assunto) {
        return this.assuntoRepository.save(assunto);
    }

    @Override
    public Assunto getById(Integer id) {
        return this.assuntoRepository.findById(id).get();
    }

    @Override
    public Collection<Assunto> list() {
        return this.assuntoRepository.findAll();
    }

    @Override
    public Assunto update(Assunto assunto) {
        return this.assuntoRepository.saveAndFlush(assunto);
    }

    @Override
    public Assunto delete(Integer id) {
        Assunto assunto = this.getById(id);
        if (assunto == null) {
            return null;
        }
        this.assuntoRepository.deleteById(id);
        return assunto;
    }
}
