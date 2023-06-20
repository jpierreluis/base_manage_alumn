import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { MenuHeaderComponent } from './layouts/menu-header/menu-header.component';
import { SideSubMenuComponent } from './layouts/side-sub-menu/side-sub-menu.component';
import { MateriaComponent } from './pages/materia/materia.component';
import { MateriaTableComponent } from './components/materia-table/materia-table.component';
import { LoadingSpinnerComponent } from './components/loading-spinner/loading-spinner.component';
import { MateriaCreateComponent } from './pages/materia-create/materia-create.component';
import { MateriaFormComponent } from './components/materia-form/materia-form.component';
import { ContextualMenuComponent } from './components/contextual-menu/contextual-menu.component'
import { ReactiveFormsModule } from '@angular/forms';
import { MateriaUpdateComponent } from './pages/materia-update/materia-update.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuHeaderComponent,
    SideSubMenuComponent,
    MateriaComponent,
    MateriaTableComponent,
    LoadingSpinnerComponent,
    MateriaCreateComponent,
    MateriaFormComponent,
    ContextualMenuComponent,
    MateriaUpdateComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
