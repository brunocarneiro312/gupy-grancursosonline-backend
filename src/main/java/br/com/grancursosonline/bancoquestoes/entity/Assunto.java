package br.com.grancursosonline.bancoquestoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ASSUNTO")
public class Assunto implements Serializable {

    public Assunto(String topico) {
        this.topico = topico;
    }

    public Assunto(String topico, List<Assunto> assuntos) {
        this.topico = topico;
        this.assuntos = assuntos;
    }

    public Assunto(String topico, List<Assunto> assuntos, Assunto assuntoPai) {
        this.topico = topico;
        this.assuntos = assuntos;
        this.assuntoPai = assuntoPai;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TOPICO")
    private String topico;

    @OneToMany(mappedBy = "assuntoPai", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Assunto> assuntos;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ASSUNTO_PAI")
    private Assunto assuntoPai;
}
