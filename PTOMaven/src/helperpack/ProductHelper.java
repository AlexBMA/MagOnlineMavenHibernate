package helperpack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;

import constantPack.AppRequestAttribute;
import dboperations.DB;
import modelMag.Product;
import modelMag.ProductType;
import services.GeneralServiceInterface;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

public class ProductHelper {
	
	public static void insertProduct(HttpServletRequest request) {
		int numberOfItems = Integer.parseInt(request.getParameter(AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS).trim());
		double priceOfItem = Double.parseDouble(request.getParameter(AppRequestAttribute.PRODUCT_PRICE).trim());
		
		String productName = request.getParameter(AppRequestAttribute.PRODUCT_NAME).trim();
		String productTypeName = request.getParameter(AppRequestAttribute.PRODUCT_TYPE_NAME).trim();
		String linkImage = request.getParameter(AppRequestAttribute.PRODUCT_LINK_IMG).trim();
		
		int idProductType=0;
		
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
		
		SessionFactory sessionFactory = DB.getSessionFactory();
		List<ProductType>  productTypeList= productTypeService.getAllItems(sessionFactory);
		
		for(ProductType temp: productTypeList){
			if(temp.getProductTypeName().equals(productTypeName)){
				idProductType = temp.getId();
				break;
			}
		}
		
		Product tempProduct = new Product();
		tempProduct.setLinkImg(linkImage);
		tempProduct.setPrice(priceOfItem);
		tempProduct.setNumberOfItmes(numberOfItems);
		tempProduct.setProductTypeId(idProductType);
		tempProduct.setName(productName);
		
		GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
		
		productService.insertItem(tempProduct, sessionFactory);
	}


	public static void  updateProduct(HttpServletRequest request) {
		//System.out.println(request.getParameter("indexproduct"));
		int idProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT).trim());

		String productName = request.getParameter(AppRequestAttribute.PRODUCT_NAME).trim();
		//request.getParameter(AppRequestAttribute)
		String productTypeName = request.getParameter(AppRequestAttribute.PRODUCT_TYPE_NAME).trim();
		//request.getParameter(AppRequestAttribute.PRODUCT_TYPE_NAME);
		String linkImage = request.getParameter(AppRequestAttribute.PRODUCT_LINK_IMG).trim();

		
		int numberOfItems = Integer.parseInt(request.getParameter(AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS).trim());
		double priceOfItem = Double.parseDouble(request.getParameter(AppRequestAttribute.PRODUCT_PRICE).trim());

		//System.out.println("## " + request.getParameter("numberofitems").trim());
		//System.out.println("### " + request.getParameter("priceofproduct").trim());


		int idProductType = 0;
		SessionFactory sessionFactory = DB.getSessionFactory();
		idProductType = getProductTypeName(productTypeName, idProductType, sessionFactory);

		GeneralServiceInterface<Product> productService = new ProductServiceImplementation();

		Product tempProduct = productService.getItem(idProduct, sessionFactory);
		tempProduct.setLinkImg(linkImage);
		tempProduct.setPrice(priceOfItem);
		tempProduct.setNumberOfItmes(numberOfItems);
		tempProduct.setProductTypeId(idProductType);
		tempProduct.setName(productName);

		productService.insertItem(tempProduct, sessionFactory);
	}


	public static void deleteProduct(HttpServletRequest request) {
		int idProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT));
		GeneralServiceInterface<Product> productService = new ProductServiceImplementation();
		productService.deleteItem(idProduct, DB.getSessionFactory());
	}
	
	
	public static int getProductTypeName(String productTypeName, int idProductType, SessionFactory sessionFactory) {
		GeneralServiceInterface<ProductType> productTypeService = new ProductTypeServiceImplementation();
		List<ProductType> productTypeList = productTypeService.getAllItems(sessionFactory);
	
		for (ProductType temp : productTypeList) {
			if (temp.getProductTypeName().equals(productTypeName)) {
				idProductType = temp.getId();
				break;
			}
		}
		return idProductType;
	}
	
	public static void getAndPutDataInRequest(HttpServletRequest request) {
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
	}
}
