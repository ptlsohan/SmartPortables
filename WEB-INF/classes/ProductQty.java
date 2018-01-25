public class ProductQty{
private String productname;
private String rebate;
private int Qty;
private String sale;

public ProductQty(String productname, String rebate,int Qty, String sale)

{
this.productname=productname;
this.rebate=rebate;
this.Qty=Qty;
this.sale=sale;

}
public ProductQty(){}
public String getProductName() {
return productname;
}
public void setProductName(String productname) {
this.productname = productname;
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
this.sale=sale;
}
public int getQty() {
return Qty;
}
public void setQty(int Qty) {
this.Qty = Qty;
}

}
