package dboperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelMag.User;

public class DBOperationUser implements DBOperations<User> {

	@Override
	public void insertOrUpdate(SessionFactory theSessionFactory, User ob) {
		
		Session theSession = theSessionFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		theSession.saveOrUpdate(ob);
		
		theSession.getTransaction().commit();
		
		theSession.close();
	}

	@Override
	public User getARow(SessionFactory theSessionFactory, int id) {
	
		Session theSession = theSessionFactory.getCurrentSession();
		
		theSession.beginTransaction();
		
		User u = theSession.get(User.class, id);
		
		theSession.getTransaction().commit();
		
		theSession.close();
		
		return u;
	}

	@Override
	public List<User> getAllRow(SessionFactory theSessionFactory) {
	
		
		return null;
	}

	@Override
	public void deleteRow(SessionFactory theSessionFactory, int id) {
				
		
	}
	
	public void updateUserPass(SessionFactory theSessionFactory,String newPass,String userName,String oldPass)
	{
		
		
		
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
			System.out.println("User info:");
			System.out.println(user.getId());
			System.out.println(user.getUsername());
			System.out.println(user.getPass());
			return user;
			
		}
		
		else 	return null;
	}

	@Override
	public List<User> getAllSimilarRows(SessionFactory theSessionFactory, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

}
