package com.jrb.ClubDBJPA2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

public class MemberDaoImpl implements MemberDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public List<Member> getMembers() {
		List<Member> mems;

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select m from Member m");
		mems = query.getResultList();
		entityManager.close();
		return mems;
	}

	public void update(Member m) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();

		trans.begin();
		entityManager.merge(m);
		trans.commit();
		entityManager.close();
	}

	public void save(Member m) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction trans = entityManager.getTransaction();

		trans.begin();
		try {
			entityManager.persist(m);

		} catch (Exception e) {
			throw new DaoFailedException("Cannot insert member");
		}
		trans.commit();
		entityManager.close();
	}
}
