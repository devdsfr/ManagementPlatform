import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Projeto} from "../models/projeto.model";

@Injectable({
  providedIn: 'root'
})
export class ProjetoService {
  private baseUrl = 'http://localhost:8080/projetos';

  constructor(private http: HttpClient) {}

  listarPorStatus(status: string): Observable<Projeto[]> {
    return this.http.get<Projeto[]>(`${this.baseUrl}?status=${status}`);
  }

  salvar(projeto: Projeto): Observable<Projeto> {
    return this.http.post<Projeto>(`${this.baseUrl}`, projeto);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
