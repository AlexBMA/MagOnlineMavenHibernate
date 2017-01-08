package clientServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dboperations.DB;
import modelMag.Cart;
import servicies.CartService;
import servicies.GeneralServiceInterface;

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
		
		GeneralServiceInterface<Cart> cartService = new CartService();
		
		Cart cart = (Cart)theSession.getAttribute("cart");
		
		cartService.insertItem(cart, DB.getSessionFactory());
		
		System.out.println("done");
		
		
	}

}
