import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Materia } from 'src/app/models/materia';
import { MateriaService } from 'src/app/services/materia.service';

@Component({
  selector: 'app-materia-form',
  templateUrl: './materia-form.component.html',
  styleUrls: ['./materia-form.component.css']
})
export class MateriaFormComponent implements OnInit {
  @Input('id') id?:string;
  public materia: Materia = new Materia();
  form: FormGroup;


  constructor(private materiaService: MateriaService,
    public fb: FormBuilder,
    private router: Router) {
    this.form = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(4), Validators.maxLength(80)]]
    });
    
  }

  ngOnInit(): void {
    if(this.id != undefined){
      this.materiaService.getElement(this.id).subscribe(response=>{
        this.materia = response.body;
      },error=>{
        
      });

    }
  }

  save(): void {
    if(this.id != undefined){
      this.materia.id = parseInt(this.id);
    }
    
    this.materiaService.save(this.materia).subscribe(response => {
      console.log(response);
      this.router.navigate(['materia'])
    },error => {
        console.log(error);
      })
  }


  delete(): void {
    if(confirm("¿Deseas continuar?")){
      if (this.id != undefined) {
        this.materiaService.delete(this.id).subscribe(response => {
          console.log(response);
          this.router.navigate(['alumno'])
        }, error => {
          console.log(error);
        })
      }  
    }
  }


}
