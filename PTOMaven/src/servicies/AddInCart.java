package servicies;

public interface AddInCart<E, C> {
	
	
	void addInCartOneItemMultipleTimes(E item, int numberOfItems, C cart);

	int checkIfItemAlreadyInCart(E item,int numberOfItems,C cart);
	
	double calculateTotalPriceForCart(C cart);
	
}
