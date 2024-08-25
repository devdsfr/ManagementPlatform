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

    @PostMapping
    public Projeto salvar(@RequestBody Projeto projeto) {
        return projetoService.salvar(projeto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        projetoService.excluir(id);
    }
}