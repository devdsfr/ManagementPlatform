package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Cliente;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
import com.plataforma.gestorpedidos.repository.ClienteRepository;
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

class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

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

        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

        List<Cliente> clientes = clienteService.listarTodos();

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

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente clienteEncontrado = clienteService.buscarPorId(1L);

        assertNotNull(clienteEncontrado);
        assertEquals("Cliente 1", clienteEncontrado.getNome());
    }

    @Test
    void buscarPorId_DeveLancarExcecao_QuandoIdNaoExistir() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> clienteService.buscarPorId(1L));
    }

    @Test
    void salvar_DeveRetornarClienteSalvo() {
        Cliente cliente = new Cliente();
        cliente.setNome("Novo Cliente");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSalvo = clienteService.salvar(cliente);

        assertNotNull(clienteSalvo);
        assertEquals("Novo Cliente", clienteSalvo.getNome());
    }

    @Test
    void atualizar_DeveRetornarClienteAtualizado_QuandoIdExistir() {
        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(1L);
        clienteExistente.setNome("Cliente Existente");

        Cliente clienteAtualizado = new Cliente();
        clienteAtualizado.setNome("Cliente Atualizado");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(clienteExistente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteExistente);

        Cliente clienteResultado = clienteService.atualizar(1L, clienteAtualizado);

        assertNotNull(clienteResultado);
        assertEquals("Cliente Atualizado", clienteResultado.getNome());
    }

    @Test
    void excluir_DeveChamarMetodoDeleteDoRepository_QuandoIdExistir() {
        Long id = 1L;

        clienteService.excluir(id);

        verify(clienteRepository, times(1)).deleteById(id);
    }
}
