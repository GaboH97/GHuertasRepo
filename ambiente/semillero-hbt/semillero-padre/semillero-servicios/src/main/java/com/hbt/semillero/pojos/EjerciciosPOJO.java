/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */

public class EjerciciosPOJO {

	
	private Map<String, Integer> winCount;
	
	/**
	 * Mapa que tiene la cantidad de monedas
	 */
	private Map<Integer, Integer> coinWithQuantity;
	
	private ArrayList<Integer> numbers;
	
	/**
	 * Constructor de la clase.
	 */
	public EjerciciosPOJO() {
		numbers = new ArrayList<Integer>();
		coinWithQuantity = new HashMap<>();		
	}
	
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
	
	/**
	 * 
	 * Metodo encargado de  agregar un numero a la lista de números
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 *
	 */
	public void addNumber(Integer number) {
		this.numbers.add(number);
	}
	
	/**
	 * 
	 * Metodo encargado de ordernar los números de menor a mayor
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 *
	 */
	public void sortNumbers() {
		Collections.sort(numbers);
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo numbers
	 * @return El numbers asociado a la clase
	 */
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
	
	public void obtenerCambio(Integer cambio){
		
		if (cambio/1000 >= 1) {
			coinWithQuantity.put(1000,cambio/1000);
		}
		
		cambio = cambio - (coinWithQuantity.get(1000)*1000);
		
		if (cambio/500 >= 1) {
			coinWithQuantity.put(500,cambio/500);
		}
		
		cambio = cambio - (coinWithQuantity.get(500)*500);
		if (cambio/200 >= 1) {
			coinWithQuantity.put(200,cambio/200);
		}
		
		cambio = cambio - (coinWithQuantity.get(200)*200);
	
		if (cambio/100 >= 1) {
			coinWithQuantity.put(100,cambio/100);
		}
		
		cambio = cambio - (coinWithQuantity.get(100)*100);
		
		if (cambio/50 >= 1) {
			coinWithQuantity.put(50,cambio/50);
		}		
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo coinWithQuantity
	 * @return El coinWithQuantity asociado a la clase
	 */
	public Map<Integer, Integer> getCoinWithQuantity() {
		return coinWithQuantity;
	}
	
	/**
	 * 
	 * Metodo encargado de lanzar una excepción
	 * 
	 * 		Opciones B y D.
	 * 
	 * <b>Caso de Uso</b>
	 * @author Lenovo
	 * @throws Exception 
	 *
	 */
	public void ejercicio9() throws Exception {
		
		throw new Exception();
	}
	
	
	
	
	
	
	
	
}
