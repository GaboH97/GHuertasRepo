import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { PersonaDTO } from '../dto/persona.dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  
  constructor(private http: HttpClient, private router: Router) { }

  crearPersona(persona: PersonaDTO): Observable<any> {
    return this.http.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crearPersona', persona);
  }
  
  consultarPersonas(): Observable<any>{
    return this.http.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarPersonas');
  }
}
