import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contextual-menu',
  templateUrl: './contextual-menu.component.html',
  styleUrls: ['./contextual-menu.component.css']
})
export class ContextualMenuComponent implements OnInit {
  constructor() { }

  isvisible: boolean = false;

  ngOnInit(): void {
  }

  clickToShow(){
    this.isvisible = !this.isvisible;
  }

}
