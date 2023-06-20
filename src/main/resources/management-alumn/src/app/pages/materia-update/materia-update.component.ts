import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-materia-update',
  templateUrl: './materia-update.component.html',
  styleUrls: ['./materia-update.component.css']
})
export class MateriaUpdateComponent implements OnInit {
  public id?:string|null;

  constructor(private paramRoute:ActivatedRoute) { 
    this.id =  this.paramRoute.snapshot.paramMap.get('id')
  }

  ngOnInit(): void {
  }

}
