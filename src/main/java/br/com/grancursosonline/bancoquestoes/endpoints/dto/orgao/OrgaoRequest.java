package br.com.grancursosonline.bancoquestoes.endpoints.dto.orgao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoRequest {
    private Integer id;
    private String nome;
}
