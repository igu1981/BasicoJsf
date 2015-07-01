package com.basico.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;



public abstract class GenericDaoJpa<T>  implements GenericDao<T>{
	

	    @PersistenceContext(unitName = "mensajesPS")
	    protected EntityManager em;

	    private Class<T> type;

	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public GenericDaoJpa() {
	        Type t = getClass().getGenericSuperclass();
	        ParameterizedType pt = (ParameterizedType) t;
	        type = (Class) pt.getActualTypeArguments()[0];
	    }

	    @Override
	    public T create(final T t) {
	        this.em.persist(t);
	        return t;
	    }

	    @Override
	    public void delete(final Object id) {
	        this.em.remove(this.em.getReference(type, id));
	    }

	    @Override
	    public T find(final Object id) {
	        return (T) this.em.find(type, id);
	    }
	    
	    @Override
	    public List<T> findAll() {
	    	@SuppressWarnings("unchecked")
			CriteriaQuery<T> cq = (CriteriaQuery<T>) em.getCriteriaBuilder().createQuery();
	        cq.select(cq.from(type));
	        return em.createQuery(cq).getResultList();
	    }

	    @Override
	    public T update(final T t) {
	        return this.em.merge(t);    
	    }
	}


