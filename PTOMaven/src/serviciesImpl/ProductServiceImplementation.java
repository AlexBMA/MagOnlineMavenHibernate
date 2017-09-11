package serviciesImpl;

import dboperations.DBOperations;
import dboperations.DBOperationsProduct;
import modelMag.Product;


public class ProductServiceImplementation {

	private static DBOperations<Product> dbOperations;
	
	public static DBOperations<Product> getInstance(){
		if(dbOperations == null) dbOperations = new DBOperationsProduct();
		return dbOperations;
	}
	
	
	
	
	//public void insert
}
