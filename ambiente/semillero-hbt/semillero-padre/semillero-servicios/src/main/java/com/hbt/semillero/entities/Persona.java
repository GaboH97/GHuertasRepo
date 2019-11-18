/**
 * Persona.java
 */
package com.hbt.semillero.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que representa una persona
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */

@Entity
@Table(name = "TC_PERSONA")
public class Persona  implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SPID_GENERATOR")
	@Column(name = "SPID")
	private Long id;
	
	@Column(name = "SCNOMBRE")
	private String nombre;
		
	@Column(name = "SCNUMIDENTIFICACION")
	private Long numIdentificación;
	
	/**
	 * Constructor de la clase.
	 */
	public Persona() {
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
	public Long getNumIdentificación() {
		return numIdentificación;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo numIdentificación
	 * @param numIdentificación El nuevo numIdentificación a modificar.
	 */
	public void setNumIdentificación(Long numIdentificación) {
		this.numIdentificación = numIdentificación;
	}

}
