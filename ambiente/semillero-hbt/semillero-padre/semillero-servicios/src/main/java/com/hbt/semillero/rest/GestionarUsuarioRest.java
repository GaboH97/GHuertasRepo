/**
 * GestionarUsuarioRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;

/**
 * <b>Descripción:<b> Clase que contiene los endpoints de los servicios para ser
 * consumidos a través de HTTP <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */

@Path("/GestionarUsuario")
public class GestionarUsuarioRest {

	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;
	
	
	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para crear un usuario
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		ResultadoDTO resultadoDTO  = null;
		try {
			gestionarUsuarioEJB.crearPersona(personaDTO);
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creada exitosamente");
		} catch (Exception e) {
			resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error: "+e.getMessage());
			
		}
		return resultadoDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para crear un usuario
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	@POST
	@Path("/crearUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearUsuario(UsuarioDTO usuarioDTO) {
		ResultadoDTO resultadoDTO  = null;
		try {
			gestionarUsuarioEJB.crearUsuario(usuarioDTO);
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Usuario creado exitosamente");
		} catch (Exception e) {
			resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error: "+e.getMessage());
			
		}
		return resultadoDTO;
	}
	
	
	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para consultar los usuarios
	 * 
	 * <b>Caso de Uso</b>
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultarUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();
	}
	
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas() {
		return gestionarUsuarioEJB.consultarPersonas();
	}
	
	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para consultar un usuario 
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * 
	 * @param idUsuario
	 * @return
	 */
	@GET
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario != null) {
			return gestionarUsuarioEJB.consultarUsuario(idUsuario);
		}
		return null;
	}

	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para modificar el nombre de un usuario
	 * 
	 * @param idComic identificador del usuario a buscar
	 * @param nombre nombre nuevo del usuario
	 */
	@PUT
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarUsuario(@QueryParam("idUsuario") Long idUsuario, @QueryParam("nombre") String nombre) {
		ResultadoDTO resultadoDTO  = null;

		try {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.modificarNombreUsuario(idUsuario, nombre, null);
			resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Nombre de usuario modificado a "+usuarioDTO.getNombre());

		} catch (Exception e) {
			resultadoDTO = new ResultadoDTO(Boolean.FALSE, "Error: "+e.getMessage());
		}
		return resultadoDTO;
	}

	/**
	 * 
	 * Metodo encargado de ofrecer el servicio para inactivar un usuario
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/inactivar")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO inactivarUsuario(@QueryParam("idUsuario") Long idUsuario) {
		if (idUsuario != null) {
			
			UsuarioDTO usuarioInactivado = gestionarUsuarioEJB.inactivarUsuario(idUsuario);
			return usuarioInactivado;
		}
		return null;
	}
}
