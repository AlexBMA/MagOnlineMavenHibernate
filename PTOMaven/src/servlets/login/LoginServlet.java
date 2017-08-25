package servlets.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import constantPack.AppRedirectPages;
import constantPack.AppRequestAttribute;
import constantPack.AppSessionAttributes;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Cart;
import serviciesImpl.LoginServiceImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Servlet for handling login", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter(AppRequestAttribute.USER);
		String pass = request.getParameter(AppRequestAttribute.PASSWORD);
		String role;

		DB.DBConnect();

		LoginServiceImplementation loginService = new LoginServiceImplementation();

		
		boolean check = loginService.checkLogin(userName, pass, DB.getSessionFactory());

		if (check == true) {
			System.out.println("##  all good");

			userName = loginService.getUser().getUsername();
			role = loginService.getUser().getRole();


			HttpSession theSession = request.getSession(true);
			theSession.setAttribute(AppSessionAttributes.USER_ID,loginService.getUser().getId());
			theSession.setAttribute(AppSessionAttributes.USERNAME, userName);
			theSession.setMaxInactiveInterval(AppConstants.MAX_INACTIVE_INTERVAL);
			
			if (role.equals(AppConstants.ROLE_ADMIN)) {
				System.out.println("admin login");
				PageHelper.nextPageJsp(request, response, AppJspPages.ADMIN_PAGE);
				return;
			}

			if (role.equals(AppConstants.ROLE_CLIENT)) {
				System.out.println("client login");
				Cart cart = new Cart();
				theSession.setAttribute(AppSessionAttributes.CART,cart);
				PageHelper.nextPageJsp(request, response, AppJspPages.CLIENT_PAGE);
				return;
			}
			
			//requestDispatcher = request.getRequestDispatcher(nextPage);
			//requestDispatcher.forward(request, response);

		} else {
			PageHelper.nextRedirect(response, AppRedirectPages.INDEX);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
