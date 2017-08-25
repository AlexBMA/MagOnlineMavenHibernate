package servlets.productType;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dboperations.DB;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class DeleteProductTypeServlet
 */
@WebServlet("/DeleteProductTypeServlet")
public class DeleteProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductTypeServlet() {
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
		
		int indexProductType = Integer.parseInt(request.getParameter("idproduct"));
		
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
		
		productTypeService.deleteItem(indexProductType,DB.getSessionFactory());
		
		String nextPage="ViewAllProductTypeServlet";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher( nextPage);
		
		requestDispatcher.forward(request, response);
	}

}
