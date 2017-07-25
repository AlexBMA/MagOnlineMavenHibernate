package clientServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constantPack.AppRequestAttribute;
import constantPack.AppServletsName;
import constantPack.AppSessionAttributes;
import modelMag.Cart;
import modelMag.Product;
import services.AddInCartInterface;
import serviciesImpl.AddInCartImplementation;

/**
 * Servlet implementation class DeleteProductFromCartServlet
 */
@WebServlet("/DeleteProductFromCartServlet")
public class DeleteProductFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	System.out.println("IN DELETE SERVLET");
		String indexText = request.getParameter(AppRequestAttribute.INDEX_OF_PRODUCT);
		int index =Integer.parseInt(indexText);
		
		Cart theCart = (Cart) request.getSession(false).getAttribute(AppSessionAttributes.CART);
				theCart.getProductsFromCart().remove(index);
				
		AddInCartInterface<Product, Cart> addInCartProduct = new AddInCartImplementation();
		addInCartProduct.calculateTotalPriceForCart(theCart);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(AppServletsName.VIEW_CART_CLIENT_SERVLET);
		requestDispatcher.forward(request, response);
		
	}

}
