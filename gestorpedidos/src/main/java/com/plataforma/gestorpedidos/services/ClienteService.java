package com.plataforma.gestorpedidos.services;

import com.plataforma.gestorpedidos.entities.Cliente;
import com.plataforma.gestorpedidos.repository.ClienteRepository;
import com.plataforma.gestorpedidos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + id));
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id);
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        return clienteRepository.save(clienteExistente);
    }
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }


}