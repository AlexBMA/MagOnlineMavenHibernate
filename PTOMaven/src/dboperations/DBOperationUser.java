package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelMag.User;

public class DBOperationUser implements DBOperations2<User> {

	@Override
	public void insert(SessionFactory theSessionFactory, User ob) {
		
		
	}

	@Override
	public User getARow(SessionFactory theSessionFactory, int id) {
	
		
		return null;
	}

	@Override
	public List<User> getAllRow(SessionFactory theSessionFactory) {
	
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
				
		
	}
	
	public User checkUserAndPass(SessionFactory theSessionFactory,String userName,String userPass)
	{
		Session theSession = theSessionFactory.getCurrentSession();
		
		String hql="from User where username= ? and   pass= ? ";
		
		theSession.beginTransaction();
		
		List<User> listUser =  theSession.createQuery(hql).
												setParameter(0, userName).
												setParameter(1, userPass).
												getResultList();
		
		System.out.println();
		
		
		theSession.getTransaction().commit();
		
		theSession.close();
		
		if(listUser.size()==1)
		{
			
			User user = listUser.get(0);
			return user;
			
		}
		
		else 	return null;
	}

}
