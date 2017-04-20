package adminServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dboperations.DB;
import modelMag.ProductType;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class ViewAllProductTypeServlet
 */
@WebServlet("/ViewAllProductTypeServlet")
public class ViewAllProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllProductTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GeneralServiceInterface<ProductType> operationProductType = new ProductTypeServiceImplementation();
		List<ProductType> listProductType = operationProductType.getAllItems(DB.getSessionFactory());
		
		String nextPage="AllProductType";
		AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		request.setAttribute("listproducttype", listProductType);
		RequestDispatcher requestDispacher = request.getRequestDispatcher(nextPage);
		requestDispacher.forward(request, response);
		
	}

}
