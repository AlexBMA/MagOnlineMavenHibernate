package modelMag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_from_cart")
public class ProductFromCart  {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@OneToOne
	private Product produs;
	@Column(name="quantity")
	private int cantitateComandata;
	
	public ProductFromCart()
	{
		
	}

	public ProductFromCart(Product p, int cantitate) {
		this.produs=p;
		this.cantitateComandata=cantitate;
	}

	public Product getProdus() {
		return produs;
	}

	public void setProdus(Product produs) {
		this.produs = produs;
	}

	public double calculeazaPretPentruProdosuDinCos() {
		return produs.getPrice() * cantitateComandata;
	}

	public int getCantitateComandata() {
		return cantitateComandata;
	}

	public void setCantitateComandata(int cantitateComandata) {
		this.cantitateComandata = cantitateComandata;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductFromCart [id=" + id + ", produs=" + produs + ", cantitateComandata=" + cantitateComandata + "]";
	}

	
}
