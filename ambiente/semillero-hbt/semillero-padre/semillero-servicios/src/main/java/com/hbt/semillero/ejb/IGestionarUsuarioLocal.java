/**
 * IGestionarUsuarioLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.UsuarioDTO;

/**
 * <b>Descripción:<b> Clase que expone los métodos del EJB GestionarUsuario
 * 
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */
@Local
public interface IGestionarUsuarioLocal {
	
	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @param comicNuevo informacion nueva a crear
	 * @throws Exception 
	 */
	public void crearUsuario(UsuarioDTO comicNuevo) throws Exception;

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un usuario
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @param nombre a modificar informacion nueva a modificar
	 * @return 
	 * @throws Exception 
	 */
	public UsuarioDTO modificarNombreUsuario(Long id, String nombre, UsuarioDTO usuarioDTONuevo) throws Exception;

	/**
	 * 
	 * Metodo encargado de cambiar el estado de un usuario de ACTIVO a INACTIVO
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @param idUsuario informacion a eliminar
	 * @return 
	 */
	public UsuarioDTO inactivarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un Usuario que ese busca por su ID
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @param idComic identificador del comic a ser consultado
	 * @return comic Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public UsuarioDTO consultarUsuario(Long idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar una lista de usuarios
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
}
