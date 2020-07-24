package br.com.grancursosonline.bancoquestoes.endpoints.dto.questao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestaoRequest {
    private Integer id;
    private Integer assuntoId;
    private Integer orgaoId;
    private Integer bancaId;
    private String enunciado;
}
