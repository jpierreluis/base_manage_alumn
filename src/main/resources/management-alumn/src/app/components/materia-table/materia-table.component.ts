import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MateriaService } from 'src/app/services/materia.service';

@Component({
  selector: 'app-materia-table',
  templateUrl: './materia-table.component.html',
  styleUrls: ['./materia-table.component.css']
})
export class MateriaTableComponent implements OnInit {
  public list: any[] = [];
  public isLoading = true;

  constructor(private router:Router,
    private materiaService:MateriaService) { }

  ngOnInit(): void {
    this.findAll()
  }


  findAll(): void {
    this.list = [];
    this.materiaService.getAll().subscribe(response=>{
      this.isLoading = false
      this.list = response;
    },
    error=>{
      this.isLoading = false
    }); 
  }

  goToCreate(): void {
    this.router.navigate(['materia/registrar']);
  }
  selectItem(id:number):void{
    this.router.navigate(['materia/modificar',id]);
  }

}
