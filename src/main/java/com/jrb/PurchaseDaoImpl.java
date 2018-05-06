package com.jrb;

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

		try {
			trans.begin();
			entityManager.persist(p);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		entityManager.close();
	}
}
