

public class OrderPayment{
private int orderId;
private String username;
private String userType;
private double orderprice;
private String Address;
private String Creditcard;
private String orderDate;
private String deliveryDate;


public OrderPayment(int orderId, String username, String userType, double orderprice, String Address, String Creditcard, String orderDate, String deliveryDate)

{
  this.orderId=orderId;
this.username=username;
this.userType=userType;
this.orderprice=orderprice;
this.Address=Address;
this.Creditcard = Creditcard;
this.orderDate=orderDate;
this.deliveryDate=deliveryDate;
}

public OrderPayment(){

}

public int getOrderId() {
return orderId;
}
public void setOrderId(int orderId) {
this.orderId = orderId;
}
public String getUserName() {
return username;
}
public void setUserName(String username) {
this.username = username;
}
public String getUserType() {
return userType;
}
public void setUserType(String userType) {
this.userType = userType;
}
public double getOrderPrice() {
return orderprice;
}
public void setOrderPrice(double orderprice) {
this.orderprice = orderprice;
}
public String getAddress() {
return Address;
}
public void setAddress(String Address) {
this.Address = Address;
}
public String getCreditCard() {
return Creditcard;
}
public void setCreditCard(String Creditcard) {
this.Creditcard = Creditcard;
}
public String getOrderDate() {
return orderDate;
}
public void setOrderDate(String orderDate) {
this.orderDate = orderDate;
}
public String getDeliveryDate() {
return deliveryDate;
}
public void setDeliveryDate(String deliveryDate) {
this.deliveryDate = deliveryDate;
}



}
