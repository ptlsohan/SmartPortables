import java.util.HashMap;

public class Accessory {
    private String id;
	private String name;
  private String type;
	private double price;
	private String image;
	private String retailer;
	private String condition;
	private double discount;
	private int quantity;
	private String rebate;
	private String sale;
	//private HashMap<String, Accessory> accessories;

	public Accessory(String id, String name,String type, double price, String image, String retailer, int quantity, String rebate, String sale)

	{
	    this.id=id;
		this.name=name;
    this.type=type;
		this.price=price;
		this.image=image;
		this.retailer = retailer;
		//this.condition=condition;
		//this.discount = discount;
		this.quantity=quantity;
		this.rebate=rebate;
		this.sale=sale;
		//this.accessories =accessories;
	}

	public Accessory(){
		//accessories = new HashMap<String, Accessory>();
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
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
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
	//public void setAccessories(HashMap<String, Accessory> accessories){
		//this.accessories=accessories;
	//}
	//public HashMap<String, Accessory> getAccesories(){
		//return accesories;
	//}
}
