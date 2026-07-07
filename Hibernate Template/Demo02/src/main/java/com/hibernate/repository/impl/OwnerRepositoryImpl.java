package com.hibernate.repository.impl;


import com.hibernate.entity.PrimaryKey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.config.DatabaseConfig;
import com.hibernate.entity.Owner;
import com.hibernate.repository.OwnerRepository;

import java.util.UUID;


public class OwnerRepositoryImpl implements OwnerRepository {
	private static final SessionFactory sessionFactory= DatabaseConfig.getSessionFactory();


	@Override
	public void saveOwner(Owner owner) {
		try(Session session=sessionFactory.openSession()){
			session.beginTransaction();
			session.persist(owner);
			session.getTransaction().commit();
		}
	}

	@Override
	public Owner findOwner(PrimaryKey primaryKey) {
		try(Session session=sessionFactory.openSession()) {
			return session.find(Owner.class,primaryKey);
		}
	}

	@Override
	public void updatePetDetails(PrimaryKey primaryKey, String petName) {
		try(Session session=sessionFactory.openSession()){
			session.beginTransaction();
			Owner owner=session.find(Owner.class,primaryKey);
			owner.setPetName(petName);
			session.merge(owner);
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteOwner(PrimaryKey primaryKey) {
		try(Session session=sessionFactory.openSession()) {
			session.beginTransaction();
			Owner owner=session.find(Owner.class,primaryKey);
			session.remove(owner);
			session.getTransaction().commit();
		}
	}
}