package br.com.grancursosonline.bancoquestoes.entity;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TOPICO")
    private String topico;

    @OneToMany
    @JoinColumn(name = "ASSUNTO_PAI")
    private List<Assunto> assuntos;
}