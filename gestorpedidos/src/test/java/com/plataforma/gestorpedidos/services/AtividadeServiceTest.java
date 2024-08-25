package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Atividade;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
import com.plataforma.gestorpedidos.repository.AtividadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AtividadeServiceTest {

    @Mock
    private AtividadeRepository atividadeRepository;

    @InjectMocks
    private AtividadeService atividadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodos_DeveRetornarListaDeAtividades() {
        Atividade atividade1 = new Atividade();
        atividade1.setId(1L);
        atividade1.setDescricao("Atividade 1");

        Atividade atividade2 = new Atividade();
        atividade2.setId(2L);
        atividade2.setDescricao("Atividade 2");

        when(atividadeRepository.findAll()).thenReturn(Arrays.asList(atividade1, atividade2));

        List<Atividade> atividades = atividadeService.listarTodos();

        assertNotNull(atividades);
        assertEquals(2, atividades.size());
        assertEquals("Atividade 1", atividades.get(0).getDescricao());
        assertEquals("Atividade 2", atividades.get(1).getDescricao());
    }

    @Test
    void buscarPorId_DeveRetornarAtividadeQuandoIdExistir() {
        Atividade atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Atividade 1");

        when(atividadeRepository.findById(1L)).thenReturn(Optional.of(atividade));

        Atividade found = atividadeService.buscarPorId(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
        assertEquals("Atividade 1", found.getDescricao());
    }

    @Test
    void buscarPorId_DeveLancarExcecaoQuandoIdNaoExistir() {
        when(atividadeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> atividadeService.buscarPorId(1L));
    }

    @Test
    void salvar_DeveRetornarAtividadeSalva() {
        Atividade atividade = new Atividade();
        atividade.setDescricao("Nova Atividade");

        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividade);

        Atividade saved = atividadeService.salvar(atividade);

        assertNotNull(saved);
        assertEquals("Nova Atividade", saved.getDescricao());
    }

    @Test
    void atualizar_DeveRetornarAtividadeAtualizada() {
        Atividade atividadeExistente = new Atividade();
        atividadeExistente.setId(1L);
        atividadeExistente.setDescricao("Atividade Existente");

        Atividade atividadeAtualizada = new Atividade();
        atividadeAtualizada.setDescricao("Atividade Atualizada");

        when(atividadeRepository.findById(1L)).thenReturn(Optional.of(atividadeExistente));
        when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividadeExistente);

        Atividade updated = atividadeService.atualizar(1L, atividadeAtualizada);

        assertNotNull(updated);
        assertEquals("Atividade Atualizada", updated.getDescricao());
    }

    @Test
    void excluir_DeveChamarMetodoExcluirDoRepositorio() {
        atividadeService.excluir(1L);
        verify(atividadeRepository, times(1)).deleteById(1L);
    }
}
