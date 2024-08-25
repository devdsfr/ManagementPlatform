package com.plataforma.gestorpedidos.controllers;

import com.plataforma.gestorpedidos.entities.Projeto;
import com.plataforma.gestorpedidos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> listarPorStatus(@RequestParam String status) {
        return projetoService.listarPorStatus(status);
    }

    @GetMapping("/{id}")
    public Projeto buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id);
    }

    @PostMapping
    public Projeto salvar(@RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }
    @PutMapping("/{id}")  // Endpoint de atualização
    public Projeto atualizar(@PathVariable Long id, @RequestBody Projeto projetoAtualizado) {
        return projetoService.atualizar(id, projetoAtualizado);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        projetoService.excluir(id);
    }
}