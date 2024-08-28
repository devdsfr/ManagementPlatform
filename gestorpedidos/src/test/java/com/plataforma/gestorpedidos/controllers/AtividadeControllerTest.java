package com.plataforma.gestorpedidos.controllers;

import com.plataforma.gestorpedidos.entities.Atividade;
import com.plataforma.gestorpedidos.services.AtividadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtividadeControllerTest {

    @InjectMocks
    private AtividadeController atividadeController;

    @Mock
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

        when(atividadeService.listarTodos()).thenReturn(Arrays.asList(atividade1, atividade2));

        List<Atividade> atividades = atividadeController.listarTodos();

        assertNotNull(atividades);
        assertEquals(2, atividades.size());
        assertEquals("Atividade 1", atividades.get(0).getDescricao());
        assertEquals("Atividade 2", atividades.get(1).getDescricao());
    }

    @Test
    void buscarPorId_DeveRetornarAtividade_QuandoIdExistir() {
        Atividade atividade = new Atividade();
        atividade.setId(1L);
        atividade.setDescricao("Atividade 1");

        when(atividadeService.buscarPorId(1L)).thenReturn(atividade);

        Atividade atividadeEncontrada = atividadeController.buscarPorId(1L);

        assertNotNull(atividadeEncontrada);
        assertEquals("Atividade 1", atividadeEncontrada.getDescricao());
    }

    @Test
    void salvar_DeveRetornarAtividadeSalva() {
        Atividade atividade = new Atividade();
        atividade.setDescricao("Nova Atividade");

        when(atividadeService.salvar(any(Atividade.class))).thenReturn(atividade);

        Atividade atividadeSalva = atividadeController.salvar(atividade);

        assertNotNull(atividadeSalva);
        assertEquals("Nova Atividade", atividadeSalva.getDescricao());
    }

    @Test
    void excluir_DeveChamarMetodoExcluirDoServico() {
        Long id = 1L;

        atividadeController.excluir(id);

        verify(atividadeService, times(1)).excluir(id);
    }
}
