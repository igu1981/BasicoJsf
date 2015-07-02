package com.basico.persintence.JPA;



import javax.ejb.Stateless;
import javax.persistence.Query;

import com.basico.generic.GenericDaoJpa;
import com.basico.modelo.Mensaje;
import com.basico.persitence.LoginDao;


@Stateless
public class UsuarioDaoJpa extends GenericDaoJpa<Mensaje> implements LoginDao{

	@Override
	public int validarUser(String username, String password) 
	{
		
		String query= "Select idusuarios from usuarios where username = ?1 and password = ?2 ";
		Query q=em.createNativeQuery(query);
		q.setParameter(1, username);
		q.setParameter(2, password);
		
		try {
			return (Integer) q.getSingleResult();
			
		} catch (Exception e) {
			
			return -1;
			
		}
	}
		

	
	

}
