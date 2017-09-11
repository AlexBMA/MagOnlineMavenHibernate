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
		
				
		SessionFactory sessionFactory = DB.getSessionFactory();
		List<ProductType>  productTypeList= ProductTypeServiceImplementation.getInstance().getAllRow(sessionFactory);
		
		for(ProductType temp: productTypeList){
			if(temp.getProductTypeName().equals(productTypeName)){
				idProductType = temp.getId();
				break;
			}
		}
		Product tempProduct = new Product.Builder()
																			.name(productName)
																			.price(priceOfItem)
																			.numberOfItems(numberOfItems)
																			.priceTypeId(idProductType)
																			.linkImg(linkImage).build();
			
		ProductServiceImplementation.getInstance().insertOrUpdate(sessionFactory, tempProduct);
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

		
		Product tempProduct = ProductServiceImplementation.getInstance().getARow(sessionFactory, idProduct);
		tempProduct.setLinkImg(linkImage);
		tempProduct.setPrice(priceOfItem);
		tempProduct.setNumberOfItmes(numberOfItems);
		tempProduct.setProductTypeId(idProductType);
		tempProduct.setName(productName);

		ProductServiceImplementation.getInstance().insertOrUpdate(sessionFactory, tempProduct);
	}


	public static void deleteProduct(HttpServletRequest request,SessionFactory sessionFactory) {
		int idProduct = Integer.parseInt(request.getParameter(AppRequestAttribute.ID_PRODUCT));
		ProductTypeServiceImplementation.getInstance().deleteRow(sessionFactory, idProduct);
	}
	
	
	public static int getProductTypeName(String productTypeName, int idProductType, SessionFactory sessionFactory) {
		List<ProductType> productTypeList = ProductTypeServiceImplementation.getInstance().getAllRow(sessionFactory);
	
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
		
		List<Product> listProduct = ProductServiceImplementation.getInstance().getAllRow(sessionFactory);
		List<ProductType> listProductType = ProductTypeServiceImplementation.getInstance().getAllRow(sessionFactory);
		Map<Integer,ProductType> mapOfProductType = new HashMap<>();
		
		for( ProductType p :listProductType){
			mapOfProductType.put(p.getId(), p);
		}
		
		request.setAttribute(AppRequestAttribute.LIST_PRODUCTS, listProduct);
		request.setAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE,mapOfProductType);
	}
}
