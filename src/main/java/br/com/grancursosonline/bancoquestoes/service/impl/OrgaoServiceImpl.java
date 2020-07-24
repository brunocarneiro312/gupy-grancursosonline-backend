package br.com.grancursosonline.bancoquestoes.service.impl;

import br.com.grancursosonline.bancoquestoes.entity.Orgao;
import br.com.grancursosonline.bancoquestoes.repository.OrgaoRepository;
import br.com.grancursosonline.bancoquestoes.service.CrudService;
import br.com.grancursosonline.bancoquestoes.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrgaoServiceImpl implements OrgaoService, CrudService<Orgao> {

    private OrgaoRepository orgaoRepository;

    @Autowired
    public OrgaoServiceImpl(OrgaoRepository orgaoRepository) {
        this.orgaoRepository = orgaoRepository;
    }

    @Override
    public Orgao save(Orgao orgao) {
        return this.orgaoRepository.save(orgao);
    }

    @Override
    public Orgao getById(Integer id) {
        return this.orgaoRepository.findById(id).get();
    }

    @Override
    public Collection<Orgao> list() {
        return this.orgaoRepository.findAll();
    }

    @Override
    public Orgao update(Orgao orgao) {
        return this.orgaoRepository.saveAndFlush(orgao);
    }

    @Override
    public Orgao delete(Integer id) {
        Orgao orgao = this.getById(id);
        if (orgao == null) {
            return null;
        }
        this.orgaoRepository.deleteById(id);
        return orgao;
    }
}
