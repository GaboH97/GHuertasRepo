/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entities.Comic;

/**
 * <b>Descripción:<b> Clase que determina la gestión de comics <b>Caso de
 * Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {

	@PersistenceContext
	private EntityManager em;

	// TODO
	/*
	 * Agregar interfaz
	 */

	/**
	 * 
	 * Metodo encargado de crear un comic 
	 * <b>Caso de Uso</b>
	 * @author Gabriel Huertas
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)//Crea una transaccion nueva
	public void crearComic(ComicDTO comicDTO) {
		Comic comic = comicDTOToComic(comicDTO);
		em.persist(comic);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		// comic.setId(comicModificar.getId());
		em.merge(comic);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, Long.parseLong(id));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long,
	 *      java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	// @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) {
			comicModificar = em.find(Comic.class, id);
		} else {
			comicModificar = comicDTOToComic(comicNuevo);
		}
		// TODO Hacer validación para ver si llegó con datos
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
	}

	/**
	 * Metodo que elimina el comic de la base de datos
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@Override
	public void eliminarComic(Long id) {
		Comic comic = em.find(Comic.class, id);
		if (comic != null) {
			em.remove(comic);
		}
	}

	/**
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}

	private Comic comicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setAutores(comicDTO.getAutores());
		comic.setCantidad(comicDTO.getCantidad());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setColor(comicDTO.getColor());
		comic.setEditorial(comicDTO.getEditorial());
		 comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setNombre(comicDTO.getNombre());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrice());
		 comic.setTematicaEnum(comicDTO.getTematicaEnum());

		return comic;
	}

	private ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		if (comic.getId() != null) {
			comicDTO.setId(comic.getId());
		}
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrice(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}

}
