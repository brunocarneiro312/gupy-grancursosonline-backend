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

    private Integer id;
    private String topico;
    private List<AssuntoResponse> assuntos = new ArrayList<>();
}
