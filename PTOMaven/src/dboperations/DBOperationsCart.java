package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelMag.Cart;

public class DBOperationsCart implements DBOperations<Cart> {

	@Override
	public void insert(SessionFactory theSessionFactory, Cart ob) {
		
		 //get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begin transaction
		theSession.beginTransaction();
		
		//save the object
		theSession.saveOrUpdate(ob);
		
			
		//commit the operation
		theSession.getTransaction().commit();
		
		//close the session
		theSession.close();
		
		
	}

	@Override
	public Cart getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getAllRow(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

}
