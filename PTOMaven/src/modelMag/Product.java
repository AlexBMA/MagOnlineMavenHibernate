package modelMag;

import javax.persistence.Column;
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
	
	public static class Builder{
		private int id;
		private int numberOfItems;
		private double price;
		private int priceTypeId;
		private String linkImg;
		private String name;
		
		
		public Builder id(int val){id = val; return this; }
		public Builder numberOfItems(int val){numberOfItems = val; return this;}
		public Builder price(double val){price = val; return this;}
		public Builder name(String val){name=val;return this;}
		public Builder priceTypeId(int val){priceTypeId = val; return this;}
		public Builder linkImg(String val){linkImg = val; return this;} 
		
		public Product build()
		{
			return new Product(this);
		}
		
	}
	
	private Product(Builder builder){
		this.id = builder.id;
		this.numberOfItems = builder.numberOfItems;
		this.price = builder.price;
		this.name = builder.name;
		this.linkImg = builder.linkImg;
		this.productTypeId = builder.priceTypeId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((linkImg == null) ? 0 : linkImg.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfItems;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productTypeId;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (linkImg == null) {
			if (other.linkImg != null)
				return false;
		} else if (!linkImg.equals(other.linkImg))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfItems != other.numberOfItems)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productTypeId != other.productTypeId)
			return false;
		return true;
	}

	
	
}
