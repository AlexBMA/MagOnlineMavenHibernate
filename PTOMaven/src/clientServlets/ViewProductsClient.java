package clientServlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import dboperations.DB;
import modelMag.Product;
import modelMag.ProductType;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class ViewProductsClient
 */
@WebServlet("/ViewProductsClient")
public class ViewProductsClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewProductsClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession theSession = request.getSession(false);
		if (theSession != null) {
			GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
			GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();

			List<Product> listProduct = productService.getAllItems(DB.getSessionFactory());
			List<ProductType> listProductType = productTypeService.getAllItems(DB.getSessionFactory());

			Map<Integer, ProductType> mapProductTypeService = new HashMap<>();

			for (ProductType temp : listProductType) {
				mapProductTypeService.put(temp.getId(), temp);
			}

			AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
			String nextPage = AppJspPages.ALL_PRODUCTS_CLIENT;
			nextPage = addPrefixAndSufix.createPath(nextPage);

			request.setAttribute(AppRequestAttribute.LIST_PRODUCTS, listProduct);
			request.setAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE, mapProductTypeService);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
			requestDispatcher.forward(request, response);
		} else {
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
		doGet(request, response);
	}

}
