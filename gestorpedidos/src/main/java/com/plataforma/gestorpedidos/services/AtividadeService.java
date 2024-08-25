package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Atividade;
import com.plataforma.gestorpedidos.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> listarTodos() {
        return atividadeRepository.findAll();
    }

    public Atividade salvar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public void excluir(Long id) {
        atividadeRepository.deleteById(id);
    }
}