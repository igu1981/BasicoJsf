package com.basico.controller.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import com.basico.modelo.Mensaje;
import com.basico.persitence.MensajeDao;

@ManagedBean(name = "mensajeBean")
@SessionScoped
public class MensajeController implements Serializable
{
	//------------------------- Atributos -------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private int total;
	LoginConctroller lc;
	private List<Mensaje> mensajes;
	private String filtBusqueda;
	boolean estado;
	private Mensaje mensaje;
	private Long key;
	private Date date3;
	
	
	
	@EJB
	protected MensajeDao mensajeDao;
	
	

	//------------------------- Constructor -------------------------------
	
	public MensajeController() 
	{
		filtBusqueda="";
		
		
	}
	
	@PostConstruct
	public void init() {
		mensajes = listMensaje();
	}
	
	//------------------------- Getters y Setters -------------------------------

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	public String getFiltBusqueda() {
		return filtBusqueda;
	}

	public void setFiltBusqueda(String filtBusqueda) {
		this.filtBusqueda = filtBusqueda;
	}
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}


	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}
	
	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	
	//------------------------- Metodos -------------------------------
	
	public String addMensaje() {
		Mensaje mensaje = new Mensaje();
		mensaje.setDescripcion(descripcion);
		
		mensajeDao.create(mensaje);
		descripcion="";
		
		mensajes=listMensaje();
		return "/publico/template/tenplate.xhtml?faces-redirect=true";
	}
	public List<Mensaje> listMensaje()
	{
		return mensajeDao.findAll();
	}
	public String listaMensaje()
	{
		mensajes=listMensaje();
		
		return "/publico/lista-mensaje.xhtml?faces-redirect=true";
	}
	 public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido",lc.getUsername() ));
	    }
	 public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Mensaje Edited: " + ((Mensaje) event.getObject()).getDescripcion());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        mensajeDao.update((Mensaje) event.getObject());
	      
	        
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Mensaje Cancelled");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            
	        }
	    }
	  
	    public void onRowSelect(SelectEvent event) {
	    	mensaje = (Mensaje) event.getObject();
	    }
	    
	    public List<Mensaje> search() 
	    {
	    	List<Mensaje> temp=mensajeDao.searchDao(filtBusqueda,estado); 
	        estado=true;
	        return temp;
	       
	    }
	    
	    public String busqueda()
	    {
	    	estado=false;
	    	filtBusqueda="";
	    	return "/publico/filtro-mensaje.xhtml?faces-redirect=true";
	    
			
	    }
	    
	    public String modificar()
	    {
	    	return "/publico/modifcar-mensaje.xhtml?faces-redirect=true";
	    }
	    
	    public String volver()
	    {
	    	return "/publico/template/template.xhtml?faces-redirect=true";
	    }
	    
	    public String borrar()
	    {
	    	mensajeDao.delete(mensaje.getMensajeId());
	    	FacesMessage msg = new FacesMessage("Mensaje Borrado: " + mensaje.getMensajeId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        mensajes=listMensaje();
	        
	    	return "/publico/mensaje-mios.xhtml?faces-redirect=true";
	    }
		
	    public String guardar()
	    {
	    	
			mensaje=mensajeDao.update(mensaje);
			FacesMessage msg = new FacesMessage("Mensaje Edited: " + mensaje.getMensajeId());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			
			
			return "/publico/template/modificar-mensaje.xhtml?faces-redirect=true";
	    }
	    public String mios()
	    {
	    
			
			return "/publico/mensaje-mios.xhtml?faces-redirect=true";
	    }
	    public String nuevo()
	    {
	    
			return "/publico/views/mensaje-nuevo.xhtml?faces-redirect=true";
	    }
	    
	   
		
	    public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }
	     
	    public void click() {
	        RequestContext requestContext = RequestContext.getCurrentInstance();
	         
	        requestContext.update("form:display");
	        requestContext.execute("PF('dlg').show()");
	    }
	 
}
