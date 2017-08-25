package servlets.product;

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
import constantPack.AppServletsName;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Product;
import services.GeneralServiceInterface;
import serviciesImpl.ProductServiceImplementation;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProductServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession theSession = request.getSession(false);
		if (theSession != null) {
			int indexProduct = Integer.parseInt(request.getParameter("idproduct"));

			GeneralServiceInterface<Product> productService = new ProductServiceImplementation();

			productService.deleteItem(indexProduct, DB.getSessionFactory());

			
			String nextPage = "ViewAllProductsServlet";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);
			
			PageHelper.nextPageServlet(request, response, AppServletsName.VIEW_ALL_PRODUCT_SERVLET);

			System.out.println("##$$ delete product");

		} else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
	}

}
