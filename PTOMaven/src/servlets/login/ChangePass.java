package servlets.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import constantPack.AppSessionAttributes;
import dboperations.DB;
import dboperations.DBOperationUser;
import dboperations.DBOperations;
import generalServices.UserAndPassCheck;
import generalServices.UserAndPassCheckImpl;
import generalServices.UserService;
import helperpack.PageHelper;
import modelMag.User;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.LoginServiceImplementation;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			
			String newPass = request.getParameter(AppRequestAttribute.NEW_PASS);
			String newPassAgain = request.getParameter(AppRequestAttribute.NEW_PASS2);
			
			if(newPass.contentEquals(newPassAgain)){
			
				String username = (String) theSession.getAttribute(AppSessionAttributes.USERNAME);
				String idString =   theSession.getAttribute(AppSessionAttributes.USER_ID)+"";
				System.out.println(idString+" %%");
				int id = Integer.parseInt(idString);
				
				GeneralServiceInterface<User> userService = new UserService();
				UserAndPassCheck  userAndPassService = new UserAndPassCheckImpl();
			
				String newPassForDB = userAndPassService.createPass(username, newPass);
				
				SessionFactory sessionFactory = DB.getSessionFactory();
				
				User u = userService.getItem(id, sessionFactory);
				u.setPass(newPassForDB);
				userService.insertItem(u, sessionFactory);
				
				DBOperations<User> userOperations = new DBOperationUser();
				userOperations.insertOrUpdate(sessionFactory, u);
				
				PageHelper.nextPageJsp(request, response, AppJspPages.ADMIN_PAGE);
			}
			else {
				String NEXT_PAGE ="ChangePass.jsp";
				response.sendRedirect(NEXT_PAGE);
			}
			
		} else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
		
		
	}

}
