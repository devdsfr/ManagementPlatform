import { Component, OnInit } from '@angular/core';
import {Projeto} from "../../models/projeto.model";
import {ProjetoService} from "../../services/projeto.service";

@Component({
  selector: 'app-projetos',
  templateUrl: './projetos.component.html',
  styleUrls: ['./projetos.component.css']
})
export class ProjetosComponent implements OnInit {
  projetos: Projeto[] = [];
  novoProjeto: Projeto = { id: 0, nome: '', status: '', clienteId: 0 };

  constructor(private projetoService: ProjetoService) {}

  ngOnInit(): void {
    this.carregarProjetos();
  }

  carregarProjetos(): void {
    this.projetoService.listarPorStatus('aberto').subscribe((projetos) => {
      this.projetos = projetos;
    });
  }

  salvar(): void {
    this.projetoService.salvar(this.novoProjeto).subscribe(() => {
      this.carregarProjetos();
      this.novoProjeto = { id: 0, nome: '', status: '', clienteId: 0 };
    });
  }

  excluir(id: number): void {
    this.projetoService.excluir(id).subscribe(() => {
      this.carregarProjetos();
    });
  }
}
