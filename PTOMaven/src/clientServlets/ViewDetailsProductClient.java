package clientServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dboperations.DB;
import modelMag.Product;
import servicies.AddPrefixAndSufix;
import servicies.AddPrefixAndSufixImplementation;
import servicies.GeneralServiceInterface;
import servicies.ProductService;

/**
 * Servlet implementation class ViewDetailsProductClient
 */
@WebServlet("/ViewDetailsProductClient")
public class ViewDetailsProductClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetailsProductClient() {
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
		
		int indexProduct = Integer.parseInt(request.getParameter("idproduct").trim());
		
		GeneralServiceInterface<Product> productService = new ProductService();
		
		Product temp = productService.getItem(indexProduct, DB.getSessionFactory());
		
		List<Product> listRecommendation  =productService.getRecommendedItems(DB.getSessionFactory(), temp.getProductTypeId());
				
		
		String nextPage="ViewDetailsClient";
		AddPrefixAndSufix addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		request.setAttribute("product",temp);
		request.setAttribute("listofrecommended", listRecommendation);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		
		requestDispatcher.forward(request, response);
	}

}
