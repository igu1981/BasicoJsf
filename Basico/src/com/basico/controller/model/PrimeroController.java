package com.basico.controller.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * 
 * @author igomez
 *
 */

@ManagedBean(name = "Primero")
@SessionScoped
public class PrimeroController implements Serializable
{
	
	
	//------------------------- Atributos  -------------------------------
	
	private String texto;
	private static final long serialVersionUID = 1L;
	
	
	//------------------------- Constructor -------------------------------
	
	public PrimeroController()
	{
		
	}
		

	//------------------------- Getters y Setters -------------------------------
	
	

	public String getTexto() {
		return texto;
	}
 
	public void setTexto(String texto) {
		this.texto = texto;
	}	
	
	
}
