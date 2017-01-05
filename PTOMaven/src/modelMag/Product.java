package modelMag;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product  {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name="number_of_items")
	private int numberOfItems;
	@Column(name="price")
	private double price;
	@Column(name="product_type_id")
	private int productTypeId;
	@Column(name="link_img")
	private String linkImg;
	@Column(name="name")
	private String name;
	

	public Product() {
		name = "";
		numberOfItems = -1;
		price = -1;
		productTypeId = -1;
		linkImg="";

	}

	public Product( String name, int numberOfItems, double price,int produtcTypeId,String linkImg) {
		this.name = name;
		this.numberOfItems = numberOfItems;
		this.price = price;
	    this.productTypeId = produtcTypeId;
	    this.linkImg = linkImg;

	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItmes(int quantity) {
		this.numberOfItems = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}




	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
