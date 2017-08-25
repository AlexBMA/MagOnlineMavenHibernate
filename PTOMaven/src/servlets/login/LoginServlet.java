package servlets.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import constantPack.AppSessionAttributes;
import dboperations.DB;
import modelMag.Cart;
import services.AddPrefixAndSufixInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
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

		AddPrefixAndSufixInterface addSAndP = new AddPrefixAndSufixImplementation();

		boolean check = loginService.checkLogin(userName, pass, DB.getSessionFactory());

		if (check == true) {
			System.out.println("##  all good");

			userName = loginService.getUser().getUsername();
			role = loginService.getUser().getRole();

			String nextPage = "";
			RequestDispatcher requestDispatcher;

			HttpSession theSession = request.getSession(true);
			theSession.setAttribute(AppSessionAttributes.USER_ID,loginService.getUser().getId());
			theSession.setAttribute(AppSessionAttributes.USERNAME, userName);
			theSession.setMaxInactiveInterval(AppConstants.MAX_INACTIVE_INTERVAL);
			

			if (role.equals(AppConstants.ROLE_ADMIN)) {
				System.out.println("admin login");
				nextPage = addSAndP.createPath(AppJspPages.ADMIN_PAGE);

			}

			if (role.equals(AppConstants.ROLE_CLIENT)) {
				System.out.println("client login");
				nextPage = addSAndP.createPath(AppJspPages.CLIENT_PAGE);

				Cart cart = new Cart();
				
				theSession.setAttribute(AppSessionAttributes.CART,cart);
			}

			requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);

		} else {
			
			String NEXT_PAGE="index.jsp";
			response.sendRedirect(NEXT_PAGE);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
