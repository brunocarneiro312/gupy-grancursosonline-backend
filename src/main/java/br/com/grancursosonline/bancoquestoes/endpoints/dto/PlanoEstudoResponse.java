package br.com.grancursosonline.bancoquestoes.endpoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanoEstudoResponse {
    private String assunto;
    private Integer count;
}
