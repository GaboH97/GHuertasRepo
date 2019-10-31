import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mi-componente',
  templateUrl: './mi-componente.component.html',
  styleUrls: ['./mi-componente.component.css']
})
export class MiComponenteComponent implements OnInit {

  public ciudad: string;
  public nombre: string;

  constructor() { 
    this.ciudad = "Tunja";
    this.nombre = "Gabriel Amaya Huertas";
  }

  ngOnInit() {
  }

}
