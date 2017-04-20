package services;

import java.util.List;


import org.hibernate.SessionFactory;

public interface GeneralServiceInterface <E> {

	public List<E> getAllItems(SessionFactory session);
	
	public List<E> getRecommendedItems(SessionFactory session,int idType);
	
	public E getItem(int id,SessionFactory session);

	public void deleteItem(int id,SessionFactory session);
	
	public void updateItem(E item,SessionFactory session);

	public void insertItem(E item,SessionFactory session);
	
		
}
