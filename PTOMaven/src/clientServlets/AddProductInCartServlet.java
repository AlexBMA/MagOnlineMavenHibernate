package clientServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import constantPack.AppConstants;
import constantPack.AppRequestAttribute;
import constantPack.AppServletsName;
import constantPack.AppSessionAttributes;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Cart;
import modelMag.Product;
import services.AddInCartInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddInCartImplementation;
import serviciesImpl.ProductServiceImplementation;

/**
 * Servlet implementation class AddProductInCartServlet
 */
@WebServlet("/AddProductInCartServlet")
public class AddProductInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductInCartServlet() {
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
			int numberOfItems =1;
			
			if(request.getParameter(AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS)!=null){
				numberOfItems = Integer.parseInt(request.getParameter(AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS).trim());
			}
			
			int idProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.INDEX_OF_PRODUCT).trim());
			
			SessionFactory sessionFactory = DB.getSessionFactory();
			GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
			Product temp = productService.getItem(idProduct, sessionFactory);
			
			Cart theCart = (Cart) theSession.getAttribute(AppSessionAttributes.CART);
			AddInCartInterface<Product,Cart> addInCartProducts = new AddInCartImplementation();
			addInCartProducts.addInCartOneItemMultipleTimes(temp, numberOfItems, theCart);
			
			theSession.setAttribute(AppSessionAttributes.CART, theCart);
			
			PageHelper.nextPageJsp(request, response, AppServletsName.VIEW_PRODUCTS_CLIENT);
		}
		else{
				System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}		
		
	}

}
