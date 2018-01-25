
public class OrderItem{
  private String productname;
  private double price ;
  private String retailer;
  private String image;
  private String productId;

  public OrderItem(String productname,String productId, String retailer, double price, String image){
    this.productname = productname;
    this.productId=productId;
    this.retailer = retailer;
    this.price=price;
    this.image = image;
  }
  public OrderItem(){

  }
  public void setProductname(String productname){
    this.productname = productname;
  }
  public String getProductname(){
    return productname;
  }
  public void setProductId(String productId){
    this.productId = productId;
  }
  public String getProductId(){
    return productId;
  }
  public void setRetailer(String retailer){
    this.retailer = retailer;
  }
  public String getRetailer(){
    return retailer;
  }
  public void setPrice(double price){
    this.price = price;
  }
  public double getPrice(){
    return price;
  }
  public void setImage(String image){
    this.image=image;
  }
  public String getImage(){
    return image;
  }
}
