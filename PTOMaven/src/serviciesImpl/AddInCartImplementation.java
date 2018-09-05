package serviciesImpl;

import java.util.List;

import org.hibernate.SessionFactory;

import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;
import services.AddInCartInterface;

public class AddInCartImplementation implements AddInCartInterface<Integer, Cart> {

	@Override
	public void addInCartItem(Integer idProduct, int numberOfItems, Cart theCart) {

		/*System.out.println("HERE IN ADD IN CART");
		System.out.println(idProduct);
		System.out.println(numberOfItems);
		*/
		int rez = checkIfItemAlreadyInCart(idProduct, numberOfItems, theCart);
		System.out.println(rez);
		if (rez == -1) {
			
			ProductFromCart temp = new ProductFromCart(idProduct, numberOfItems);
			theCart.getProductsFromCart().add(temp);
		} else {

			int oldNumber = theCart.getProductsFromCart().get(rez).getCantitateComandata();
			int newNumber = oldNumber + numberOfItems;
			//System.out.println("OLD NUMBER: "+oldNumber);
			//System.out.println("NEW NUMBER: "+newNumber);
			//System.out.println();
		
			theCart.getProductsFromCart().get(rez).setCantitateComandata(newNumber);

		}

	}

	@Override
	public int checkIfItemAlreadyInCart(Integer idProduct, int numberOfItems, Cart cart) {

		List<ProductFromCart> list = cart.getProductsFromCart();

		int size = list.size();
		ProductFromCart temp;
		for(int i=0;i<size;i++){
			temp = list.get(i);
	
				if (temp.getIdProdus()== idProduct) {
				//System.out.println(idProduct);
				//System.out.println(temp.getIdProdus());
				return i;
			}
		}

		return -1;
	}

	@Override
	public double calculateTotalPriceForCart(Cart cart,SessionFactory sessionFactory) {

		double total = 0;
		List<ProductFromCart> list = cart.getProductsFromCart();

		for (ProductFromCart temp : list) {

		Product tempProduct = ProductServiceImplementation.getInstance().getARow(sessionFactory, temp.getIdProdus());
			total = total + (tempProduct.getPrice() * temp.getCantitateComandata());
		}

		cart.setTotalPriceForProductFromCart(total);
		return total;
	}

}
