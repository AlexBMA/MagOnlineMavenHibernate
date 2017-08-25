package constantPack;

public class AppTables {

	private static final String DATABASE="test_basic_schema";
	
	public abstract class ProductEntry{
		
		public static final String TABLE_NAME = "Product";
		
			
		public static final String COLUMN_ID = "id";
		public static final String COLUMN_NUMBER_OF_ITMES = "numberOfItems";
		public static final String COLUMN_PRICE = "price";
		public static final String COLUMN_PRODUCT_TYPE_ID = "productTypeId";
		public static final String COLUMN_LINK_IMG  ="link_img";
		public static final String COLUMN_NAME ="name";
	}
	
	public abstract class ProductTypeEntry{
		
		public static final String TABLE_NAME ="ProductType";
		
		public static final String COLUMN_ID ="id";
		public static final String COLUMN_TYPE_NAME="productTypeName";
		
		//id
		//product_type_name
	}
}
