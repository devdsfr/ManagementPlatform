import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Atividade } from '../models/atividade.model';

@Injectable({
  providedIn: 'root'
})
export class AtividadeService {
  private baseUrl = 'http://localhost:8080/atividades';

  constructor(private http: HttpClient) {}

  listarTodos(): Observable<Atividade[]> {
    return this.http.get<Atividade[]>(`${this.baseUrl}`);
  }

  salvar(atividade: Atividade): Observable<Atividade> {
    return this.http.post<Atividade>(`${this.baseUrl}`, atividade);
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
