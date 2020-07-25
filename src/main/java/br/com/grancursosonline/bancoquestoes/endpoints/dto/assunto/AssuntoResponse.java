package br.com.grancursosonline.bancoquestoes.endpoints.dto.assunto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AssuntoResponse {

    public AssuntoResponse(Integer id, String topico, List<AssuntoResponse> assuntos) {
        this.id = id;
        this.topico = topico;
        this.assuntos = assuntos;
    }

    public AssuntoResponse(String topico, List<AssuntoResponse> assuntos, Integer assuntoPai) {
        this.topico = topico;
        this.assuntos = assuntos;
        this.assuntoPai = assuntoPai;
    }

    private Integer id;
    private String topico;
    private List<AssuntoResponse> assuntos = new ArrayList<>();
    private Integer assuntoPai;
}
