package com.majorbit.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.majorbit.config.HibernateUtil;
import com.majorbit.model.Richieste_Fazi;
import com.majorbit.model.User_Trello_Fazi;

@Repository
public class RichiesteDAOImpl implements RichiesteDAO{

	@Override
	public void create(Richieste_Fazi r) {
		
		Session session=HibernateUtil.getSession();
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
		Session session= HibernateUtil.getSession();
		
		Richieste_Fazi r= session.get(Richieste_Fazi.class, id);
		
		session.close();
		
		return r;
	}

	@Override
	public void update(Richieste_Fazi r) {
		Session session=HibernateUtil.getSession();
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
		Session session=HibernateUtil.getSession();
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

		Session session= HibernateUtil.getSession();
		
		Query query= session.createQuery("from Richieste_Fazi r where r.sendingUser= :id");
		query.setParameter("id", u);
		
		List<Richieste_Fazi> list= query.getResultList();
		
		session.close();
		
		return list;
	}

	@Override
	public List<Richieste_Fazi> readRicevente(User_Trello_Fazi u) {

		Session session= HibernateUtil.getSession();
		
		Query query= session.createQuery("from Richieste_Fazi r where r.receivingUser= :id");
		query.setParameter("id",u);
		
		List<Richieste_Fazi> list= query.getResultList();
		
		session.close();
		
		return list;
	}

	@Override
	public Richieste_Fazi readCombo(User_Trello_Fazi u1, User_Trello_Fazi u2) {

		Session session= HibernateUtil.getSession();
		
		Query query= session.createQuery("from Richieste_Fazi r where r.receivingUser= :id1 and r.sendingUser= :id2 or r.receivingUser= :id2 and r.sendingUser= :id1");
		query.setParameter("id1",u1);
		query.setParameter("id2", u2);
		
		Richieste_Fazi sol;
		List<Richieste_Fazi> list= query.getResultList();
		if(list.size()!=0) {
			sol= list.get(0);
		}else {
			sol=null;
		}
		
		session.close();
		
		return sol;
	}

}
