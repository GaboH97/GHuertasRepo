/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojos;

import java.time.LocalDate;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */

public class EjerciciosPOJO {

	public boolean ejercicio1(String identifier) {
		return Character.isJavaIdentifierStart(identifier.charAt(0))
				&& identifier.substring(1, identifier.length() - 1).chars().allMatch(Character::isJavaIdentifierPart);
	}
	
	/**
	 * 
	 * Metodo encargado de mirar si un número es primo
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas 
	 * 
	 * @param number
	 * @return
	 */
	public boolean isprime(int number) {
		boolean isPrime = true;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	/**
	 * 
	 * Metodo encargado de sumar n años a la edad de una persona
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * 
	 * @param birthDate
	 * @param years
	 * @return
	 */
	public LocalDate addYears(LocalDate birthDate, int years) {
		return birthDate.plusYears(years);
	}
}
