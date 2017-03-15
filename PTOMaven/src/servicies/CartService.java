package servicies;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperations;
import dboperations.DBOperationsCart;
import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;

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
		
		DBOperations<Cart> cartOperations = new DBOperationsCart();
		cartOperations.insert(session, item);
		
		GeneralServiceInterface<Product> productServices = new ProductService();
		
		List<ProductFromCart> list = item.getProductsFromCart();
		updateStoks(session, productServices, list);
		
	}

	public void updateStoks(SessionFactory session, GeneralServiceInterface<Product> productServices,
		
		List<ProductFromCart> list) {
		int size = list.size();
		ProductFromCart temp;
		Product tempProduct;
		int tempCantitateComadata;
		
		for( int  i=0;i<size;i++)
		{ 	
			temp = list.get(i);
			tempCantitateComadata = temp.getCantitateComandata();
			tempProduct = temp.getProdus();
			tempProduct.setNumberOfItmes((tempProduct.getNumberOfItems()-tempCantitateComadata));
			
			productServices.updateItem(tempProduct, session);
		}
	}
	
	

}
