

public class SoldQty{
private int orderId;
private String productname;
private String orderdate;
private double orderprice;
private int Qty;
private double totalsale;

public SoldQty(int orderId, String productname, String orderdate, double orderprice, int Qty)

{
  this.orderId=orderId;
this.productname=productname;
this.orderdate=orderdate;
this.orderprice=orderprice;
this.Qty=Qty;

}
public SoldQty(String productname, double orderprice, int Qty,double totalsale)

{

this.productname=productname;
this.orderprice=orderprice;
this.Qty=Qty;
this.totalsale=totalsale;
}
public SoldQty(String orderdate, double orderprice)

{

this.orderdate=orderdate;
this.orderprice=orderprice;

}
public SoldQty(){

}

public int getOrderId() {
return orderId;
}
public void setOrderId(int orderId) {
this.orderId = orderId;
}
public String getProductName() {
return productname;
}
public void setProductName(String productname) {
this.productname = productname;
}

public double getOrderPrice() {
return orderprice;
}
public void setOrderPrice(double orderprice) {
this.orderprice = orderprice;
}
public int getQty() {
return Qty;
}
public void setQty(int Qty) {
this.Qty = Qty;
}

public String getOrderdate() {
return orderdate;
}
public void setOrderDate(String orderdate) {
this.orderdate = orderdate;
}
public void setTotalSale(double totalsale) {
    totalsale=Qty*orderprice;
this.totalsale=totalsale;
}
public double getTotalSale(){
   // totalsale=Qty*orderprice;
    return totalsale;
}



}
