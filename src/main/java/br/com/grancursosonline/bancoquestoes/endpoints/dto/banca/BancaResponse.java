package br.com.grancursosonline.bancoquestoes.endpoints.dto.banca;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BancaResponse {

    private Integer id;
    private String nome;

}
