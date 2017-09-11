package serviciesImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperations;
import dboperations.DBOperationsCart;
import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;
import services.GeneralServiceInterface;

public class CartServiceImplementation implements GeneralServiceInterface<Cart> {

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
		
		
		if(item.getTotalPriceForProductFormCart()>0)
		{
			
			DBOperations<Cart> cartOperations = new DBOperationsCart();
			cartOperations.insertOrUpdate(session, item);
		
			
			List<ProductFromCart> list = item.getProductsFromCart();
			updateStoks(session,  list);
		}
		
	}

	public void updateStoks(SessionFactory session, List<ProductFromCart> list) {
		
		int size = list.size();
		ProductFromCart temp;
		int tempCantitateComadata;
		
		for( int  i=0;i<size;i++){ 	
			temp = list.get(i);
			tempCantitateComadata = temp.getCantitateComandata();
			int idProduct = temp.getIdProdus();
			
			Product tempProduct = ProductServiceImplementation.getInstance().getARow(session, idProduct);
			tempProduct.setNumberOfItmes((tempProduct.getNumberOfItems()-tempCantitateComadata));

			 ProductServiceImplementation.getInstance().insertOrUpdate(session, tempProduct);
		}
	}
	
	

}
