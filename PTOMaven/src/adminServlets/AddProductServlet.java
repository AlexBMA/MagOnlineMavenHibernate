package adminServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dboperations.DB;
import modelMag.Product;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		
		
		int numberOfItems = Integer.parseInt(request.getParameter("numberofitems").trim());
		double priceOfItem = Double.parseDouble(request.getParameter("priceofproduct").trim());
		
		String productName = request.getParameter("productname").trim();
		String productTypeName = request.getParameter("productType").trim();
		String linkImage = request.getParameter("linkimage").trim();
		
		int indexProductType=0;
		
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
		
		List<ProductType>  productTypeList= productTypeService.getAllItems(DB.getSessionFactory());
		
		for(ProductType temp: productTypeList)
		{
			if(temp.getProductTypeName().equals(productTypeName))
			{
				indexProductType = temp.getId();
				break;
			}
		}
		
		Product tempProduct = new Product();
		tempProduct.setLinkImg(linkImage);
		tempProduct.setPrice(priceOfItem);
		tempProduct.setNumberOfItmes(numberOfItems);
		tempProduct.setProductTypeId(indexProductType);
		tempProduct.setName(productName);
		
		GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
		
		productService.insertItem(tempProduct, DB.getSessionFactory());
		
		String nextPage="ViewAllProductsServlet";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
		System.out.println("##$$ add product");
		
	}

}
