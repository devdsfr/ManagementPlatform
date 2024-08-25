package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Projeto;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
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

    public Projeto buscarPorId(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com id: " + id));
    }

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }
    public Projeto atualizar(Long id, Projeto projetoAtualizado) {
        Projeto projetoExistente = buscarPorId(id);
        projetoExistente.setNome(projetoAtualizado.getNome());
        projetoExistente.setStatus(projetoAtualizado.getStatus());
        return projetoRepository.save(projetoExistente);
    }
    public void excluir(Long id) {
        projetoRepository.deleteById(id);
    }
}