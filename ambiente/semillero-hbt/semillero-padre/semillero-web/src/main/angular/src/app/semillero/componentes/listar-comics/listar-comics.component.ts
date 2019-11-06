import { Component, OnInit } from '@angular/core';
import { MiComicDTO } from '../../dto/miComicDTO';

/**
 * @description Componente que muestra información sobre comics
 * @author Gabriel Ricardo Amaya Huertas <gabriel970826@gmail.com>
 */
@Component({
  selector: 'listar-comics',
  templateUrl: './listar-comics.component.html',
  styleUrls: ['./listar-comics.component.css']
})
export class ListarComicsComponent implements OnInit {


  /**
     * variable que contiene los ComicDTO
     */
  public listaComics: Array<MiComicDTO>;

  /**
   * Flag para mostrar/esconder el mensaje
   */
  public mostrarMensaje: boolean = false;

  public nombreComicEliminado: string;

  constructor() { }

  ngOnInit() {
    this.listaComics = new Array<MiComicDTO>();

    let comic = new MiComicDTO(1, "batman", "marvel", "accion", 50, 60500.99, "Pedrito ",
      true, new Date("10/10/2019"), "activo");

    this.listaComics.push(comic);

    comic = new MiComicDTO(2, "superman", "marvel", "accion", 50, 60500.99, "Pedrito ",
      true, new Date("11/04/2018"), "activo");

    this.listaComics.push(comic);

    comic = new MiComicDTO(3, "Ironman", "marvel", "accion", 50, 60500.99, "Pedrito ",
      true, new Date("10/10/2015"), "activo");

    this.listaComics.push(comic);

    comic = new MiComicDTO(4, "Capitan America", "marvel", "accion", 50, 60500.99, "Pedrito ",
      true, new Date("10/10/2017"), "activo");

    this.listaComics.push(comic);

    comic = new MiComicDTO(5, "batman", "marvel", "accion", 50, 60500.99, "Pedrito ",
      true, new Date("10/11/2019"), "activo");

    this.listaComics.push(comic);

  }

  /**
   * Metodo que elimina el comic que esté en la posición [index]
   * @param index indice del comic a borrar
   */
  borrarComic(index:number){
    this.nombreComicEliminado = this.listaComics[index].nombre;
    this.listaComics.splice(index,1);
    this.mostrarMensaje = true; //Pone el flag en true para que aparezca el mensaje
  }

   /**
   * Metodo que cambia el valor del flag para ocultar el mensaje
   */
  ocultarMensaje(){
    this.mostrarMensaje = !this.mostrarMensaje;
  }

}
