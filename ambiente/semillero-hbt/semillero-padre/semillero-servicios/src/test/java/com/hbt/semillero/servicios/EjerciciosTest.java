/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import java.time.LocalDate;

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
		
		//Es primo
		int number = 5;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), true);
		
		//No es primo
		number = 222;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), false);
		
		//No es primo
		number = 0;
		Assert.assertEquals(ejerciciosPOJO.isprime(number), false);
	}
	
	@Test
	public void ejercicio4() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		
		LocalDate birthDate = LocalDate.of(1997, 8, 26);
		
		LocalDate thisYearDate = ejerciciosPOJO.addYears(birthDate, 22);
		
		LocalDate now = LocalDate.now();
		
		Assert.assertTrue(thisYearDate.getYear()== now.getYear());
	}

}
