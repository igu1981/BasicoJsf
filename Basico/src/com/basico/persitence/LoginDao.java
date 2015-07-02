package com.basico.persitence;

import com.basico.generic.GenericDao;
import com.basico.modelo.Mensaje;

public interface LoginDao extends GenericDao<Mensaje> 
{
	public int validarUser(String username, String password);
}
