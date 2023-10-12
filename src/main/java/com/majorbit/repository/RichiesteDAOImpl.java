package com.majorbit.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.majorbit.config.HIbernateUtil;
import com.majorbit.model.Richieste_Fazi;
import com.majorbit.model.User_Trello_Fazi;

@Repository
public class RichiesteDAOImpl implements RichiesteDAO{

	@Override
	public void create(Richieste_Fazi r) {
		
		Session session=HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.save(r);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public Richieste_Fazi read(Integer id) {
		Session session= HIbernateUtil.getSession();
		
		Richieste_Fazi r= session.get(Richieste_Fazi.class, id);
		
		session.close();
		
		return r;
	}

	@Override
	public void update(Richieste_Fazi r) {
		Session session=HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.update(r);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(Richieste_Fazi r) {
		Session session=HIbernateUtil.getSession();
		Transaction transaction= session.beginTransaction();
		try {
			session.delete(r);
			transaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public List<Richieste_Fazi> readMittente(User_Trello_Fazi u) {

		Session session= HIbernateUtil.getSession();
		
		Query query= session.createQuery("from Richieste_Fazi r where r.sendingUser= :id");
		query.setParameter("id", u);
		
		List<Richieste_Fazi> list= query.getResultList();
		
		session.close();
		
		return list;
	}

	@Override
	public List<Richieste_Fazi> readRicevente(User_Trello_Fazi u) {

		Session session= HIbernateUtil.getSession();
		
		Query query= session.createQuery("from Richieste_Fazi r where r.receivingUser= :id");
		query.setParameter("id",u);
		
		List<Richieste_Fazi> list= query.getResultList();
		
		session.close();
		
		return list;
	}

}
