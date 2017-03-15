package generalservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dboperations.DB;
import dboperations.DBOperationUser;
import dboperations.DBOperations;
import generalServices.UserAndPassCheck;
import generalServices.UserAndPassCheckImpl;
import generalServices.UserService;
import modelMag.User;
import servicies.AddPrefixAndSufix;
import servicies.AddPrefixAndSufixImplementation;
import servicies.GeneralServiceInterface;
import servicies.LoginService;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
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
		
		String newPass = request.getParameter("newpass");
		String newPassAgain = request.getParameter("newpass2");
		
		if(newPass.contentEquals(newPassAgain))
		{
		
			HttpSession theSession = request.getSession(false);
		
			String username = (String) theSession.getAttribute("userName");
			String idString =   theSession.getAttribute("uId")+"";
			System.out.println(idString+" %%");
			int id = Integer.parseInt(idString);
			
			
			GeneralServiceInterface<User> userService = new UserService();
			
			UserAndPassCheck  userAndPassService = new UserAndPassCheckImpl();
		
			String newPassForDB = userAndPassService.createPass(username, newPass);
			
			User u = userService.getItem(id, DB.getSessionFactory());
			u.setPass(newPassForDB);
			
			userService.insertItem(u, DB.getSessionFactory());
			
			
			DBOperations<User> userOperations = new DBOperationUser();
			userOperations.insert(DB.getSessionFactory(), u);
			
			
			AddPrefixAndSufix addSAndP = new AddPrefixAndSufixImplementation();
			String NEXT_PAGE =addSAndP.createPath("AdminPage");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(NEXT_PAGE);
			requestDispatcher.forward(request, response);
					
			
		}
		else {
			String NEXT_PAGE ="ChangePass.jsp";
			response.sendRedirect(NEXT_PAGE);
		}
		
	}

}
