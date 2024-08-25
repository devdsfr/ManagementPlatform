package com.plataforma.gestorpedidos.repository;

import com.plataforma.gestorpedidos.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
}