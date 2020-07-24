package br.com.grancursosonline.bancoquestoes.endpoints.dto.banca;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BancaRequest {
    private Integer id;
    private String nome;
}
