/**
 * GestionarComicRest.java
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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Lenovo
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	@GET()
	@Path("/saludo")
	public String primerRest() {
		return "Mi primer rest";
	}
	
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComicDTO> consultarComics(){
		return gestionarComicEJB.consultarComics();
	}
	
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic!=null) {
			gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un usuario
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic
	 */
	@PUT
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public void modificarComic(@QueryParam("idComic") Long idComic, @QueryParam("nombre") String nombre) {
		gestionarComicEJB.modificarComic(idComic, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			ComicDTO comicDTO = gestionarComicEJB.consultarComic(idComic.toString());

		}
	}
}
