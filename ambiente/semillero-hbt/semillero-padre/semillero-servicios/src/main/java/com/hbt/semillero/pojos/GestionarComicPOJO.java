/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entities.EstadoEnum;
import com.hbt.semillero.entities.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */
public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	public ComicDTO crearComicDTO(Long id, String nombre, String editorial, TematicaEnum tematicaEnum,
			String coleccion, Integer numeroPaginas, BigDecimal price, String autores, Boolean color,
			LocalDate fechaVenta, EstadoEnum estado, Long cantidad) {

		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematicaEnum, coleccion, numeroPaginas, price, autores,
				color, fechaVenta, estado, cantidad);

		return comicDTO;
	}

	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(100L);
		comicDTO.setNombre("Dragon ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrice(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic de acuerdo con su Id
	 * 
	 * @author Lenovo
	 * 
	 * @param id     del comic que se desea modificar
	 * @param nombre que se desea asignar al comic
	 */
	public void modificarComicDTO(String id, String nombre) {

		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicAModificar = listaComics.get(i);
			if (comicAModificar.getId().equals(id)) {
				comicAModificar.setNombre(nombre);
				return;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de modificar el comic ubicado en la posición i de una lista
	 *
	 * @author Gabriel Huertas
	 * 
	 * @param i
	 * @param comicDTO
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic de la lista de comics de acuerdo a su
	 * Id
	 * 
	 * @author Gabriel Huertas
	 * 
	 * @param idComic
	 */
	public void eliminarComicDTO(String idComic) {
		int listaComicSize = this.listaComics.size();
		int counter = 0;
		while (counter <= listaComicSize) {
			if (this.listaComics.get(counter).getId().equals(idComic)) {
				this.listaComics.remove(counter);
				return;
			}
			counter++;
		}
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
}
