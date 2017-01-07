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
import modelMag.Product;
import servicies.AddInCart;
import servicies.AddInCartImplementationProduct;
import servicies.GeneralServiceInterface;
import servicies.ProductService;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("indexofproduct"));
		System.out.println(request.getParameter("numberofitems"));
		
		int indexOfItem = Integer.parseInt(request.getParameter("indexofproduct").trim());
		int numberOfItems = Integer.parseInt(request.getParameter("numberofitems").trim());
		
		AddInCart<Product,Cart> addInCartProducts = new AddInCartImplementationProduct();
		
		GeneralServiceInterface<Product> productService = new ProductService();
		Product temp = productService.getItem(indexOfItem, DB.getSessionFactory());
		
		HttpSession theSession = request.getSession(false);
		
		Cart theCart = (Cart) theSession.getAttribute("cart");
		addInCartProducts.addInCartOneItemMultipleTimes(temp, numberOfItems, theCart);
		
		
		String nextPage="ViewProductsClient";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
		System.out.println("$$$$");
		
		System.out.println("All good here %$%$$$");
		
	}

}
