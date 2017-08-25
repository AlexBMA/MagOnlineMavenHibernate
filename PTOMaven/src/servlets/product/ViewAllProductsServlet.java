package servlets.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Product;
import modelMag.ProductType;
import services.GeneralServiceInterface;
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
		
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			SessionFactory sessionFactory = DB.getSessionFactory();
			
			GeneralServiceInterface<Product> operationProduct = new ProductServiceImplementation();
			List<Product> listProduct = operationProduct.getAllItems(sessionFactory);
			
			GeneralServiceInterface<ProductType> operationProductType = new ProductTypeServiceImplementation();
			List<ProductType> listProductType = operationProductType.getAllItems(sessionFactory);
			
			Map<Integer,ProductType> mapOfProductType = new HashMap<>();
			
			for( ProductType p :listProductType)
			{
				mapOfProductType.put(p.getId(), p);
			}
			
			request.setAttribute(AppRequestAttribute.LIST_PRODUCTS, listProduct);
			request.setAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE,mapOfProductType);
			
			PageHelper.nextPageJsp(request, response, AppJspPages.ALL_PRODUCT_ADMIN);
			
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
