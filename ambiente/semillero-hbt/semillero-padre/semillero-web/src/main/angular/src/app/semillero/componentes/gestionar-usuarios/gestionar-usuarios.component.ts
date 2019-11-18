import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PersonaDTO } from '../../dto/persona.dto';
import { PersonaService } from '../../services/persona.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UsuarioDTO } from '../../dto/usuario.dto';
import { UsuarioService } from '../../services/usuario.service';


@Component({
  selector: 'app-gestionar-usuarios',
  templateUrl: './gestionar-usuarios.component.html',
  styleUrls: ['./gestionar-usuarios.component.css']
})
export class GestionarUsuariosComponent implements OnInit {


  /**
   * Atributo que contiene los controles del formulario
   */
  public personaForm: FormGroup;

  /**
   * Atributo que contiene los controles del formulario
   */
  public usuarioForm: FormGroup;

  /**
   * Atributo que contendra la informacion de la persona
   */
  public persona: PersonaDTO;

  /**
   * Atributo que contendra la informacion de la persona
   */
  public usuario: UsuarioDTO;

  /**
     * Atributo que contendra la lista de personas creados
     */
  public listaPersonas: Array<PersonaDTO>;

  /**
     * Atributo que contendra la lista de personas creados
     */
  public listaUsuarios: Array<UsuarioDTO>;

  /**
   * Atributo que indica si se envio a validar el formulario
   */
  public submittedPersona: boolean;

   /**
   * Atributo que indica si se envio a validar el formulario
   */
  public submittedUsuario: boolean;

  /**
 * @description Este es el constructor del componente CrearPersonaFormComponent
 * @author Gabriel Huertas <gabriel970826@gmail.com>
 */
  constructor(private personaService: PersonaService,
    private usuarioService: UsuarioService,
    private router: Router, 
    private activatedRoute: ActivatedRoute,
    private fb: FormBuilder) {

    this.personaForm = this.fb.group({
      nombre: [null, Validators.required],
      numIdentificacion: [null, Validators.required]
    });

    this.usuarioForm = this.fb.group({
      fechaCreacion: [null, Validators.required],
      estadoEnum: [null],
      persona: [null, Validators.required]
    });

  }

  ngOnInit() {
    this.persona = new PersonaDTO();
    this.persona = new PersonaDTO();
    this.listaPersonas = new Array<PersonaDTO>();
    this.listaUsuarios = new Array<UsuarioDTO>();
    this.consultarPersonas();
    this.consultarUsuarios();
  }

  /**
     * @description Metodo encargado de consultar las personas existentes
     * @author Gabriel Huertas <dalvarez@heinsohn.com.co>
     */
  public consultarPersonas(): void {
    this.personaService.consultarPersonas().subscribe(listaPersonas => {
      this.listaPersonas = listaPersonas;
    }, error => {
      alert(error);
      console.log(error);
    });
  }

  /**
     * @description Metodo encargado de consultar los usuarios existentes
     * @author Gabriel Huertas <gabriel970826@gmail.com>
     */
  public consultarUsuarios(): void {
    this.usuarioService.consultarUsuarios().subscribe(listaUsuarios => {
      this.listaUsuarios = listaUsuarios;
    }, error => {
      alert(error);
      console.log(error);
    });
  }


  /**
     * @description Metodo que permite validar el formulario y crear una persona
     * @author Gabriel Huertas <gabriel970826@gmail.com>
     */
  public crearPersona(): void {
    this.submittedPersona = true;
    if (this.personaForm.invalid) {
      return;
    }
    this.persona = new PersonaDTO();
    this.persona.nombre = this.personaForm.controls.nombre.value;
    this.persona.numIdentificacion = this.personaForm.controls.numIdentificacion.value;

    this.personaService.crearPersona(this.persona).subscribe(resultadoDTO => {
      if (resultadoDTO.exitoso) {
        alert(resultadoDTO.mensajeEjecucion);
        this.consultarPersonas();
        this.limpiarFormularioPersona();
      }
    }, error => {
      alert(error);
    });

    this.limpiarFormularioPersona();
  }

  /**
     * @description Metodo que permite limpiar el formulario de creación de Persona
     * @author Gabriel Huertas <gabriel970826@gmail.com>
     */
  private limpiarFormularioPersona(): void {
    this.submittedPersona = false;
    this.personaForm.controls.nombre.setValue(null);
    this.personaForm.controls.numIdentificacion.setValue(null);
  }

  /**
     * @description Metodo que permite limpiar el formulario de creación de Usuario
     * @author Gabriel Huertas <gabriel970826@gmail.com>
     */
  private limpiarFormularioUsuario(): void {
    this.submittedUsuario = false;
    this.personaForm.controls.nombre.setValue(null);
    this.personaForm.controls.numIdentificacion.setValue(null);
  }

    /**
 * @description Método que permite enviar los datos del formulario hacia para persisitr un usuario en
 * la base de datos
 * @author Gabriel Huertas <gabriel970826@gmail.com>
 */
  public crearUsuario(): void {
    this.submittedUsuario = true;
    if (this.usuarioForm.invalid) {
      console.log("se totio")
      return;
    }

    this.usuario = new UsuarioDTO();
    this.usuario.fechaCreacion = this.usuarioForm.controls.fechaCreacion.value;
    this.usuario.estadoEnum = this.usuarioForm.controls.estadoEnum.value;
    this.usuario.persona = this.usuarioForm.controls.persona.value;

    console.log("esta es "+this.usuario.persona.nombre);

    this.usuarioService.crearUsuario(this.usuario).subscribe(resultadoDTO => {
      if (resultadoDTO.exitoso) {
        alert(resultadoDTO.mensajeEjecucion);
        this.consultarUsuarios();
        this.limpiarFormularioUsuario();
      }
    }, error => {
      alert(error);
    });

    this.limpiarFormularioUsuario();
  }

    /**
 * @description Método para inactivar un usuario
 * @author Gabriel Huertas <gabriel970826@gmail.com>
 */
  public inactivarUsuario(id: number): void{
    this.usuarioService.inactivarUsuario(id).subscribe(usuarioDTO => {

    }, error => {
      alert(error);
    });
  }

  /**
   * @description Metodo que obtiene los controles y sus propiedades
   * @author Gabriel Huertas <gabriel970826@gmail.com>
   */
  get f() {
    return this.personaForm.controls;
  }

}
