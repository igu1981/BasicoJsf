package com.basico.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private int idusuario;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
   
}
