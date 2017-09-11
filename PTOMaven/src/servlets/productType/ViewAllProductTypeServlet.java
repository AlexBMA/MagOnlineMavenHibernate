package servlets.productType;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import constantPack.AppRequestAttribute;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.ProductType;
import services.GeneralServiceInterface;
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
		
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			
			
			List<ProductType> listProductType =ProductTypeServiceImplementation.getInstance().getAllRow(DB.getSessionFactory());
			request.setAttribute(AppRequestAttribute.LIST_PRODUCT_TYPE, listProductType);
			PageHelper.nextPageJsp(request, response, AppJspPages.ALL_PRODUCT_TYPE);
			
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
	
	}

}
