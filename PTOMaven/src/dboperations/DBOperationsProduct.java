package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import constantPack.AppTables;
import modelMag.Product;

public class DBOperationsProduct implements DBOperations<Product> {


	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		
				//get the session
				Session theSession = theSessionFactory.getCurrentSession();
				
				//begin transaction
				theSession.beginTransaction();
				
				Product temp = theSession.get(Product.class, id);
				
				
				//delete the product
				theSession.delete(temp);
				
				//commit the operation
				theSession.getTransaction().commit();
				
				//close the session
				//theSession.close();
				
		
	}

	@Override
	public void insertOrUpdate(SessionFactory theSessionFactory, Product ob) {
		
		//get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begin transaction
		theSession.beginTransaction();
		
		//save or update the session
		theSession.saveOrUpdate(ob);
		
		//commit the operation
		theSession.getTransaction().commit();
		
		//close the session
		//theSession.close();
		
		
	}

	@Override
	public Product getARow(SessionFactory theSessionFactory, int id) {
		
		 //get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begin transaction
		theSession.beginTransaction();
		
		Product temp = theSession.get(Product.class, id);
		
		
		
		//commit the operation
		theSession.getTransaction().commit();
		
		//close the session
		//heSession.close();
		
		
		
		return temp;
	}

	@Override
	public List<Product> getAllRow(SessionFactory theSessionFactory) {

		//get the session
		Session theSession = theSessionFactory.getCurrentSession();
		
		//begin transaction
		theSession.beginTransaction();
		
		String hql="from "+AppTables.ProductEntry.TABLE_NAME;
		
		List<Product> theList = theSession.createQuery(hql).getResultList();
		
		//commit the operation
		theSession.getTransaction().commit();
		
		//close the session
		//theSession.close();
		
		
		return	theList;
	}

	@Override
	public List<Product> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();

		String hql = "from "+AppTables.ProductEntry.TABLE_NAME+" where productTypeId = ? ";

		List<Product> theList = theSession.createQuery(hql).setParameter(0, idType).getResultList();

		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		//theSession.close();

		return theList;
	}

}
