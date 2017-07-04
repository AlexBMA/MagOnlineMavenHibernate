package dboperations;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import constantPack.AppConstants;
import modelMag.Cart;
import modelMag.Product;
import modelMag.ProductFromCart;
import modelMag.ProductType;
import modelMag.User;




public class DB {
	
	private static SessionFactory factory;
	
	public static void  DBConnect()
	{
		// create session factory
				factory = new Configuration()
											.configure(AppConstants.HIBERNATE_CONFIG_FILE)
											.addAnnotatedClass(User.class)
											.addAnnotatedClass(Product.class)
											.addAnnotatedClass(Cart.class)
											.addAnnotatedClass(ProductType.class)
											.addAnnotatedClass(ProductFromCart.class)
											.buildSessionFactory();
	}
	
	public static  SessionFactory getSessionFactory()
	{
		return factory;
	}
	
	public static void closeFactory()
	{
		factory.close();
	}
}
