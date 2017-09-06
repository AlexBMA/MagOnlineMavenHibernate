package clientServlets;

import java.io.IOException;

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
import helperpack.PageHelper;
import modelMag.Cart;
import services.GeneralServiceInterface;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession theSession = request.getSession(false);
		if(theSession !=null){
			GeneralServiceInterface<Cart> cartService = new CartServiceImplementation();
			Cart cart = (Cart)theSession.getAttribute(AppSessionAttributes.CART);
			cartService.insertItem(cart, DB.getSessionFactory());
			cart = new Cart();
			
			theSession.setAttribute(AppSessionAttributes.CART, cart);
		
			String msg = "Tranzaction complete";
			request.setAttribute(AppRequestAttribute.MSG, msg);
			
			PageHelper.nextPageJsp(request, response, AppJspPages.VIEW_CART);
			//System.out.println("done");
		}
		else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
		
		
		
	}

}
