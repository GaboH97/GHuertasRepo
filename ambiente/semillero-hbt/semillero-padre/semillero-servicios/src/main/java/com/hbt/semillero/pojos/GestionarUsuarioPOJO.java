/**
 * GestionarUsuarioPOJO.java
 */
package com.hbt.semillero.pojos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entities.Usuario;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */
public class GestionarUsuarioPOJO {
	
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
	
    /**
	 * 
	 * Metodo encargado de generar un nombre de usuario
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @return nombre generado aleatoriamente
	 */
	public String generateUserName() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		
		//Primer caracter en mayuscula
		int charPos = random.nextInt(CHAR_UPPER.length());
        builder.append(CHAR_UPPER.charAt(charPos));
        
        //Segundo caracter número
        charPos = random.nextInt(NUMBER.length());
        builder.append(NUMBER.charAt(charPos));
        
        //Hasta 5 caracteres en minúscula
        for (int i = 0; i <= random.nextInt(6); i++) {
        	 charPos = random.nextInt(CHAR_LOWER.length());
             builder.append(CHAR_LOWER.charAt(charPos));
		}
        
        return builder.toString();
	}
	
	/**
	 * 
	 * Metodo encargado de validar que un nombre sea valido. Esto cumpliendo las siguientes condiciones
	 * 
	 * 1. no debe ser mayor de 7 caracteres
	 * 2. El primer caracter debe ser una letra en mayúsculas 
	 * 3. El segundo caracter debe ser un numero de 0 a 9
	 * 4. Los restantes caracteres solo pueden ser letras en minúsculas
	 * 
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param name
	 * @return true si el nombre cumple con todas las condiciones, de lo contrario false
	 */
	public boolean isValidUserName(String name) {
		return name.length()<=7 
				&& Character.isUpperCase(name.charAt(0)) 
				&& Character.isDigit(name.charAt(1))
				&& name.substring(2, name.length()-1).chars().allMatch(Character::isLowerCase);
	}
	
	/**
	 * 
	 * Metodo encargado de verificar si un usuario tiene la cuenta expirada
	 * 
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean isAccountExpired(UsuarioDTO usuario) {
		long yearsBetween = ChronoUnit.YEARS.between(usuario.getFechaCreacion(), LocalDate.now());
		return yearsBetween > 0;
	}
}
