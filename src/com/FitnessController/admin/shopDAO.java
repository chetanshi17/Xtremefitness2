package com.FitnessController.admin;


import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class shopDAO {

	@Autowired
	private SessionFactory sesionFactory;
	
	@Transactional
	public void save(shopdbadmin shop) {
		Session session=sesionFactory.getCurrentSession();
		 session.save(shop);
	}
	@Transactional
	public List<shopdbadmin> list(){
		Session session=sesionFactory.getCurrentSession();
		List<shopdbadmin> shop=null;
		try{
			shop=(List<shopdbadmin>)session.createQuery("from adminshop").list();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return shop;
		
	}
	@Transactional
	public shopdbadmin get(Integer id) {
		Session session=sesionFactory.getCurrentSession();
		return(shopdbadmin)session.get(shopdbadmin.class, id);
	
	}
	@Transactional
	public void remove(Integer id) {
		Session session=sesionFactory.getCurrentSession();
		shopdbadmin shop=(shopdbadmin)session.get(shopdbadmin.class, id);
		session.delete(shop);
}
}
