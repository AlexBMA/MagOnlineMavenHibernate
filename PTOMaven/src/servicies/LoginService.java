package servicies;

import org.hibernate.SessionFactory;

import dboperations.DBOperationUser;
import generalServices.UserAndPassCheck;
import generalServices.UserAndPassCheckImpl;
import modelMag.User;

public class LoginService {

	private  User user;
	
	
	
	
	public boolean checkLogin(String userName,String userPass,  SessionFactory theSessionFactory)
	{
		
		 DBOperationUser op  = new DBOperationUser();
	
		 System.out.println(userName +" 555   \t"+userPass);
		 
		 UserAndPassCheck userAndPassCheckService = new UserAndPassCheckImpl();
		  
		// String hashPass = userAndPassCheckService.createPass(userName, userPass);
		 
		 user = op.checkUserAndPass(theSessionFactory, userName, userPass);
		
	
		 
		if(user ==null)  return false;
			else return true;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
}
