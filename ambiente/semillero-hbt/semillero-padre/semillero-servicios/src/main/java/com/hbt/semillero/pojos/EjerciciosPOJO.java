/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojos;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */


public class EjerciciosPOJO {

	
	public boolean ejercicio1(String identifier) {
		return Character.isJavaIdentifierStart(identifier.charAt(0))
				&& identifier.substring(1,identifier.length()-1).chars().allMatch(Character::isJavaIdentifierPart);
	}
}
