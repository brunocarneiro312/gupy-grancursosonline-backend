package br.com.grancursosonline.bancoquestoes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "QUESTAO")
public class Questao implements Serializable {

    public Questao(Assunto assunto, Orgao orgao, Banca banca, String enunciado) {
        this.assunto = assunto;
        this.orgao = orgao;
        this.banca = banca;
        this.enunciado = enunciado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    private Assunto assunto;

    @ManyToOne
    private Orgao orgao;

    @ManyToOne
    private Banca banca;

    @Column(name = "ENUNCIADO")
    private String enunciado;
}
