/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entities;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Lenovo
 * @version 
 */
public enum EstadoEnum {

	
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	
	private String codigoEstado;
	
	/**
	 * Constructor de la clase.
	 * @param codigoEstado
	 */
	private EstadoEnum(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoEstado
	 * @return El codigoEstado asociado a la clase
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	
	/**
	 * Metodo encargado de modificar el valor del atributo codigoEstado
	 * @param codigoEstado El nuevo codigoEstado a modificar.
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	
}
