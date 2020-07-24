package br.com.grancursosonline.bancoquestoes.endpoints;

import br.com.grancursosonline.bancoquestoes.endpoints.dto.orgao.OrgaoRequest;
import br.com.grancursosonline.bancoquestoes.endpoints.dto.orgao.OrgaoResponse;
import br.com.grancursosonline.bancoquestoes.entity.Orgao;
import br.com.grancursosonline.bancoquestoes.service.OrgaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orgao")
public class OrgaoEndpoint {

    private OrgaoService orgaoService;

    public OrgaoEndpoint(OrgaoService orgaoService) {
        this.orgaoService = orgaoService;
    }

    @PostMapping
    public ResponseEntity<OrgaoResponse> save(@RequestBody OrgaoRequest orgaoRequest) {
        try {
            Orgao orgao = this.orgaoService.save(new Orgao(orgaoRequest.getNome()));
            return new ResponseEntity<>(
                    new OrgaoResponse(orgao.getId(), orgao.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<OrgaoResponse>> list() {
        try {
            List<Orgao> orgaos = (List<Orgao>) this.orgaoService.list();
            if (orgaos.size() == 0) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            List<OrgaoResponse> orgaoResponse = new ArrayList<>();
            orgaos.forEach(b -> orgaoResponse.add(new OrgaoResponse(b.getId(), b.getNome())));
            return new ResponseEntity<>(orgaoResponse, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoResponse> get(@PathVariable("id") Integer id) {
        try {
            Orgao orgao = this.orgaoService.getById(id);
            if (orgao == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new OrgaoResponse(orgao.getId(), orgao.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<OrgaoResponse> update(@RequestBody OrgaoRequest orgaoRequest) {
        try {
            Orgao orgao = this.orgaoService.getById(orgaoRequest.getId());
            if (orgao == null) {
                throw new Exception("A banca com o id " + orgaoRequest.getId() + " não existe");
            }
            orgao.setNome(orgaoRequest.getNome());
            this.orgaoService.save(orgao);
            return new ResponseEntity<>(new OrgaoResponse(orgao.getId(), orgao.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrgaoResponse> delete(@PathVariable("id") Integer id) {
        try {
            Orgao orgao = this.orgaoService.delete(id);
            if (orgao == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new OrgaoResponse(orgao.getId(), orgao.getNome()), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
