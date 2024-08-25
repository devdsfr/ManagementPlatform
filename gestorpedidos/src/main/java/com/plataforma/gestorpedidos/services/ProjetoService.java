package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Projeto;
import com.plataforma.gestorpedidos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarPorStatus(String status) {
        return projetoRepository.findByStatus(status);
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public void excluir(Long id) {
        projetoRepository.deleteById(id);
    }
}