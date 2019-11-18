import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';
import { AbstractService } from '../services/template.service';

/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
   
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public crearComic(comicDTO : ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear',comicDTO);
  }

  public editarComic(comicDTO: ComicDTO): Observable<any>{
    return this.httpClient.put('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',{
      'idComic':comicDTO.id,
      'nombre': comicDTO.nombre
    });
  }

  public eliminarComic(idComic: string): Observable<any>{
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',{
      'idComic':idComic
    });
  }



}
