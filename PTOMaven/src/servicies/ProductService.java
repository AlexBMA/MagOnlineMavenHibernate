package servicies;

import java.util.List;


import org.hibernate.SessionFactory;

import dboperations.DB;

import dboperations.DBOperations2;
import dboperations.DBOperationsProduct;
import modelMag.Product;


public class ProductService implements GeneralServiceInterface<Product>{

	@Override
	public List<Product> getAllItems(SessionFactory sesssion) {
		// TODO Auto-generated method stub
	
		DBOperations2< Product> dbOperations = new DBOperationsProduct();
			
		
		return dbOperations.getAllRow(sesssion);
	}

	@Override
	public Product getItem(int id,SessionFactory sesssion) {
		
		DBOperations2< Product> dbOperations = new DBOperationsProduct();
		return dbOperations.getARow(sesssion, id);
	}

	
	
	@Override
	public void deleteItem(int id,SessionFactory session) {
		
		
		DBOperations2<Product> opProduct = new DBOperationsProduct();
		
	
		opProduct.deleteRow(session, id);
	}

	@Override
	public void updateItem(Product item,SessionFactory session) {
		
		DBOperations2<Product> opProduct = new DBOperationsProduct();
		
		opProduct.insert(session, item);
		
	}

	@Override
	public void insertItem(Product item, SessionFactory session) {
		
		
		DBOperations2<Product> opProduct = new DBOperationsProduct();
		
		
		opProduct.insert(session, item);
			
	}

	
	
	//public void insert
}
