package com.plataforma.gestorpedidos.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String status;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "projeto")
    private List<Atividade> atividades;
}