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
import modelMag.Cart;
import servicies.AddPrefixAndSufix;
import servicies.AddPrefixAndSufixImplementation;
import servicies.LoginService;

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

		String userName = request.getParameter("user");
		String pass = request.getParameter("pass");
		String role;

		DB.DBConnect();

		LoginService loginService = new LoginService();

		AddPrefixAndSufix addSAndP = new AddPrefixAndSufixImplementation();

		boolean check = loginService.checkLogin(userName, pass, DB.getSessionFactory());

		if (check == true) {
			System.out.println("##  all good");

			userName = loginService.getUser().getUsername();
			role = loginService.getUser().getRole();

			String nextPage = "";
			RequestDispatcher requestDispatcher;

			HttpSession theSession = request.getSession(true);
			theSession.setAttribute("userName", userName);

			if (role.equals("a")) {

				nextPage = addSAndP.createPath("AdminPage");

			}

			if (role.equals("c")) {
				nextPage = addSAndP.createPath("ClientPage");

				Cart cart = new Cart();
				
				theSession.setAttribute("cart",cart);
			}

			requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);

		} else {
			
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
