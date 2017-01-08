package servicies;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperations2;
import dboperations.DBOperationsCart;
import modelMag.Cart;

public class CartService implements GeneralServiceInterface<Cart> {

	@Override
	public List<Cart> getAllItems(SessionFactory session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> getRecommendedItems(SessionFactory session, int idType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getItem(int id, SessionFactory session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteItem(int id, SessionFactory session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Cart item, SessionFactory session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertItem(Cart item, SessionFactory session) {
		
		DBOperations2<Cart> cartOperations = new DBOperationsCart();
		cartOperations.insert(session, item);
		
	}

}
