package com.plataforma.gestorpedidos.controllers;

import com.plataforma.gestorpedidos.entities.Projeto;
import com.plataforma.gestorpedidos.services.ProjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjetoControllerTest {

    @InjectMocks
    private ProjetoController projetoController;

    @Mock
    private ProjetoService projetoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarPorStatus_DeveRetornarListaDeProjetosComStatus() {
        Projeto projeto1 = new Projeto();
        projeto1.setId(1L);
        projeto1.setNome("Projeto 1");
        projeto1.setStatus("em andamento");

        Projeto projeto2 = new Projeto();
        projeto2.setId(2L);
        projeto2.setNome("Projeto 2");
        projeto2.setStatus("em andamento");

        when(projetoService.listarPorStatus("em andamento")).thenReturn(Arrays.asList(projeto1, projeto2));

        List<Projeto> projetos = projetoController.listarPorStatus("em andamento");

        assertNotNull(projetos);
        assertEquals(2, projetos.size());
        assertEquals("Projeto 1", projetos.get(0).getNome());
        assertEquals("Projeto 2", projetos.get(1).getNome());
    }

    @Test
    void buscarPorId_DeveRetornarProjeto_QuandoIdExistir() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto 1");

        when(projetoService.buscarPorId(1L)).thenReturn(projeto);

        Projeto projetoEncontrado = projetoController.buscarPorId(1L);

        assertNotNull(projetoEncontrado);
        assertEquals("Projeto 1", projetoEncontrado.getNome());
    }

    @Test
    void salvar_DeveRetornarProjetoSalvo() {
        Projeto projeto = new Projeto();
        projeto.setNome("Novo Projeto");

        when(projetoService.salvar(any(Projeto.class))).thenReturn(projeto);

        Projeto projetoSalvo = projetoController.salvar(projeto);

        assertNotNull(projetoSalvo);
        assertEquals("Novo Projeto", projetoSalvo.getNome());
    }

    @Test
    void excluir_DeveChamarMetodoExcluirDoServico() {
        Long id = 1L;

        projetoController.excluir(id);

        verify(projetoService, times(1)).excluir(id);
    }
}
