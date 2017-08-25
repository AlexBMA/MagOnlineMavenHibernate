package servlets.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constantPack.AppRequestAttribute;
import dboperations.DB;
import generalServices.UserAndPassCheck;
import generalServices.UserAndPassCheckImpl;
import generalServices.UserService;
import modelMag.User;
import services.GeneralServiceInterface;
import serviciesImpl.LoginServiceImplementation;

/**
 * Servlet implementation class CreateNewUser
 */
@WebServlet("/CreateNewUser")
public class CreateNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(DB.getSessionFactory()== null) DB.DBConnect();
		
		
		String  username=request.getParameter(AppRequestAttribute.USER);
		String pass=request.getParameter(AppRequestAttribute.PASS_ONE);
		String passAgain=request.getParameter(AppRequestAttribute.PASS_TWO);
		String role =request.getParameter(AppRequestAttribute.ROLE);
		
		if(pass.contentEquals(passAgain))
		{
				User tempUser= new User();
				
				UserAndPassCheck userAndPassCheck = new UserAndPassCheckImpl();
				
				String passForDb = userAndPassCheck.createPass(username, pass);
				
				tempUser.setUsername(username);
				tempUser.setRole(role);
				tempUser.setPass(passForDb);
				
				GeneralServiceInterface<User> userService = new UserService();
				
				userService.updateItem(tempUser, DB.getSessionFactory());
				
				String NEXT_PAGE="index.jsp";
				
				response.sendRedirect(NEXT_PAGE);
				
		}
	
		
		
		
		
		
		
	
	}

}
