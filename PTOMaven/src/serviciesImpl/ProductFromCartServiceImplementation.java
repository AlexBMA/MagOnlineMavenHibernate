package serviciesImpl;

import dboperations.DBOperations;
import dboperations.DBOperationsProductFromCart;
import modelMag.ProductFromCart;

public class ProductFromCartServiceImplementation  {

	private static DBOperations<ProductFromCart> productFromOperations;
	
	public static DBOperations<ProductFromCart> getInstance(){	
		if(productFromOperations== null) productFromOperations = new DBOperationsProductFromCart();
		return productFromOperations;
	}
	
}
