package br.com.grancursosonline.bancoquestoes.endpoints;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.PlanoEstudoResponse;
import br.com.grancursosonline.bancoquestoes.endpoints.dto.questao.QuestaoRequest;
import br.com.grancursosonline.bancoquestoes.endpoints.dto.questao.QuestaoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Assunto;
import br.com.grancursosonline.bancoquestoes.entity.Banca;
import br.com.grancursosonline.bancoquestoes.entity.Orgao;
import br.com.grancursosonline.bancoquestoes.entity.Questao;
import br.com.grancursosonline.bancoquestoes.service.AssuntoService;
import br.com.grancursosonline.bancoquestoes.service.BancaService;
import br.com.grancursosonline.bancoquestoes.service.OrgaoService;
import br.com.grancursosonline.bancoquestoes.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/questao")
public class QuestaoEndpoint {

    private QuestaoService questaoService;
    private BancaService bancaService;
    private OrgaoService orgaoService;
    private AssuntoService assuntoService;

    @Autowired
    public QuestaoEndpoint(QuestaoService questaoService,
                           BancaService bancaService,
                           OrgaoService orgaoService,
                           AssuntoService assuntoService) {
        this.questaoService = questaoService;
        this.bancaService = bancaService;
        this.orgaoService = orgaoService;
        this.assuntoService = assuntoService;
    }

    @PostMapping
    public ResponseEntity<QuestaoResponse> save(@RequestBody QuestaoRequest questaoRequest) {
        try {
            Orgao orgao = this.orgaoService.getById(questaoRequest.getOrgaoId());
            Banca banca = this.bancaService.getById(questaoRequest.getBancaId());
            Assunto assunto = this.assuntoService.getById(questaoRequest.getAssuntoId());

            if (orgao == null || banca == null || assunto == null) {
                throw new Exception("Erro ao realizar cadastro de questão");
            }

            Questao questao = this.questaoService.save(
                    new Questao(
                            assunto,
                            orgao,
                            banca,
                            questaoRequest.getEnunciado()));

            return new ResponseEntity<>(
                    new QuestaoResponse(
                            questao.getId(),
                            questao.getAssunto().getTopico(),
                            questao.getOrgao().getNome(),
                            questao.getBanca().getNome(),
                            questao.getEnunciado()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<QuestaoResponse>> list() {
        try {
            List<Questao> questoes = (List<Questao>) this.questaoService.list();
            if (questoes.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            List<QuestaoResponse> questaoResponse = new ArrayList<>();
            questoes.forEach(b -> questaoResponse.add(
                    new QuestaoResponse(
                        b.getId(),
                        b.getAssunto().getTopico(),
                        b.getOrgao().getNome(),
                        b.getBanca().getNome(),
                        b.getEnunciado())));
            return new ResponseEntity<>(questaoResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestaoResponse> get(@PathVariable("id") Integer id) {
        try {
            Questao questao = this.questaoService.getById(id);
            if (questao == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new QuestaoResponse(
                    questao.getId(),
                    questao.getAssunto().getTopico(),
                    questao.getOrgao().getNome(),
                    questao.getBanca().getNome(),
                    questao.getEnunciado()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/plano")
    public ResponseEntity<List<PlanoEstudoResponse>> get(
            @PathParam("bancaId") Integer bancaId,
            @PathParam("orgaoId") Integer orgaoId) {
        try {
            List<PlanoEstudoResponse> planoDeEstudos = this.questaoService.getPlanoEstudo(bancaId, orgaoId);
            return new ResponseEntity<>(planoDeEstudos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<QuestaoResponse> update(@RequestBody QuestaoRequest questaoRequest) {
        try {
            Questao questao = this.questaoService.getById(questaoRequest.getId());
            if (questao == null) {
                throw new Exception("A banca com o id " + questaoRequest.getId() + " não existe");
            }

            Assunto assunto = new Assunto();
            assunto.setId(questaoRequest.getAssuntoId());

            Orgao orgao = new Orgao();
            orgao.setId(questaoRequest.getOrgaoId());

            Banca banca = new Banca();
            banca.setId(questaoRequest.getBancaId());

            questao.setEnunciado(questaoRequest.getEnunciado());
            questao.setAssunto(assunto);
            questao.setOrgao(orgao);
            questao.setBanca(banca);

            this.questaoService.save(questao);
            return new ResponseEntity<>(new QuestaoResponse(
                    questao.getId(),
                    questao.getAssunto().getTopico(),
                    questao.getOrgao().getNome(),
                    questao.getBanca().getNome(),
                    questao.getEnunciado()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<QuestaoResponse> delete(@PathVariable("id") Integer id) {
        try {
            Questao questao = this.questaoService.delete(id);
            if (questao == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new QuestaoResponse(
                    questao.getId(),
                    questao.getAssunto().getTopico(),
                    questao.getOrgao().getNome(),
                    questao.getBanca().getNome(),
                    questao.getEnunciado()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
