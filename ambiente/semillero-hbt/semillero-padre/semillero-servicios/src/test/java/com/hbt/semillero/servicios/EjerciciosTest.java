/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.util.IntSummaryStatistics;

import javax.ejb.Local;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojos.EjerciciosPOJO;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */
public class EjerciciosTest {

	private static String brand;
	private static boolean empty;

	@Test
	public void ejercicio1() {
		String caso1 = "A$B";
	}

	@Test
	public static void ejercicio2() {
		System.out.println("Empty=" + empty);
		System.out.println("Brand" + brand);
	}

	@Test
	public void ejercicio3() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();

		// Es primo
		int number = 5;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), true);

		// No es primo
		number = 222;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), false);

		// No es primo
		number = 0;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), false);
	}

	@Test
	public void ejercicio4() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();

		LocalDate birthDate = LocalDate.of(1997, 8, 26);

		LocalDate thisYearDate = ejerciciosPOJO.addYears(birthDate, 22);

		LocalDate now = LocalDate.now();

		Assert.assertTrue(thisYearDate.getYear() == now.getYear());
	}

	@Test
	public void ejercicio5() {
		EjerciciosPOJO ejerciciosPojo = new EjerciciosPOJO();

		int number = 50;
		ejerciciosPojo.addNumber(number);
		number = 1;
		ejerciciosPojo.addNumber(number);
		number = 249;
		ejerciciosPojo.addNumber(number);
		number = -2;
		ejerciciosPojo.addNumber(number);

		ejerciciosPojo.sortNumbers();

		IntSummaryStatistics summary = ejerciciosPojo.getNumbers().stream().mapToInt(n -> n).summaryStatistics();

		int min = summary.getMin();

		int max = summary.getMax();

		Long count = summary.getCount();
		
		//Verifica valor minimo
		Assert.assertTrue(min == -2);
		//Verifica valor máximo

		Assert.assertTrue(max == 249);
		//Verifica cantidad de elementos

		Assert.assertTrue(count == 4);
	}
	
	@Test
	public void ejercicio8() {
		EjerciciosPOJO ejerciciosPojo = new EjerciciosPOJO();
		
	}
	
	public void ejercicio11() {
		int number = 23;
		
		EjerciciosPOJO ejerciciosPojo = new EjerciciosPOJO();
		
		int nextNumb = ejerciciosPojo.getNextNumber(number);
		
		Assert.assertEquals(nextNumb, 33);

	}

}
