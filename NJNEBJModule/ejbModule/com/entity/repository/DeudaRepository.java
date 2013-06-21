package com.entity.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.application.repository.Repository;
import com.entity.entidades.Deuda;

@Stateless
@LocalBean
public class DeudaRepository implements Repository<Integer, Deuda> {

	@PersistenceContext(name = "NJNEBJModule")
	private EntityManager entityManager;

	@Override
	public Deuda get(Integer id) {
		return entityManager.find(Deuda.class, id);
	}

	@Override
	public List<Deuda> getAll() {
		String q = "SELECT p from " + Deuda.class.getName() + " p ";
		TypedQuery<Deuda> query = entityManager.createQuery(q, Deuda.class);

		List<Deuda> result = query.getResultList();
		if (result == null) {
			result = new ArrayList<Deuda>();
		}
		return result;
	}

	@Override
	public void add(Deuda newOne) {
		entityManager.persist(newOne);
	}

	@Override
	public void remove(Deuda toRemove) {
		entityManager.remove(toRemove);
	}

	@Override
	public long size() {
		String q = "SELECT count(p) from " + Deuda.class.getName() + " p";
		return (Long) entityManager.createQuery(q).getSingleResult();
	}
}