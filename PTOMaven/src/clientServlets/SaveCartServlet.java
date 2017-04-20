package clientServlets;

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
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.CartServiceImplementation;

/**
 * Servlet implementation class SaveCartServlet
 */
@WebServlet("/SaveCartServlet")
public class SaveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCartServlet() {
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
		
		
		HttpSession theSession = request.getSession(false);
		
		GeneralServiceInterface<Cart> cartService = new CartServiceImplementation();
		
		Cart cart = (Cart)theSession.getAttribute("cart");
		
		cartService.insertItem(cart, DB.getSessionFactory());
		
		cart = new Cart();
		
		theSession.setAttribute("cart", cart);
		
		
		
		String nextPage="ViewCart";
		AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		String msg = "Tranzaction complete";
		
		request.setAttribute("msg", msg);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
		System.out.println("done");
		
	}

}
