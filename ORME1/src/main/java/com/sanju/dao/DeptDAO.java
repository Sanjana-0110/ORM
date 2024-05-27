package com.sanju.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sanju.model.sanjanadept187;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service

public class DeptDAO {

	@PersistenceContext

	private EntityManager em;

	public void persist(sanjanadept187 dpt) {

		em.persist(dpt);

	}

	public List<sanjanadept187> findAll() {

		return em.createQuery("SELECT d FROM sanjanadept187 d").getResultList();

	}

}
