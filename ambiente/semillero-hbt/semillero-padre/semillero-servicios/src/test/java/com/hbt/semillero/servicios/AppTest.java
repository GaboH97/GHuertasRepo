package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

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

		Assert.assertEquals(321, actual);
	}

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}
}
