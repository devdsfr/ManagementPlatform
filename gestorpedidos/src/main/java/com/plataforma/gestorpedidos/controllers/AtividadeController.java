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
    @GetMapping("/{id}")
    public Atividade buscarPorId(@PathVariable Long id) {
        return atividadeService.buscarPorId(id);
    }

    @PostMapping
    public Atividade salvar(@RequestBody Atividade atividade) {
        return atividadeService.salvar(atividade);
    }
    @PutMapping("/{id}")  // Endpoint de atualização
    public Atividade atualizar(@PathVariable Long id, @RequestBody Atividade atividadeAtualizada) {
        return atividadeService.atualizar(id, atividadeAtualizada);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        atividadeService.excluir(id);
    }
}
