package com.plataforma.gestorpedidos.controllers;

import com.plataforma.gestorpedidos.entities.Atividade;
import com.plataforma.gestorpedidos.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/atividades")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> listarTodos() {
        return atividadeService.listarTodos();
    }

    @PostMapping
    public Atividade salvar(@RequestBody Atividade atividade) {
        return atividadeService.salvar(atividade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        atividadeService.excluir(id);
    }
}
