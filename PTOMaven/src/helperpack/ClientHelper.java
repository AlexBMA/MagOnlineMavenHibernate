package helperpack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;

import constantPack.AppRequestAttribute;
import modelMag.Product;
import modelMag.ProductType;
import serviciesImpl.ProductServiceImplementation;
import serviciesImpl.ProductTypeServiceImplementation;

public class ClientHelper {
	
	public static void getAndSetDataForAllProductsClient(HttpServletRequest request, SessionFactory sessionFactory) {
		List<Product> listProduct = ProductServiceImplementation.getInstance().getAllRow(sessionFactory);	
		List<ProductType> listProductType = ProductTypeServiceImplementation.getInstance().getAllRow(sessionFactory);

		Map<Integer, ProductType> mapProductTypeService = new HashMap<>();

		for (ProductType temp : listProductType) {
			mapProductTypeService.put(temp.getId(), temp);
		}
		request.setAttribute(AppRequestAttribute.LIST_PRODUCTS, listProduct);
		request.setAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE, mapProductTypeService);
	}

}
