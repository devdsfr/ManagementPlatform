package com.plataforma.gestorpedidos.repository;

import com.plataforma.gestorpedidos.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatus(String status);
}
