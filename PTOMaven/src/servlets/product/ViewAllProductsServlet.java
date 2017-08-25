package servlets.product;

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

import dboperations.DB;
import modelMag.Product;
import modelMag.ProductType;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class ViewAllProductsServlet
 */
@WebServlet("/ViewAllProductsServlet")
public class ViewAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: $$ ").append(request.getContextPath());
		
		GeneralServiceInterface<Product> operationProduct = new ProductServiceImplementation();
		
		GeneralServiceInterface<ProductType> operationProductType = new ProductTypeServiceImplementation();
		
		List<Product> listProduct = operationProduct.getAllItems(DB.getSessionFactory());
		
		List<ProductType> listProductType = operationProductType.getAllItems(DB.getSessionFactory());
		
		Map<Integer,ProductType> mapOfProductType = new HashMap<>();
		
		for( ProductType p :listProductType)
		{
			mapOfProductType.put(p.getId(), p);
		}
		
		
		
		String nextPage="AllProducts";
		AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		request.setAttribute("listproduct", listProduct);
		request.setAttribute("mapproducttype", mapOfProductType);
		
		RequestDispatcher requestDispacher = request.getRequestDispatcher(nextPage);
		requestDispacher.forward(request, response);
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
