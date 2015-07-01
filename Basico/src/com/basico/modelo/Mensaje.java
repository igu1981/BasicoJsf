package com.basico.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Mensaje
 *
 */
@Entity
@Table(name="mensajes")
public class Mensaje implements Serializable {

	   
	@Id
	private Long mensajeId;
	private String descripcion;
	
	private static final long serialVersionUID = 1L;

	public Mensaje() {
		super();
	}   
	public Long getMensajeId() {
		return this.mensajeId;
	}

	public void setMensajeId(Long mensajeId) {
		this.mensajeId = mensajeId;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
   
}
