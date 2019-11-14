import { Component, OnInit } from '@angular/core';
import { ComicDTO } from '../../dto/comic.dto';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import {Location} from '@angular/common';

/**
 * @description Componenete consultar comic que muestra los atributos de un comic
 * 
 * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com.co>
 */
@Component({
  selector: 'consultar-comic',
  templateUrl: './consultar-comic.component.html',
  styleUrls: ['./consultar-comic.component.css']
})
export class ConsultarComicComponent implements OnInit {

  public comic: ComicDTO;
  public gestionarComicForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder, private activatedRoute: ActivatedRoute, private _location: Location) {
    this.gestionarComicForm = this.fb.group({
      nombre: [null, Validators.required],
      editorial: [null],
      tematica: [null],
      coleccion: [null],
      numeroPaginas: [null],
      precio: [null],
      autores: [null], 
      color: [null]
    });
  }

  /**
   * Método que inicializa los valores de este componente
   * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com.co>
   */
  ngOnInit() {
    let data = this.activatedRoute.snapshot.params;
    console.log(data);
    this.comic = data as ComicDTO;
    this.consultarComic(this.comic);
  }

  /**
   * Método que muestra los valores del comic en un formulario (read-only)
   * @param comic 
   * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com.co>
   */
  public consultarComic(comic: ComicDTO):void{
    this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
    this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
    this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
    this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
    this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
    this.gestionarComicForm.controls.precio.setValue(comic.precio);
    this.gestionarComicForm.controls.autores.setValue(comic.autores);
    this.gestionarComicForm.controls.color.setValue(comic.color);
    this.gestionarComicForm.controls.nombre.disable();
    this.gestionarComicForm.controls.editorial.disable();
    this.gestionarComicForm.controls.tematica.disable();
    this.gestionarComicForm.controls.coleccion.disable();
    this.gestionarComicForm.controls.numeroPaginas.disable();
    this.gestionarComicForm.controls.precio.disable();
    this.gestionarComicForm.controls.autores.disable();
    this.gestionarComicForm.controls.color.disable();
  }

  /**
   * Método que regresa a la página anterior
   * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com.co>
   */
  public volver(): void{
    this._location.back();
  }
}
