package br.com.grancursosonline.bancoquestoes.endpoints.dto.assunto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AssuntoRequest {

    public AssuntoRequest(String topico) {
        this.topico = topico;
    }

    public AssuntoRequest(String topico, List<AssuntoRequest> assuntos) {
        this.topico = topico;
        this.assuntos = assuntos;
    }

    public AssuntoRequest(String topico, List<AssuntoRequest> assuntos, Integer assuntoPai) {
        this.topico = topico;
        this.assuntos = assuntos;
        this.assuntoPai = assuntoPai;
    }

    private Integer id;
    private String topico;
    private List<AssuntoRequest> assuntos = new ArrayList<>();
    private Integer assuntoPai;
}
