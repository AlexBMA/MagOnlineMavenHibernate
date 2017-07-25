package clientServlets;

import java.io.IOException;
import java.util.List;

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
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.ProductServiceImplementation;

/**
 * Servlet implementation class ViewDetailsProductClient
 */
@WebServlet("/ViewDetailsProductClient")
public class ViewDetailsProductClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailsProductClientServlet() {
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
		if(theSession!=null)
		{
			int indexProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT).trim());
			GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
			
			Product tempProduct = productService.getItem(indexProduct, DB.getSessionFactory());
			List<Product> listRecommendation  =productService.getRecommendedItems(DB.getSessionFactory(), tempProduct.getProductTypeId());

			AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		
			request.setAttribute(AppRequestAttribute.PRODUCT_TEMP,tempProduct);
			request.setAttribute(AppRequestAttribute.LIST_OF_RECOMMENDED, listRecommendation);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(addPrefixAndSufix.createPath(AppJspPages.VIEW_DETAILS_CLIENT));
			requestDispatcher.forward(request, response);
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
		
	
	}

}
