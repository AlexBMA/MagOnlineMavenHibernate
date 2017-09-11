package generalServices;

import java.util.List;

import org.hibernate.SessionFactory;

import dboperations.DBOperationUser;
import dboperations.DBOperations;
import modelMag.User;
import services.GeneralServiceInterface;

public class UserService implements GeneralServiceInterface<User> {

	@Override
	public List<User> getAllItems(SessionFactory session) {
		
		return null;
	}

	@Override
	public List<User> getRecommendedItems(SessionFactory session, int idType) {
		
		return null;
	}

	@Override
	public User getItem(int id, SessionFactory session) {
		DBOperations<User> userOperations = new DBOperationUser();
		
		return userOperations.getARow(session, id);
	}

	@Override
	public void deleteItem(int id, SessionFactory session) {
	
	}

	@Override
	public void updateItem(User item, SessionFactory session) {
		DBOperations<User> userOperations = new DBOperationUser();

		userOperations.insertOrUpdate(session, item);
	}

	@Override
	public void insertItem(User item, SessionFactory session) {
		DBOperations<User> userOperations = new DBOperationUser();

		userOperations.insertOrUpdate(session, item);
	}

}
