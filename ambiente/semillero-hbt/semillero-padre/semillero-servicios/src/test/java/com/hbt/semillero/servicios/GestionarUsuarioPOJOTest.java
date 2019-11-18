/**
 * GestionarUsuarioPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entities.EstadoUsuarioEnum;
import com.hbt.semillero.pojos.GestionarUsuarioPOJO;

/**
 * <b>Descripción:<b> Clase que realiza pruebas unitarias sobre la Entidad UsuarioDTO
 * GestionarUsuarioPOJO <b>Caso de Uso:<b>
 * 
 * @author Lenovo
 * @version
 */

public class GestionarUsuarioPOJOTest {

	/**
	 * 
	 * Metodo encargado de probar la generacion de nombres de usuario <b>Caso de
	 * Uso</b>
	 * 
	 * @author Lenovo
	 *
	 */
	@Test
	public void validarNombre() {
		GestionarUsuarioPOJO gestionarUsuarioPOJO = new GestionarUsuarioPOJO();

		// Nombre es invalido (mas caracteres de los permitidos)
		String nombre = "jkhsdf99";
		Assert.assertFalse(gestionarUsuarioPOJO.isValidUserName(nombre));

		// Nombre es invalido (segundo caracter no es un numero)
		nombre = "Aijhj";
		Assert.assertFalse(gestionarUsuarioPOJO.isValidUserName(nombre));
		
		// Nombre es invalido (demas caracteres no son todos en minuscula)
		nombre = "A8ii1i";
		Assert.assertFalse(gestionarUsuarioPOJO.isValidUserName(nombre));
		
		//Nombre es valido
		nombre = "B8avc";
		Assert.assertTrue(gestionarUsuarioPOJO.isValidUserName(nombre));
	}
	
	/**
	 * 
	 * Metodo encargado de validar si una cuenta esta expirada
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 *
	 */
	public void validarUsuarioCuentaExpirada() {
		PersonaDTO personaDTO = new PersonaDTO(1L, "Gabo", 178676L);
		UsuarioDTO usuarioDTO = new UsuarioDTO(1L, "B9scyx", LocalDate.of(2019, 10, 27), EstadoUsuarioEnum.ACTIVO, personaDTO);
		
		GestionarUsuarioPOJO gestionarUsuarioPOJO = new GestionarUsuarioPOJO();
		
		//No ha expirado la cuenta
		Assert.assertFalse(gestionarUsuarioPOJO.isAccountExpired(usuarioDTO));
		
		usuarioDTO.setFechaCreacion(LocalDate.of(2018, 06, 18));
		
		//Ha expirado la cuenta
		Assert.assertTrue(gestionarUsuarioPOJO.isAccountExpired(usuarioDTO));
		
	}

}
