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
import constantPack.AppSessionAttributes;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Cart;
import services.AddInCartInterface;
import serviciesImpl.AddInCartImplementation;

/**
 * Servlet implementation class ViewCartClientServlet
 */
@WebServlet("/ViewCartClientServlet")
public class ViewCartClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewCartClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			Cart theCart = (Cart) theSession.getAttribute(AppSessionAttributes.CART);
			AddInCartInterface<Integer, Cart> addInCart = new AddInCartImplementation();
			addInCart.calculateTotalPriceForCart(theCart,DB.getSessionFactory());

			PageHelper.nextPageJsp(request, response, AppJspPages.VIEW_CART);
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
