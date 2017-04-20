package adminServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dboperations.DB;
import modelMag.Product;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int indexProduct = Integer.parseInt(request.getParameter("idproduct"));
		
		GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
		
		//AddPrefixAndSufix addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		
		
		
		productService.deleteItem(indexProduct,DB.getSessionFactory());
		
		String nextPage="ViewAllProductsServlet";
		
		//nextPage = addPrefixAndSufix.createPath(nextPage);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		
		requestDispatcher.forward(request, response);
		
		System.out.println("##$$ delete product");
	}

}
