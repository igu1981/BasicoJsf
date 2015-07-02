package com.basico.controller.model;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * 
 * @author igomez
 *
 */
@ManagedBean(name = "Login")
@SessionScoped
public class LoginConctroller implements Serializable
{
	//------------------------- Atributos -------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String accesoUsuario;
	private String apellidos;
	private String email;

	//------------------------- Metodos  -------------------------------

	
	
	
	public void logearse(ActionEvent actionEvent) 
	{  
		FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = null;   
          
        if(username != null  && username.equals("ivan") && password != null  && password.equals("admin")) 
        {  
        	try {
				ctx.getExternalContext().redirect("/Basico/faces/publico/menu-principal.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            username = "";
            password = "";
        }
    }  
	
	public String acceso() 
	{  
		
		return "/publico/acceso.xhtml?faces-redirect=true";
	
	
	}
	
	public String registro() 
	{  
		
		
		return "/publico/registro.xhtml?faces-redirect=true";
	}
	
	

	
	public String solicitar() 
	{  
		
		
		return "/publico/index.xhtml?faces-redirect=true";
	}
	
	public String altanueva() 
	{  
		
		
		return "/publico/index.xhtml?faces-redirect=true";
	}
	
	//------------------------- Getters y Setters -------------------------------
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getAccesoUsuario() {
		return accesoUsuario;
	}

	public void setAccesoUsuario(String accesoUsuario) {
		this.accesoUsuario = accesoUsuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
