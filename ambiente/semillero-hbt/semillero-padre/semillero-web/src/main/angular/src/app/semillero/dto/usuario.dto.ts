import { PersonaDTO } from './persona.dto';

/**
 * @description Clase PersonaDTO que contiene la informacion de una persona
 * 
 * @author Gabriel Huertas <gabriel970826@gmail.com>
 */
export class UsuarioDTO {

    public id: number;
    public nombre: string;
    public fechaCreacion: Date;
    public estadoEnum: string;
    public persona: PersonaDTO;
    
}