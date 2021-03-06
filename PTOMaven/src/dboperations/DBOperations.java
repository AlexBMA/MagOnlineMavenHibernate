package dboperations;

import java.util.List;

import org.hibernate.SessionFactory;

public interface DBOperations<T> {

	public void insertOrUpdate(SessionFactory theSessionFactory,T ob);
	public T getARow(SessionFactory theSessionFactory,int id);
	public List<T> getAllRow(SessionFactory theSessionFactory);
	public void deleteRow(SessionFactory theSessionFactory,int id);
	public List<T> getAllSimilarRows(SessionFactory theSessionFactory,int idType );
	
	
}
