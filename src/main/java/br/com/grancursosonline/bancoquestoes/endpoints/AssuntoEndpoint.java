package br.com.grancursosonline.bancoquestoes.endpoints;


import br.com.grancursosonline.bancoquestoes.endpoints.dto.assunto.AssuntoRequest;
import br.com.grancursosonline.bancoquestoes.endpoints.dto.assunto.AssuntoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Assunto;
import br.com.grancursosonline.bancoquestoes.service.AssuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/assunto")
public class AssuntoEndpoint {

    private AssuntoService assuntoService;

    @Autowired
    public AssuntoEndpoint(AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }

    @PostMapping
    public ResponseEntity<AssuntoResponse> save(@RequestBody AssuntoRequest assuntoRequest) {
        try {
            Assunto assuntoPai;
            if (assuntoRequest.getAssuntoPai() != null) {
                assuntoPai = assuntoService.getById(assuntoRequest.getAssuntoPai());
                if (assuntoPai == null) {
                    throw new Exception("O assunto pai com o id " + assuntoPai.getId() + " não existe.");
                }
                assuntoPai.getAssuntos().add(
                        new Assunto(
                                assuntoRequest.getTopico(),
                                null,
                                assuntoPai));

                this.assuntoService.save(assuntoPai);

                return new ResponseEntity<>(
                        new AssuntoResponse(
                                assuntoRequest.getTopico(),
                                null,
                                assuntoPai.getId(),
                                assuntoPai.getTopico()),
                        HttpStatus.OK);
            }
            else {
                Assunto assunto = this.assuntoService.save(new Assunto(assuntoRequest.getTopico()));
                return new ResponseEntity<>(
                        new AssuntoResponse(
                                assunto.getId(),
                                assunto.getTopico(),
                                null),
                        HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<AssuntoResponse> update(@RequestBody AssuntoRequest assuntoRequest) {
        try {
            Assunto assunto = this.assuntoService.getById(assuntoRequest.getId());
            if (assunto == null) {
                throw new Exception("O assunto com o id " + assuntoRequest.getId() + " não existe");
            }
            assunto.setTopico(assuntoRequest.getTopico());
            this.assuntoService.save(assunto);
            return new ResponseEntity<>(
                    new AssuntoResponse(
                            assunto.getId(),
                            assunto.getTopico(),
                            null),
                    HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssuntoResponse> get(@PathVariable("id") Integer idAssunto) {
        try {
            Assunto assunto = this.assuntoService.getById(idAssunto);
            if (assunto == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(
                    new AssuntoResponse(
                            assunto.getId(),
                            assunto.getTopico(),
                            null),
                    HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<AssuntoResponse>> list() {
        try {
            List<Assunto> assuntos = (List<Assunto>) this.assuntoService.list();
            if (assuntos.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            List<AssuntoResponse> assuntoResponse = new ArrayList<>();
            assuntos.forEach(b -> assuntoResponse.add(
                    new AssuntoResponse(
                            b.getId(),
                            b.getTopico(),
                            null,
                            b.getAssuntoPai() != null ? b.getAssuntoPai().getId() : null,
                            b.getAssuntoPai() != null ? b.getAssuntoPai().getTopico() : null)));
            return new ResponseEntity<>(assuntoResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AssuntoResponse> delete(@PathVariable("id") Integer idAssunto) {
        try {
            Assunto assunto = this.assuntoService.delete(idAssunto);
            if (assunto == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(
                    new AssuntoResponse(
                        assunto.getId(),
                        assunto.getTopico(),
                        null),
                    HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

