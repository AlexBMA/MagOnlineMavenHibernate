package modelMag;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart  {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="total_price_of_cart")
	private double totalPriceOfCart;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable( name="cart_product", 
						 joinColumns=@JoinColumn(name="product_id"),
						 inverseJoinColumns=@JoinColumn(name="card_id")
						)
	private List<ProductFromCart> productsFromCart;
	
	
	// totalPriceOfCart
	
	
	public double getTotalPretProdusDinCos() {
		return totalPriceOfCart;
	}

	public void setTotalPretProdusDinCos(double totalPretProdusDinCos) {
		this.totalPriceOfCart = totalPretProdusDinCos;
	}

	public Cart() {
		productsFromCart = new ArrayList<>();
	}

	public List<ProductFromCart> getProduseDinCos() {
		return productsFromCart;
	}

	public void setProduseDinCos(List<ProductFromCart> produseDinCos) {
		this.productsFromCart = produseDinCos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	
	

}
