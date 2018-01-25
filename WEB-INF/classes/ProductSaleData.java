
public class ProductSaleData{
private String productname;
private double totalsale;

public ProductSaleData(String productname, double totalsale)

{
this.productname=productname;
this.totalsale=totalsale;

}
public ProductSaleData(){
}
public String getProductName() {
return productname;
}
public void setProductName(String productname) {
this.productname = productname;
}

public double getTotalSale() {
return totalsale;
}
public void setTotalSale(double totalsale) {
this.totalsale=totalsale;
}

}
