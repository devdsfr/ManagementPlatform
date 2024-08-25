package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Atividade;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
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

    public Atividade buscarPorId(Long id) {
        return atividadeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade não encontrada com id: " + id));
    }
    public Atividade salvar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
    public Atividade atualizar(Long id, Atividade atividadeAtualizada) {
        Atividade atividadeExistente = buscarPorId(id);
        atividadeExistente.setDescricao(atividadeAtualizada.getDescricao());
        atividadeExistente.setDataInicio(atividadeAtualizada.getDataInicio());
        atividadeExistente.setDataFim(atividadeAtualizada.getDataFim());
        //atividadeExistente.setProjetoId(atividadeAtualizada.getProjetoId());
        // Atualize outros campos conforme necessário
        return atividadeRepository.save(atividadeExistente);
    }
    public void excluir(Long id) {
        atividadeRepository.deleteById(id);
    }
}