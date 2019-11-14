package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entities.EstadoEnum;
import com.hbt.semillero.entities.TematicaEnum;
import com.hbt.semillero.pojos.GestionarComicPOJO;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}

	@Test(enabled = false)
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L;
		Long sumando2 = 50L;

		Long resultado = sumando1 + sumando2;

		Assert.assertEquals(resultado, resultadoEsperado);

		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}

	@Test(enabled = false)
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

	@Test(enabled = false)
	public void terceraPU() {

		// Instanciar un enum de la clase EstadoEnum
		EstadoEnum estado = EstadoEnum.ACTIVO;

		// Devolver un String con el nombre de la constante Activo
		String estadoAsString = estado.name();

		// Devolver un entero con la posición del enum según está declarada
		int posEstado = estado.ordinal();

		// Comparar el enum con el parámetro según está declarado el enum

		int expectedPos = 0;

		// Assert para la posición de ACTIVO
		Assert.assertEquals(posEstado, expectedPos);

		// Assert para la posición de INACTIVO
		estado = EstadoEnum.INACTIVO;
		posEstado = estado.ordinal();
		expectedPos = 1;

		Assert.assertEquals(posEstado, expectedPos);

		// Devolver un array que contiene todos los enum
		EstadoEnum[] estados = EstadoEnum.values();

		Arrays.asList(estados).forEach(System.out::println);

	}

	@Test(enabled = false)
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

//	@Test
//	public void creartComicDTOTest() {
//		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
//
//		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics",
//				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000),
//				"Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), "ACTIVO", 5L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//
//		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
//		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
//
//		comicDTO = new ComicDTO();
//
//		comicDTO.setId("100");
//		comicDTO.setNombre("Dragon ball Yamcha");
//		comicDTO.setEditorial("Planeta Cómic");
//		comicDTO.setTematica(TematicaEnum.AVENTURAS);
//		comicDTO.setColeccion("Manga Shonen");
//		comicDTO.setNumeroPaginas(100);
//		comicDTO.setPrice(new BigDecimal(2100));
//		comicDTO.setAutores("Dragon Garow Lee");
//		comicDTO.setColor(Boolean.TRUE);
//		comicDTO.setFechaVenta(LocalDate.now());
//		comicDTO.setEstado("ACTIVO");
//		comicDTO.setCantidad(20L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() > 1);
//
//		comicDTO = new ComicDTO();
//
//		comicDTO.setId("100");
//		comicDTO.setNombre("Dragon ball Yamcha");
//		comicDTO.setEditorial("Planeta Cómic");
//		comicDTO.setTematica(TematicaEnum.AVENTURAS);
//		comicDTO.setColeccion("Manga Shonen");
//		comicDTO.setNumeroPaginas(100);
//		comicDTO.setPrice(new BigDecimal(2100));
//		comicDTO.setAutores("Dragon Garow Lee");
//		comicDTO.setColor(Boolean.TRUE);
//		comicDTO.setFechaVenta(LocalDate.now());
//		comicDTO.setEstado("ACTIVO");
//		comicDTO.setCantidad(20L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
//	}

	@Test
	public void agregarComicDTOLista() {

	}

	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
		}
		return cadenaInvertida;
	}

	@Test
	public void comparaCadenas() {
		String s1 = "street";
		String s2;
		 s2 = new String("street");
	
		Assert.assertEquals(s1, s2);
		Assert.assertTrue(s1 == s2);
	}

	// TODO
	/**
	 * Pediente hacer un método que use el método ToString de la entidad COMIC
	 */
}
