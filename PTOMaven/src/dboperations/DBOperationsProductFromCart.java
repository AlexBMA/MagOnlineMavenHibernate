package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelMag.Product;
import modelMag.ProductFromCart;

public class DBOperationsProductFromCart implements DBOperations<ProductFromCart> {

	
	@Override
	public void insertOrUpdate(SessionFactory theSessionFactory, ProductFromCart ob) {
		
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
	public ProductFromCart getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductFromCart> getAllRow(SessionFactory theSessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductFromCart> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

}
