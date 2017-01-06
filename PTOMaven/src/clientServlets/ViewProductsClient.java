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

import dboperations.DB;
import modelMag.Product;
import modelMag.ProductType;
import servicies.AddPrefixAndSufix;
import servicies.AddPrefixAndSufixImplementation;
import servicies.GeneralServiceInterface;
import servicies.ProductService;
import servicies.ProductTypeService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		GeneralServiceInterface<Product> productService = new ProductService(); 
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeService();
		
		List<Product> listProduct = productService.getAllItems(DB.getSessionFactory());
		List<ProductType> listProductType = productTypeService.getAllItems(DB.getSessionFactory());
		
		Map<Integer,ProductType> mapProductTypeService = new HashMap<>();
		
		for(ProductType temp:listProductType)
		{
			mapProductTypeService.put(temp.getId(), temp);
		}
		
		AddPrefixAndSufix addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		String nextPage="AllProductsClient";
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		request.setAttribute("listproduct", listProduct);
		request.setAttribute("mapproducttype", mapProductTypeService);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
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
