package generalservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import generalServices.UserAndPassCheck;
import generalServices.UserAndPassCheckImpl;
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
		
		String newPass = "";
		String newPassAgain ="";
		
		if(newPass.contentEquals(newPassAgain))
		{
		
			HttpSession theSession = request.getSession(false);
		
			String username = (String) theSession.getAttribute("userName");
			UserAndPassCheck  userAndPassService = new UserAndPassCheckImpl();
		
			String newPassForDB = userAndPassService.createPass(username, newPass);
			
			LoginService loginService = new LoginService();
			loginService.getUser();
		}
		
	}

}
