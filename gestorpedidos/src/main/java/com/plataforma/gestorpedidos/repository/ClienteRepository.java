package com.plataforma.gestorpedidos.repository;

import com.plataforma.gestorpedidos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
