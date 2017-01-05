package adminServlets;

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
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int indexProduct = Integer.parseInt(request.getParameter("idproduct"));
		
		AddPrefixAndSufix addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		
		GeneralServiceInterface<Product> productService = new ProductService();
		
		GeneralServiceInterface<ProductType> operationProductType = new ProductTypeService();
		
		List<ProductType> listProductType = operationProductType.getAllItems(DB.getSessionFactory());
		
		Map<Integer,ProductType> mapOfProductType = new HashMap<>();
		
		for( ProductType p :listProductType)
		{
			mapOfProductType.put(p.getId(), p);
		}
		
		System.out.println(indexProduct);
			
		Product productLocal = productService.getItem(indexProduct, DB.getSessionFactory());
		
		
		System.out.println(productLocal.getName() +"%%%%%%%%%%%%%%%%%%");
		
		
		String nextPage="EditProduct";
		nextPage = addPrefixAndSufix.createPath(nextPage);
		
		RequestDispatcher requestDispacher = request.getRequestDispatcher(nextPage);
		
		request.setAttribute("productlocal", productLocal);
		request.setAttribute("mapproducttype", mapOfProductType);
		
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
