package serviciesImpl;

import java.util.List;


import org.hibernate.SessionFactory;


import dboperations.DBOperations;
import dboperations.DBOperationsProduct;
import modelMag.Product;
import services.GeneralServiceInterface;


public class ProductServiceImplementation implements GeneralServiceInterface<Product>{

	@Override
	public List<Product> getAllItems(SessionFactory sesssion) {
		// TODO Auto-generated method stub
	
		DBOperations< Product> dbOperations = new DBOperationsProduct();
			
		
		return dbOperations.getAllRow(sesssion);
	}

	@Override
	public Product getItem(int id,SessionFactory sesssion) {
		
		DBOperations< Product> dbOperations = new DBOperationsProduct();
		return dbOperations.getARow(sesssion, id);
	}

	
	
	@Override
	public void deleteItem(int id,SessionFactory session) {
		
		
		DBOperations<Product> opProduct = new DBOperationsProduct();
		
	
		opProduct.deleteRow(session, id);
	}

	@Override
	public void updateItem(Product item,SessionFactory session) {
		
		DBOperations<Product> opProduct = new DBOperationsProduct();
		
		opProduct.insert(session, item);
		
	}

	@Override
	public void insertItem(Product item, SessionFactory session) {
		
		
		DBOperations<Product> opProduct = new DBOperationsProduct();
		
		
		opProduct.insert(session, item);
			
	}

	@Override
	public List<Product> getRecommendedItems(SessionFactory session, int idType) {
		
		DBOperations<Product> opProduct = new DBOperationsProduct();
		
		List<Product> listRecommendation = opProduct.getAllSimilarRows(session, idType);
		
		return listRecommendation;
	}

	
	
	//public void insert
}