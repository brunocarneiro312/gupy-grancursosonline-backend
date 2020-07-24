package br.com.grancursosonline.bancoquestoes.endpoints;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.banca.BancaRequest;
import br.com.grancursosonline.bancoquestoes.endpoints.dto.banca.BancaResponse;
import br.com.grancursosonline.bancoquestoes.entity.Banca;
import br.com.grancursosonline.bancoquestoes.service.BancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/banca")
public class BancaEndpoint {

    private BancaService bancaService;

    @Autowired
    public BancaEndpoint(BancaService bancaService) {
        this.bancaService = bancaService;
    }

    @PostMapping
    public ResponseEntity<BancaResponse> save(@RequestBody BancaRequest bancaRequest) {
        try {
            Banca banca = this.bancaService.save(new Banca(bancaRequest.getNome()));
            return new ResponseEntity<>(
                    new BancaResponse(banca.getId(), banca.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<BancaResponse>> list() {
        try {
            List<Banca> bancas = (List<Banca>) this.bancaService.list();
            if (bancas.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            List<BancaResponse> bancasResponse = new ArrayList<>();
            bancas.forEach(b -> bancasResponse.add(new BancaResponse(b.getId(), b.getNome())));
            return new ResponseEntity<>(bancasResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancaResponse> get(@PathVariable("id") Integer id) {
        try {
            Banca banca = this.bancaService.getById(id);
            if (banca == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new BancaResponse(banca.getId(), banca.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<BancaResponse> update(@RequestBody BancaRequest bancaRequest) {
        try {
            Banca banca = this.bancaService.getById(bancaRequest.getId());
            if (banca == null) {
                throw new Exception("A banca com o id " + bancaRequest.getId() + " não existe");
            }
            banca.setNome(bancaRequest.getNome());
            this.bancaService.save(banca);
            return new ResponseEntity<>(new BancaResponse(banca.getId(), banca.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BancaResponse> delete(@PathVariable("id") Integer id) {
        try {
            Banca banca = this.bancaService.delete(id);
            if (banca == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new BancaResponse(banca.getId(), banca.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
