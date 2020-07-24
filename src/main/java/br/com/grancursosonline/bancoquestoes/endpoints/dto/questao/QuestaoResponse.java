package br.com.grancursosonline.bancoquestoes.endpoints.dto.questao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoResponse {
    private Integer id;
    private String assunto;
    private String orgao;
    private String banca;
    private String enunciado;
}
