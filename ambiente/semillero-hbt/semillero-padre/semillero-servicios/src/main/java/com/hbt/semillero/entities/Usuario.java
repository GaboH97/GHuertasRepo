/**
 * Usuario.java
 */
package com.hbt.semillero.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Descripción:<b> Clase que representa un usuario
 * <b>Caso de Uso:<b> 
 * @author Gabriel Huertas
 * @version 
 */

@Entity
@Table(name = "TC_USUARIO")
public class Usuario implements Serializable {

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SUID_GENERATOR")
	@Column(name = "SUID")
	private Long id;
	
	@Column(name = "SUNOMBRE")
	private String nombre;
	
	@Column(name = "SUFECHA_CREACION")
	private LocalDate fechaCreacion;
	
	@Column(name = "SUESTADO")
	@Enumerated(value = EnumType.STRING)
	private EstadoUsuarioEnum estadoEnum;
	
	@OneToOne
	@JoinColumn(name="SUIDPERSONA")
	private Persona persona;
	
	/**
	 * Constructor de la clase.
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	@PrePersist
	public void prePersist() {
		this.estadoEnum = EstadoUsuarioEnum.ACTIVO;
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
	 * @return El fechaVenta asociado a la clase
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
	public Persona getPersona() {
		return persona;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo persona
	 * @param persona El nuevo persona a modificar.
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
