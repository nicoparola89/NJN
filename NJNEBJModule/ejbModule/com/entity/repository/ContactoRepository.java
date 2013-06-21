package com.entity.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.application.repository.Repository;
import com.entity.entidades.Contacto;

/**
 * Repositorio de Almacenamiento de Contactos del Sistema.
 * 
 */

@Stateless
@LocalBean
public class ContactoRepository implements Repository<Integer, Contacto>{

	@PersistenceContext(unitName = "NJNEBJModule")
	private EntityManager entityManager;
	
	@Override
	public Contacto get(Integer id) {
		return entityManager.find(Contacto.class, id);
	}

	@Override
	public List<Contacto> getAll() {
		String q = "SELECT p from " + Contacto.class.getName() + " p ";
		TypedQuery<Contacto> query = entityManager.createQuery(q, Contacto.class);

		List<Contacto> result = query.getResultList();
		if (result == null) {
			result = new ArrayList<Contacto>();
		}
		return result;
	}

	@Override
	public void add(Contacto newOne) {
		entityManager.persist(newOne);
		
	}

	@Override
	public void remove(Contacto toRemove) {
		entityManager.remove(toRemove);
		
	}

	@Override
	public long size() {
		String q = "SELECT count(p) from " + Contacto.class.getName() + " p";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}	

}
