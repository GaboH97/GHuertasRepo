/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

import javax.persistence.Column;

/**
 * <b>Descripción:<b> Clase que determina <b>Caso de Uso:<b>
 * 
 * @author Gabriel Huertas
 * @version
 */
public class PersonaDTO {

	private Long id;

	private String nombre;

	private Long numIdentificacion;
	
	/**
	 * Constructor de la clase.
	 */
	public PersonaDTO() {
	}
	
	

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param numIdentificación
	 */
	public PersonaDTO(Long id, String nombre, Long numIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numIdentificacion = numIdentificacion;
	}



	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo numIdentificación
	 * @return El numIdentificación asociado a la clase
	 */
	public Long getNumIdentificacion() {
		return numIdentificacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numIdentificación
	 * @param numIdentificación El nuevo numIdentificación a modificar.
	 */
	public void setNumIdentificacion(Long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	
}
