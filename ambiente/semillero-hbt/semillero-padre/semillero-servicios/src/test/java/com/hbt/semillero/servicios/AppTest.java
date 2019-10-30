package com.hbt.semillero.servicios;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entities.EstadoEnum;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;

		Long resultado = sumando1 + sumando2;

		Assert.assertEquals(resultado, resultadoEsperado);

		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	@Test
	public void segundaPU() {

		// Example 1: Succesful case
		String example = "abcde";

		String actual = invertirCadena(example);

		String expected = "edcba";

		Assert.assertEquals(actual, expected);

		// Example 2: Succesful case (empty string)
		example = "";

		actual = invertirCadena(example);

		expected = "";

		Assert.assertEquals(actual, expected);

		// Example 3: Unsucessful case (Strings are not equal)
		example = "abcde";

		actual = invertirCadena(example);

		expected = "edcby";

		Assert.assertNotEquals(actual, expected);

		// Example 4: Unsucessful case (Empty string)
		example = "";

		actual = invertirCadena(example);

		expected = "edcba";

		Assert.assertNotEquals(actual, expected);

		// Example 4: Unsucessful case (Unequal data types)

		example = "123";

		actual = invertirCadena(example);

		int exp = 321;

		Assert.assertNotEquals(321, actual);
	}
	
	@Test
	public void terceraPU() {
		
		//Instanciar un enum de la clase EstadoEnum
		EstadoEnum estado = EstadoEnum.ACTIVO;
		
		//Devolver un String con el nombre de la constante Activo
		String estadoAsString = estado.name();
		
		//Devolver un entero con la posición del enum según está declarada
		int posEstado = estado.ordinal();
		
		//Comparar el enum con el parámetro según está declarado el enum
		
		int expectedPos = 0; 
		
		//Assert para la posición de ACTIVO
		Assert.assertEquals(posEstado, expectedPos);
		
		
		//Assert para la posición de INACTIVO
		estado = EstadoEnum.INACTIVO;
		posEstado = estado.ordinal();
		expectedPos = 1;
				
		Assert.assertEquals(posEstado, expectedPos);
		
		//Devolver un array que contiene todos los enum
		EstadoEnum[] estados = EstadoEnum.values();
		
		Arrays.asList(estados).forEach(System.out::println);
		
	}
	

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
	
	//TODO
    /**
     * Pediente hacer un método que use el método ToString de la entidad COMIC
     */
}
