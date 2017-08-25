package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import constantPack.AppTables;
import modelMag.ProductType;

public class DBOperationProductType implements DBOperations<ProductType> {

	public void getA(SessionFactory theSessionFactory, String name){
		
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();
		
		String hql = "from ProductType";
		//List<ProductType> theList = theSession.createQuery(hql).getResultList();
		
		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		theSession.close();

	}
	
	@Override
	public void insert(SessionFactory theSessionFactory, ProductType ob) {

		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();

		// save the object
		theSession.saveOrUpdate(ob);

		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		theSession.close();

	}

	@Override
	public ProductType getARow(SessionFactory theSessionFactory, int id) {

		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();

		ProductType temp = theSession.get(ProductType.class, id);

		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		theSession.close();

		return temp;
	}

	@Override
	public List<ProductType> getAllRow(SessionFactory theSessionFactory) {

		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();

		String hql = "from ProductType"+AppTables.ProductTypeEntry.TABLE_NAME;

		List<ProductType> theList = theSession.createQuery(hql).getResultList();

		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		theSession.close();

		return theList;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
		// get the session
		Session theSession = theSessionFactory.getCurrentSession();

		// begin transaction
		theSession.beginTransaction();

		ProductType temp = theSession.get(ProductType.class, id);

		// delete the object
		theSession.delete(temp);

		// commit the operation
		theSession.getTransaction().commit();

		// close the session
		theSession.close();

	}

	@Override
	public List<ProductType> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
				
			return null;
	}

}
