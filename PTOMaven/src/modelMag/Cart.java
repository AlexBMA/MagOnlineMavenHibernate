package modelMag;

import java.util.ArrayList;
import java.util.List;

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
	
	public  static class Builder{
		private int id =0;
		private double totalPriceOfCart =0;
		private List<ProductFromCart> productsFromCart = new ArrayList<>();
		
		
		public Builder id(int val) { id= val; return this;}
		public Builder totalPriceOfCart(double val) {totalPriceOfCart = val; return this;}
		public Builder productsFromCart(List<ProductFromCart> val){ productsFromCart = val; return this;}
		
		public Cart  build(){
			return new Cart(this);
		}
		
	}

	public Cart() {
		totalPriceOfCart = 0;
		productsFromCart = new ArrayList<>();
	}

	public Cart(Builder builder) {
		this.id = builder.id;
		this.totalPriceOfCart = builder.totalPriceOfCart;
		this.productsFromCart = builder.productsFromCart;
	}

	
	
	public double getTotalPriceForProductFormCart() {
		return totalPriceOfCart;
	}

	public void setTotalPriceForProductFromCart(double totalPriceOfCart) {
		this.totalPriceOfCart = totalPriceOfCart;
	}
	
	public List<ProductFromCart> getProductsFromCart() {
		return productsFromCart;
	}

	public void setProductsFromCart(List<ProductFromCart> productsFromCart) {
		this.productsFromCart = productsFromCart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalPriceOfCart=" + totalPriceOfCart + ", productsFromCart=" + productsFromCart.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((productsFromCart == null) ? 0 : productsFromCart.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalPriceOfCart);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (productsFromCart == null) {
			if (other.productsFromCart != null)
				return false;
		} else if (!productsFromCart.equals(other.productsFromCart))
			return false;
		if (Double.doubleToLongBits(totalPriceOfCart) != Double.doubleToLongBits(other.totalPriceOfCart))
			return false;
		return true;
	}

	public double getTotalPriceOfCart() {
		return totalPriceOfCart;
	}

	public void setTotalPriceOfCart(double totalPriceOfCart) {
		this.totalPriceOfCart = totalPriceOfCart;
	}

	
	
	
	

}
