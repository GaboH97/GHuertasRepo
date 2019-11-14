/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entities.TematicaEnum;
import com.hbt.semillero.pojos.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina las pruebas unitarias para la gestión de comics
 * @author Gabriel Huertas
 * @version 
 */
public class GestionarComicPOJOTest {
//	
//	@Test
//	public void crearComicDTOTest() {
//		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
//		
//		//Crea una instancia de ComicDTO con el método del gestionador que recibe todos los parametros
//		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("100", "Dragon Ball Yamcha", "Planeta Cómic", TematicaEnum.AVENTURAS,
//				"Manga Shonen", 144, new BigDecimal(2100), "Dragon Garow Lee", Boolean.FALSE, LocalDate.now(), "ACTIVO",
//				20L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//
//		//Aserción para ver que la lista de comics no sea nula
//		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
//		//Aserción para ver que la lista de comics no este vacia
//		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
//		//Aserción para ver que la lista de comics tenga un elemento (el que se acaba de agregar)
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
//
//		comicDTO = new ComicDTO();
//
//		comicDTO.setId("101");
//		comicDTO.setNombre("Captain America Corps 1-5 USA");
//		comicDTO.setEditorial("Panini Comics");
//		comicDTO.setTematica(TematicaEnum.FANTASTICO);
//		comicDTO.setColeccion("BIBLIOTECA MARVEL");
//		comicDTO.setNumeroPaginas(128);
//		comicDTO.setPrice(new BigDecimal(5000));
//		comicDTO.setAutores("Phillippe Briones, Roger Stern");
//		comicDTO.setColor(Boolean.FALSE);
//		comicDTO.setFechaVenta(LocalDate.now());
//		comicDTO.setEstado("ACTIVO");
//		comicDTO.setCantidad(5L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//
//		//Aserción para probar que la lista tenga dos comics
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);
//
//		comicDTO = new ComicDTO();
//
//		comicDTO.setId("102");
//		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
//		comicDTO.setEditorial("Panini Comics");
//		comicDTO.setTematica(TematicaEnum.FANTASTICO);
//		comicDTO.setColeccion("MARVEL COMICS");
//		comicDTO.setNumeroPaginas(208);
//		comicDTO.setPrice(new BigDecimal(6225));
//		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
//		comicDTO.setColor(Boolean.TRUE);
//		comicDTO.setFechaVenta(LocalDate.now());
//		comicDTO.setEstado("INACTIVO");
//		comicDTO.setCantidad(0L);
//
//		gestionarComicPOJO.agregarComicDTOLista(comicDTO);
//		
//		//Aserción para probar que la lista tenga dos comics
//
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
//		
//		String newName = "Captain America Corps 1-5 Colombia";
//		
//		//Modificación del nombre del comic con ID 2
//		gestionarComicPOJO.modificarComicDTO("2",newName);
//		
//		ComicDTO comicModificado = gestionarComicPOJO.getListaComics().get(1);
//		Assert.assertEquals(comicModificado.getNombre(), newName);
//
//		//Elimina el ComicDTO con ID 100
//		gestionarComicPOJO.eliminarComicDTO("100");
//
//		//Aserción para saber si se ha eliminado el ComicDTO con ID 100
//		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);
//	}
//	
}
