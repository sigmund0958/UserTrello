package com.majorbit.repository;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.majorbit.config.HIbernateUtil;
import com.majorbit.model.User_Trello_Fazi;

@Repository
public class UserDAOImpl implements UserDAO{

	@Override
	public void create(User_Trello_Fazi u) {
		
		Session session= HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.save(u);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public User_Trello_Fazi read(String email) {
		
		Session session= HIbernateUtil.getSession();

		User_Trello_Fazi u= session.get(User_Trello_Fazi.class, email);
		
		session.close();
		
		return u;
	}

	@Override
	public void update(User_Trello_Fazi u) {
		
		Session session=HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.update(u);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(User_Trello_Fazi u) {
		
		Session session=HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.delete(u);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

}
