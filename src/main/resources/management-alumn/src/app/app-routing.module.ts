import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MateriaComponent } from './pages/materia/materia.component';
import { MateriaCreateComponent } from './pages/materia-create/materia-create.component';
import { MateriaUpdateComponent } from './pages/materia-update/materia-update.component';

const routes: Routes = [

  {path:'materia',component:MateriaComponent},
  {path:'materia/registrar',component:MateriaCreateComponent},
  {path:'materia/modificar/:id',component:MateriaUpdateComponent},
  
  {path:'',redirectTo: '/materia', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
