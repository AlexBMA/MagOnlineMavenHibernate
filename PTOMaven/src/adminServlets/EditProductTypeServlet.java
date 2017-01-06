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
import servicies.AddPrefixAndSufix;
import servicies.AddPrefixAndSufixImplementation;
import servicies.GeneralServiceInterface;
import servicies.ProductTypeService;

/**
 * Servlet implementation class EditProductTypeServlet
 */
@WebServlet("/EditProductTypeServlet")
public class EditProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int indexOfProductType = Integer.parseInt(request.getParameter("idproduct"));
		
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeService();
		
		ProductType temp = productTypeService.getItem(indexOfProductType, DB.getSessionFactory());
		
		String nextPage="EditProductType";
		AddPrefixAndSufix addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage  = addPrefixAndSufix.createPath(nextPage);
		
		request.setAttribute("producttype", temp);
		RequestDispatcher requestDispatcher= request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
