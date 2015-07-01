package com.basico.persitence;

import java.util.List;

import com.basico.generic.GenericDao;
import com.basico.modelo.Mensaje;



public interface MensajeDao extends GenericDao<Mensaje>
{

	public List<Mensaje> listarmensaje();
	
	public List<Mensaje> searchDao(String filtBusqueda,boolean estado);
}
