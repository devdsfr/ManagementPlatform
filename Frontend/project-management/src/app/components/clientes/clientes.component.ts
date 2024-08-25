import { Component, OnInit } from '@angular/core';
import {ClienteService} from "../../services/cliente.service";
import {Cliente} from "../../models/cliente.model";

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  clientes: Cliente[] = [];
  novoCliente: Cliente = { id: 0, nome: '', email: '', telefone: '' };

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.carregarClientes();
  }

  carregarClientes(): void {
    this.clienteService.listarTodos().subscribe((clientes) => {
      this.clientes = clientes;
    });
  }

  salvar(): void {
    this.clienteService.salvar(this.novoCliente).subscribe(() => {
      this.carregarClientes();
      this.novoCliente = { id: 0, nome: '', email: '', telefone: '' };
    });
  }

  excluir(id: number): void {
    this.clienteService.excluir(id).subscribe(() => {
      this.carregarClientes();
    });
  }
}
