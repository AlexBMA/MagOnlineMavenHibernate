package servlets.product;

import java.io.IOException;
import java.util.List;

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
import constantPack.AppServletsName;
import dboperations.DB;
import helperpack.PageHelper;
import helperpack.ProductHelper;
import modelMag.Product;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class SaveEditServlet
 */
@WebServlet("/SaveEditServlet")
public class SaveEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveEditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession theSession = request.getSession(false);
		if (theSession != null) {
			ProductHelper.updateProduct(request);

			PageHelper.nextPageServlet(request, response, AppServletsName.VIEW_ALL_PRODUCT_SERVLET);
			System.out.println("done with edit");
		}else {
			System.out.println(AppConstants.SESSION_HAS_EXPIRED);
		}
	}



}
