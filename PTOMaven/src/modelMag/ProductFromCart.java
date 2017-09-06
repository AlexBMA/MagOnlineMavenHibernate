package modelMag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_from_cart")
public class ProductFromCart  {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	
	@Column(name="idProduct")
	private int idProdus;
	@Column(name="quantity")
	private int cantitateComandata;
	
	public ProductFromCart()
	{
		
	}
	
	
	/*
	public ProductFromCart(int id, int idProdus) {
		super();
		this.id = id;
		this.idProdus = idProdus;
	}
	*/


	public ProductFromCart(int idProdus, int cantitateComandata) {
		super();
		this.idProdus = idProdus;
		this.cantitateComandata = cantitateComandata;
	}


	public ProductFromCart(int id, int idProdus, int cantitateComandata) {
		super();
		this.id = id;
		this.idProdus = idProdus;
		this.cantitateComandata = cantitateComandata;
	}


	/*
	public double calculeazaPretPentruProdosuDinCos() {
		return produs.getPrice() * cantitateComandata;
	}
	*/
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


	public int getIdProdus() {
		return idProdus;
	}


	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	
	
}
