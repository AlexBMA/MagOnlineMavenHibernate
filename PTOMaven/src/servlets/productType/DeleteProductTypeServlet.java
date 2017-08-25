package servlets.productType;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constantPack.AppConstants;
import constantPack.AppRequestAttribute;
import constantPack.AppServletsName;
import dboperations.DB;
import helperpack.PageHelper;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class DeleteProductTypeServlet
 */
@WebServlet("/DeleteProductTypeServlet")
public class DeleteProductTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession theSession = request.getSession(false);
		if(theSession!=null){
			int idProductType = Integer.parseInt(request.getParameter(AppRequestAttribute.PRODUCT_TYPE_ID));
			
			GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
			productTypeService.deleteItem(idProductType,DB.getSessionFactory());
			
			PageHelper.nextPageServlet(request, response,AppServletsName.VIEW_ALL_PRODUCT_TYPE_SERVLET);
		}
		else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
			
		
	}

}
