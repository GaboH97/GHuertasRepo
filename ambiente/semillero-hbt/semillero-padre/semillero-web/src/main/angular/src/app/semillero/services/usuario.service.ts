import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioDTO } from '../dto/usuario.dto';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {


  constructor(private http: HttpClient, private router: Router) { }

  crearUsuario(usuario: UsuarioDTO): Observable<any> {
    return this.http.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crearUsuario', usuario);
  }

  consultarUsuarios(): Observable<any>{
    return this.http.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuarios');
  }

  inactivarUsuario(idUsuario: number): Observable<any>{
    return this.http.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/inactivar',{ "idUsuario": idUsuario});
  }
}
