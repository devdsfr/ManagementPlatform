package com.plataforma.gestorpedidos.controllers;

import com.plataforma.gestorpedidos.entities.Cliente;
import com.plataforma.gestorpedidos.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodos_DeveRetornarListaDeClientes() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Cliente 1");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Cliente 2");

        when(clienteService.listarTodos()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteController.listarTodos();

        assertNotNull(clientes);
        assertEquals(2, clientes.size());
        assertEquals("Cliente 1", clientes.get(0).getNome());
        assertEquals("Cliente 2", clientes.get(1).getNome());
    }

    @Test
    void buscarPorId_DeveRetornarCliente_QuandoIdExistir() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Cliente 1");

        when(clienteService.buscarPorId(1L)).thenReturn(cliente);

        Cliente clienteEncontrado = clienteController.buscarPorId(1L);

        assertNotNull(clienteEncontrado);
        assertEquals("Cliente 1", clienteEncontrado.getNome());
    }

    @Test
    void salvar_DeveRetornarClienteSalvo() {
        Cliente cliente = new Cliente();
        cliente.setNome("Novo Cliente");

        when(clienteService.salvar(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSalvo = clienteController.salvar(cliente);

        assertNotNull(clienteSalvo);
        assertEquals("Novo Cliente", clienteSalvo.getNome());
    }

    @Test
    void excluir_DeveChamarMetodoExcluirDoServico() {
        Long id = 1L;

        clienteController.excluir(id);

        verify(clienteService, times(1)).excluir(id);
    }
}
