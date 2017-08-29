package serviciesImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperations;
import dboperations.DBOperationsProductFromCart;
import modelMag.ProductFromCart;
import services.GeneralServiceInterface;

public class ProductFromCartServiceImplementation implements GeneralServiceInterface<ProductFromCart> {

	@Override
	public List<ProductFromCart> getAllItems(SessionFactory session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductFromCart> getRecommendedItems(SessionFactory session, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductFromCart getItem(int id, SessionFactory session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(int id, SessionFactory session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(ProductFromCart item, SessionFactory session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertItem(ProductFromCart item, SessionFactory session) {
	
		DBOperations<ProductFromCart> productFromOperations = new DBOperationsProductFromCart();
		productFromOperations.insert(session, item);
		
	}

}
