package com.sanju.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanju.model.Dept;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service

public class DeptDAO {

	@PersistenceContext

	private EntityManager em;

	public void persist(Dept dpt) {

		em.persist(dpt);

	}

	public List<Dept> findAll() {

		return em.createQuery("SELECT d FROM jayanth_i193_dept d").getResultList();

	}

}
