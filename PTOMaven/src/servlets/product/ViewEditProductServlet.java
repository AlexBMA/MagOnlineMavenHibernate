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
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.Product;
import modelMag.ProductType;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class ViewEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			int indexProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT));
			
			SessionFactory sessionFactory = DB.getSessionFactory();
			GeneralServiceInterface<ProductType> operationProductType = new ProductTypeServiceImplementation();
			List<ProductType> listProductType = operationProductType.getAllItems(sessionFactory);
			
			Map<Integer,ProductType> mapOfProductType = new HashMap<>();
			for( ProductType p :listProductType){
				mapOfProductType.put(p.getId(), p);
			}

			System.out.println(indexProduct);
			
			GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
			Product productTemp = productService.getItem(indexProduct, sessionFactory);
			
			System.out.println(productTemp.getName() +"%%%%%%%%%%%%%%%%%%");
			
			request.setAttribute(AppRequestAttribute.PRODUCT_TEMP, productTemp);
			request.setAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE, mapOfProductType);
			//request.setAttribute("mapproducttype", mapOfProductType);
			
			PageHelper.nextPageJsp(request, response, AppJspPages.EDIT_PRODUCT);
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
