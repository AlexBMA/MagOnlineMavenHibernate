package adminServlets;

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
 * Servlet implementation class SaveEditProductTypeServlet
 */
@WebServlet("/SaveEditProductTypeServlet")
public class SaveEditProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEditProductTypeServlet() {
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
		
		int indexProductType = Integer.parseInt(request.getParameter("idproducttype").trim());
		String productTypeName = request.getParameter("nameofproducttype").trim();
		
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
		
		ProductType temp = productTypeService.getItem(indexProductType, DB.getSessionFactory());
		temp.setProductTypeName(productTypeName);
		productTypeService.insertItem(temp, DB.getSessionFactory());
		
		
		String nextPage = "ViewAllProductTypeServlet";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
		
	}

}
