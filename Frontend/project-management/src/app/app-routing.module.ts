import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ClientesComponent} from "./components/clientes/clientes.component";
import {ProjetosComponent} from "./components/projetos/projetos.component";
import {AtividadesComponent} from "./atividades/atividades.component";

export const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'projetos', component: ProjetosComponent },
  { path: 'atividades', component: AtividadesComponent },
  { path: '', redirectTo: '/clientes', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
