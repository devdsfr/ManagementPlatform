package com.plataforma.gestorpedidos.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String dataInicio;
    private String dataFim;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}
