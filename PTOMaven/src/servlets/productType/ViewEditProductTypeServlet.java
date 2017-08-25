package servlets.productType;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import dboperations.DB;
import helperpack.PageHelper;
import modelMag.ProductType;
import services.AddPrefixAndSufixInterface;
import services.GeneralServiceInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;
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
		if(theSession!=null)
		{
			int indexOfProductType = Integer.parseInt(request.getParameter("idproduct"));
			SessionFactory sessionFactory =  DB.getSessionFactory();
			
			GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
			ProductType temp = productTypeService.getItem(indexOfProductType, sessionFactory);
			
			String nextPage="EditProductType";
			request.setAttribute("producttype", temp);
			PageHelper.nextPage(request, response, nextPage);
			
		} else {
			
			System.out.println("");
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
