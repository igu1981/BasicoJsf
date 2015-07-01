package com.basico.persintence.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.basico.generic.GenericDaoJpa;
import com.basico.modelo.Mensaje;
import com.basico.persitence.MensajeDao;

@Stateless
public class MensajeDaoJpa extends GenericDaoJpa<Mensaje> implements MensajeDao{

	@Override
	public List<Mensaje> listarmensaje() 
	{
		
		return findAll();
	}

	@Override
	public List<Mensaje> searchDao(String filtBusqueda,boolean estado) 
	{
		if(!estado)
		{
			return new ArrayList<Mensaje>();
		}
		String query= "SELECT m FROM Mensaje m where m.descripcion like '%" + filtBusqueda + "%' ";
		Query q=em.createQuery(query,Mensaje.class);
		
		return q.getResultList();
	}
	
	
	

}
