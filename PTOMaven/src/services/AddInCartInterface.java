package services;

import org.hibernate.SessionFactory;

public interface AddInCartInterface<E, C> {
	
	
	void addInCartOneItemMultipleTimes(E item, int numberOfItems, C cart);

	int checkIfItemAlreadyInCart(E item,int numberOfItems,C cart);
	
	double calculateTotalPriceForCart(C cart,SessionFactory sessionFactory);
	
}
