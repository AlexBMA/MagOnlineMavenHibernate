package serviciesImpl;

import dboperations.DBOperationProductType;
import dboperations.DBOperations;
import modelMag.ProductType;

public class ProductTypeServiceImplementation {

	private static DBOperations<ProductType> dbOperations;
	
	public static DBOperations<ProductType> getInstance(){
		
		if(dbOperations == null) dbOperations = new DBOperationProductType();
		return dbOperations;
	}
	
	
}
