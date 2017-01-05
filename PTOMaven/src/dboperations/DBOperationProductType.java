package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelMag.Product;
import modelMag.ProductType;

public class DBOperationProductType  implements DBOperations2<ProductType>{

	@Override
	public void insert(SessionFactory theSessionFactory, ProductType ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductType getARow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductType> getAllRow(SessionFactory theSessionFactory) {
		
				//get the session
				Session theSession = theSessionFactory.getCurrentSession();
				
				//begin transaction
				theSession.beginTransaction();
				
				String hql="from ProductType";
				
				List<ProductType> theList = theSession.createQuery(hql).getResultList();
				
				//commit the operation
				theSession.getTransaction().commit();
				
				//close the session
				theSession.close();
				
				
				return	theList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// TODO Auto-generated method stub
		
	}

}
