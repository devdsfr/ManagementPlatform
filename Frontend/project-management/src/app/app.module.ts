import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AtividadesComponent} from "./atividades/atividades.component";
import {ClientesComponent} from "./components/clientes/clientes.component";
import {ProjetosComponent} from "./components/projetos/projetos.component";
import {HomeComponent} from "./components/home/home.component";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

@NgModule({
  declarations: [
    AppComponent,
    AtividadesComponent,
    ClientesComponent,
    ProjetosComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
