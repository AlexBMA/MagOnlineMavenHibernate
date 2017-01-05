package servicies;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperationProductType;
import dboperations.DBOperations2;
import modelMag.ProductType;

public class ProductTypeService implements GeneralServiceInterface<ProductType> {

	@Override

	public ProductType getItem(int id, SessionFactory sesssion) {

		DBOperations2<ProductType> dbOperations = new DBOperationProductType();
		return dbOperations.getARow(sesssion, id);

	}

	@Override
	public void deleteItem(int id, SessionFactory sesssion) {
		DBOperations2<ProductType> dbOperations = new DBOperationProductType();
		dbOperations.deleteRow(sesssion, id);

	}

	@Override
	public void updateItem(ProductType item, SessionFactory sesssion) {

	}

	@Override
	public List<ProductType> getAllItems(SessionFactory sesssion) {

		DBOperations2<ProductType> dbOperations = new DBOperationProductType();

		return dbOperations.getAllRow(sesssion);
	}

	@Override
	public void insertItem(ProductType item, SessionFactory session) {

		DBOperations2<ProductType> dbOperations = new DBOperationProductType();

		dbOperations.insert(session, item);

	}

}
