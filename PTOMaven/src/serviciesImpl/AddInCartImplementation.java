package serviciesImpl;

import java.util.List;

import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;
import services.AddInCartInterface;

public class AddInCartImplementation implements AddInCartInterface<Product, Cart> {

	@Override
	public void addInCartOneItemMultipleTimes(Product item, int numberOfItems, Cart theCart) {

		System.out.println("HERE IN ADD IN CART");
		//System.out.println(item.getName());
		//System.out.println(numberOfItems);
		
		int rez = checkIfItemAlreadyInCart(item, numberOfItems, theCart);

		if (rez == -1) {
			ProductFromCart temp = new ProductFromCart(item, numberOfItems);
			theCart.getProductsFromCart().add(temp);
		} else {

			int oldNumber = theCart.getProductsFromCart().get(rez).getCantitateComandata();
			int newNumber = oldNumber + numberOfItems;
			System.out.println("OLD NUMBER: "+oldNumber);
			System.out.println("NEW NUMBER: "+newNumber);
			System.out.println();
			
		
			theCart.getProductsFromCart().get(rez).setCantitateComandata(newNumber);

		}

	}

	@Override
	public int checkIfItemAlreadyInCart(Product item, int numberOfItems, Cart cart) {

		List<ProductFromCart> list = cart.getProductsFromCart();

		
		int size = list.size();
		ProductFromCart temp;
		for(int i=0;i<size;i++)
		{
			temp = list.get(i);
			
				if (temp.getProdus().getId() == item.getId()) {
			
				System.out.println(item.getId());
				System.out.println(temp.getProdus().getId());
				
				return i;
			}
		}
		

		return -1;
	}

	@Override
	public double calculateTotalPriceForCart(Cart cart) {

		double total = 0;
		List<ProductFromCart> list = cart.getProductsFromCart();

		for (ProductFromCart temp : list) {

			total = total + (temp.getProdus().getPrice() * temp.getCantitateComandata());

		}

		cart.setTotalPriceForProductFromCart(total);

		return total;
	}

}
