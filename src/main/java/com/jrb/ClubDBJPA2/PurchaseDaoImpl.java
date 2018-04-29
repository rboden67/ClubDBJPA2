package com.jrb.ClubDBJPA2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

public class PurchaseDaoImpl implements PurchaseDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public void save(Purchase p) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();

		trans.begin();
		entityManager.persist(p);
		trans.commit();
		entityManager.close();
	}
}
