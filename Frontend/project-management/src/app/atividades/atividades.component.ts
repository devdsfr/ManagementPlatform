import { Component, OnInit } from '@angular/core';
import {Atividade} from "../models/atividade.model";
import {AtividadeService} from "../services/atividade.service";

@Component({
  selector: 'app-atividades',
  templateUrl: './atividades.component.html',
  styleUrls: ['./atividades.component.css']
})
export class AtividadesComponent implements OnInit {
  atividades: Atividade[] = [];
  novaAtividade: Atividade = { id: 0, descricao: '', dataInicio: '', dataFim: '', projetoId: 0 };

  constructor(private atividadeService: AtividadeService) {}

  ngOnInit(): void {
    this.carregarAtividades();
  }

  carregarAtividades(): void {
    this.atividadeService.listarTodos().subscribe((atividades) => {
      this.atividades = atividades;
    });
  }

  salvar(): void {
    this.atividadeService.salvar(this.novaAtividade).subscribe(() => {
      this.carregarAtividades();
      this.novaAtividade = { id: 0, descricao: '', dataInicio: '', dataFim: '', projetoId: 0 };
    });
  }

  excluir(id: number): void {
    this.atividadeService.excluir(id).subscribe(() => {
      this.carregarAtividades();
    });
  }
}
