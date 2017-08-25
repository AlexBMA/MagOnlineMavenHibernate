package servlets.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constantPack.AppConstants;
import constantPack.AppJspPages;
import helperpack.PageHelper;
import helperpack.ProductHelper;

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
			ProductHelper.getAndPutDataInRequest(request);
			
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
