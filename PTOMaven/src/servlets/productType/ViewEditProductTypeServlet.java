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
import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class EditProductTypeServlet
 */
@WebServlet("/EditProductTypeServlet")
public class ViewEditProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEditProductTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			int indexOfProductType = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT));
			SessionFactory sessionFactory =  DB.getSessionFactory();
			
			GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
			ProductType temp = productTypeService.getItem(indexOfProductType, sessionFactory);
			
			request.setAttribute(AppRequestAttribute.TEMP_PRODUCT_TYPE, temp);
			PageHelper.nextPageJsp(request, response, AppJspPages.EDIT_PRODUCT_TYPE);
			
		} else {
			
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
