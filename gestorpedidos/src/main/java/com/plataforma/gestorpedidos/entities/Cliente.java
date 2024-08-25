package com.plataforma.gestorpedidos.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Projeto> projetos;
}