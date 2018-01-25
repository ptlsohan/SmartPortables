import java.util.HashMap;

public class Phone {
    private String id;
	private String name;
	private double price;
	private String image;
	private String retailer;
	private String condition;
	private double discount;
	private int quantity;
	private String rebate;
	private String sale;
	private HashMap<String, String> accessories;

	public Phone(String id, String name, double price, String image, String retailer,double discount, HashMap<String, String> accessories, int quantity, String rebate, String sale)

	{
	    this.id=id;
		this.name=name;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		this.condition=condition;
		this.discount = discount;
		this.accessories =accessories;
		this.quantity=quantity;
		this.rebate=rebate;
		this.sale=sale;
	}

	public Phone(){
		accessories = new HashMap<String, String>();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}


	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public void setAccessories(HashMap<String, String> accessories){
		this.accessories=accessories;
	}
	public HashMap<String, String> getAccessories(){
		return accessories;
	}
	public int getQty() {
		return quantity;
	}
	public void setQty(int quantity) {
		this.quantity=quantity;
	}
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate=rebate;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
}
