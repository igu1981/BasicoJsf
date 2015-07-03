package com.basico.controller.model;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.basico.persitence.LoginDao;



@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioController implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------- Atributos -------------------------------
	private int idusuarios;
	private String username;
	private String password;
	
	@EJB
	protected LoginDao loginDao;
	
	public UsuarioController() {
		
		
	}
	//------------------------- Getters y Setters -------------------------
	public int getIdusuarios() {
		return idusuarios;
	}
	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//------------------------- Metodos -------------------------------
	
	
	public String login()
	{
		int valid = loginDao.validarUser(username, password);
        if (valid!=-1) {
           
            return "/publico/views/menu-principal.xhtml?faces-redirect=true";
            
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrecto Usuario y Passowrd",
                            "Por favor introduce de nuevo Usuario y Password"));
            return "/publico/views/index.xhtml?faces-redirect=true";
        }
		
		
		
	}
	
    public String logout()
    {    
    	
        username="";
        password="";
        
    	 return "/publico/views/index.xhtml?faces-redirect=true"; 
      }  
	

}
