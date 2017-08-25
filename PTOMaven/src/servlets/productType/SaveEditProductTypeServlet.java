package servlets.productType;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import constantPack.AppConstants;
import constantPack.AppRequestAttribute;
import constantPack.AppServletsName;
import dboperations.DB;
import helperpack.PageHelper;
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
	
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			
			int indexProductType = Integer.parseInt(request.getParameter(AppRequestAttribute.PRODUCT_TYPE_ID).trim());
			String productTypeName = request.getParameter(AppRequestAttribute.PRODUCT_TYPE_NAME).trim();
			
			SessionFactory sessionFactory = DB.getSessionFactory();
			GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
			
			ProductType temp = productTypeService.getItem(indexProductType, sessionFactory);
			temp.setProductTypeName(productTypeName);
			productTypeService.insertItem(temp, sessionFactory);
			
			PageHelper.nextPageServlet(request, response,AppServletsName.VIEW_ALL_PRODUCT_TYPE_SERVLET);
			
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
		
	}

}
