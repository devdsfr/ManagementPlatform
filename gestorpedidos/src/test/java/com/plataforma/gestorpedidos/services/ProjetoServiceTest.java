package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Projeto;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
import com.plataforma.gestorpedidos.repository.ProjetoRepository;
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

class ProjetoServiceTest {

    @InjectMocks
    private ProjetoService projetoService;

    @Mock
    private ProjetoRepository projetoRepository;

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

        when(projetoRepository.findByStatus("em andamento")).thenReturn(Arrays.asList(projeto1, projeto2));

        List<Projeto> projetos = projetoService.listarPorStatus("em andamento");

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

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        Projeto projetoEncontrado = projetoService.buscarPorId(1L);

        assertNotNull(projetoEncontrado);
        assertEquals("Projeto 1", projetoEncontrado.getNome());
    }

    @Test
    void buscarPorId_DeveLancarExcecao_QuandoIdNaoExistir() {
        when(projetoRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> projetoService.buscarPorId(1L));
    }

    @Test
    void salvar_DeveRetornarProjetoSalvo() {
        Projeto projeto = new Projeto();
        projeto.setNome("Novo Projeto");

        when(projetoRepository.save(any(Projeto.class))).thenReturn(projeto);

        Projeto projetoSalvo = projetoService.salvar(projeto);

        assertNotNull(projetoSalvo);
        assertEquals("Novo Projeto", projetoSalvo.getNome());
    }

    @Test
    void atualizar_DeveRetornarProjetoAtualizado_QuandoIdExistir() {
        Projeto projetoExistente = new Projeto();
        projetoExistente.setId(1L);
        projetoExistente.setNome("Projeto Existente");

        Projeto projetoAtualizado = new Projeto();
        projetoAtualizado.setNome("Projeto Atualizado");
        projetoAtualizado.setStatus("concluido");

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projetoExistente));
        when(projetoRepository.save(any(Projeto.class))).thenReturn(projetoExistente);

        Projeto projetoResultado = projetoService.atualizar(1L, projetoAtualizado);

        assertNotNull(projetoResultado);
        assertEquals("Projeto Atualizado", projetoResultado.getNome());
        assertEquals("concluido", projetoResultado.getStatus());
    }

    @Test
    void excluir_DeveChamarMetodoDeleteDoRepository_QuandoIdExistir() {
        Long id = 1L;

        projetoService.excluir(id);

        verify(projetoRepository, times(1)).deleteById(id);
    }
}
