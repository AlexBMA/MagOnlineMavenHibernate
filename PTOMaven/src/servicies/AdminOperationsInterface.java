package servicies;

import java.util.List;

import org.hibernate.SessionFactory;

import modelMag.Product;

public interface AdminOperationsInterface {

	     
	public List<Product> getAllProducts(SessionFactory theSessionFactory);
	
	public Product getProduct(SessionFactory theSessionFactory,int id);
	
	public void deleteProduct(SessionFactory theSessionFactory,int id);
	
	
	
}
