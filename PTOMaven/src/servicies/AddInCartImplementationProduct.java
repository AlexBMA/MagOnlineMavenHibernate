package servicies;

import java.util.List;

import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;

public class AddInCartImplementationProduct implements AddInCart<Product,Cart> {
	


	@Override
	public void addInCartOneItemMultipleTimes(Product item, int numberOfItems, Cart theCart) {
		
		int rez = checkIfItemAlreadyInCart(item,numberOfItems,theCart);
		
		if( rez== -1)
		{
			ProductFromCart temp = new ProductFromCart(item, numberOfItems);
			theCart.getProductsFromCart().add(temp);
		}
		else{
			
		 int oldNumber =   theCart.getProductsFromCart().get(rez).getCantitateComandata();
		 int newNumber = oldNumber + numberOfItems;
		 
		 theCart.getProductsFromCart().get(rez).setCantitateComandata(newNumber);
		
		}
		
		
		
	}

	@Override
	public int checkIfItemAlreadyInCart(Product item, int numberOfItems, Cart cart) {
		
		
		List<ProductFromCart> list = cart.getProductsFromCart();
		
		for(ProductFromCart temp :list)
		{
			if(temp.getId() == item.getId())  return temp.getId();
		}
		
		return -1;
	}

}
