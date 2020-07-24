package br.com.grancursosonline.bancoquestoes.service.impl;

import br.com.grancursosonline.bancoquestoes.entity.Banca;
import br.com.grancursosonline.bancoquestoes.repository.BancaRepository;
import br.com.grancursosonline.bancoquestoes.service.BancaService;
import br.com.grancursosonline.bancoquestoes.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BancaServiceImpl implements BancaService, CrudService<Banca> {

    private BancaRepository bancaRepository;

    @Autowired
    public BancaServiceImpl(BancaRepository bancaRepository) {
        this.bancaRepository = bancaRepository;
    }

    @Override
    public Banca save(Banca banca) {
        return this.bancaRepository.save(banca);
    }

    @Override
    public Banca getById(Integer id) {
        return this.bancaRepository.findById(id).get();
    }

    @Override
    public Collection<Banca> list() {
        return this.bancaRepository.findAll();
    }

    @Override
    public Banca update(Banca banca) {
        return this.bancaRepository.saveAndFlush(banca);
    }

    @Override
    public Banca delete(Integer id) {
        Banca banca = this.getById(id);
        if (banca == null) {
            return null;
        }
        this.bancaRepository.deleteById(id);
        return banca;
    }
}
