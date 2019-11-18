/**
 * UsuarioDTO.java
 */
package com.hbt.semillero.dto;

import java.time.LocalDate;


import com.hbt.semillero.entities.EstadoUsuarioEnum;

/**
 * <b>Descripción:<b> Clase que representa un DTO asociado a una entidad Usuario
 * <b>Caso de Uso:<b> 
 * @author Lenovo
 * @version 
 */
public class UsuarioDTO {

	private Long id;
	
	private String nombre;
	
	
	private LocalDate fechaCreacion;
	
	private EstadoUsuarioEnum estadoEnum;
	
	private PersonaDTO persona;
	
	/**
	 * Constructor de la clase.
	 */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param persona
	 */
	public UsuarioDTO(Long id, String nombre, LocalDate fechaCreacion, EstadoUsuarioEnum estadoEnum,
			PersonaDTO persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.persona = persona;
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
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoUsuarioEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoUsuarioEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo persona
	 * @return El persona asociado a la clase
	 */
	public PersonaDTO getPersona() {
		return persona;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	
	
}
