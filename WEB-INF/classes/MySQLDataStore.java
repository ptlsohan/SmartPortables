
import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.util.*;

public class MySQLDataStore
{
static Connection conn = null;
public static void getConnection()
{
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
}
catch(Exception e)
{}
}
public static void insertUser(String username,String password,String
usertype){
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String insertIntoCustomerRegisterQuery = "INSERT INTO Registration(username,password,usertype) "
+ "VALUES (?,?,?);";
PreparedStatement pst = conn.prepareStatement(insertIntoCustomerRegisterQuery);
pst.setString(1,username);
pst.setString(2,password);
pst.setString(3,usertype);
pst.execute();
}
catch(Exception e){}
}
public static HashMap<String, User> selectUser()
{
HashMap<String, User> allUser=new HashMap<String, User>();
try{ getConnection();
String selectOrderQuery ="select * from Registration";
PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
ResultSet rs = pst.executeQuery();
User us=new User();
while(rs.next())
{if(!allUser.containsKey(rs.getString("username")))
{
    String uname= rs.getString("username");
    String pwd=rs.getString("password");
    String utype=rs.getString("usertype");
    User newUser = new User(uname,pwd,utype);
    allUser.put(rs.getString("username"), newUser);
}

}
conn.close();
}catch(Exception ex){}
return allUser;
}

public static HashMap<String, Product> selectProduct()
{
HashMap<String, Product> allProduct=new HashMap<String, Product>();
try{ getConnection();
String selectOrderQuery ="select * from Product";
PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
ResultSet rs = pst.executeQuery();
Product us=new Product();
while(rs.next())
{if(!allProduct.containsKey(rs.getString("Id")))
{
    //String uname= rs.getString("username");
    //String pwd=rs.getString("password");
    //String utype=rs.getString("usertype");
    String id= rs.getString("Id");
	 String name= rs.getString("Name");
 String type= rs.getString("Type");
	 double price= rs.getDouble("Price");
	 String image= rs.getString("Image");
	 String retailer= rs.getString("Retailer");
	 //String condition;
	 //double discount;
	 int quantity= rs.getInt("Qty");
	 String rebate= rs.getString("Rebate");
	 String sale= rs.getString("sale");
    Product newProduct = new Product(id,name,type,price,image,retailer,quantity,rebate,sale);
    allProduct.put(id, newProduct);
}

}
conn.close();
}catch(Exception ex){}
return allProduct;
}

public static void insertOrder(int orderId, String username, String userType, double orderprice, String Address, String Creditcard, String orderDate, String deliveryDate){
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String insertIntocustorderQuery = "INSERT INTO CustomerOrders(orderId,userName,usertype,orderPrice,Address,creditCardNo,orderdate, deliverydate) "
+ "VALUES (?,?,?,?,?,?,?,?);";
PreparedStatement pst = conn.prepareStatement(insertIntocustorderQuery);
pst.setInt(1,orderId);
pst.setString(2,username);
pst.setString(3,userType);
pst.setDouble(4,orderprice);
pst.setString(5,Address);
pst.setString(6,Creditcard);
pst.setString(7,orderDate);
pst.setString(8,deliveryDate);
pst.execute();
conn.close();
}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
}

public static HashMap<Integer, ArrayList<OrderPayment>> selectOrder()
{
HashMap<Integer,ArrayList<OrderPayment>> orderPayments=new HashMap<Integer,ArrayList<OrderPayment>>();
try{ getConnection();
String selectOrderQuery ="select * from customerorders";
PreparedStatement pst = conn.prepareStatement(selectOrderQuery);
ResultSet rs = pst.executeQuery();
ArrayList<OrderPayment> orderList=new ArrayList<OrderPayment>();
while(rs.next())
{if(!orderPayments.containsKey(rs.getInt("orderId")))
{ArrayList<OrderPayment> arr = new ArrayList<OrderPayment>();
orderPayments.put(rs.getInt("orderId"), arr);}
ArrayList<OrderPayment> listOrderPayment =orderPayments.get(rs.getInt("OrderId"));
OrderPayment order= new
OrderPayment(rs.getInt("orderId"),rs.getString("userName"),rs.getString("usertype"),rs.getDouble("orderprice"),rs.getString("Address"),rs.getString("creditCardNo"),rs.getString("orderdate"),rs.getString("deliverydate"));
listOrderPayment.add(order);
conn.close();
}
}catch(Exception e){}
return orderPayments;}

public static void removeOrder(int orderId)
{

try{ getConnection();
String removeOrderQuery ="DELETE from CustomerOrders WHERE orderId="+orderId+";";
PreparedStatement pst = conn.prepareStatement(removeOrderQuery);
pst.execute();

}catch(Exception e){}
}

public static void insertProduct(String Id, String Name,String Type, double Price, String Image, String Retailer,int Qty, String Rebate, String Sale){
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String insertIntocustorderQuery = "INSERT INTO Product(Id,Name,Type,Price,Image,Retailer,Qty,Rebate,Sale) "
+ "VALUES (?,?,?,?,?,?,?,?,?);";
PreparedStatement pst = conn.prepareStatement(insertIntocustorderQuery);
pst.setString(1,Id);
pst.setString(2,Name);
pst.setString(3,Type);
pst.setDouble(4,Price);
pst.setString(5,Image);
pst.setString(6,Retailer);
pst.setInt(7,Qty);
pst.setString(8,Rebate);
pst.setString(9,Sale);
pst.execute();
conn.close();
}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
}

public static void updateProduct(String Id, String Name,String Type, double Price, String Image, String Retailer,int Qty, String Rebate, String Sale){
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String insertIntocustorderQuery = "UPDATE Product SET Name=?,Type=?,Price=?,Image=?,Retailer=?,Qty=?,Rebate=?,Sale=? WHERE Id=?";
PreparedStatement pst = conn.prepareStatement(insertIntocustorderQuery);

pst.setString(1,Name);
pst.setString(2,Type);
pst.setDouble(3,Price);
pst.setString(4,Image);
pst.setString(5,Retailer);
pst.setInt(6,Qty);
pst.setString(7,Rebate);
pst.setString(8,Sale);
pst.setString(9,Id);
pst.executeUpdate();
conn.close();
}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
}
public static void removeProduct(String id){
//ArrayList<SoldQty> soldlist=new ArrayList<SoldQty>();
try{

Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String selectproduct="DELETE FROM Product WHERE Id='"+id+"'";
PreparedStatement pst = conn.prepareStatement(selectproduct);
pst.execute();
conn.close();

/*while(rs.next())
{
 SoldQty sq= new SoldQty(rs.getString("ProductName"),rs.getDouble("orderprice"),rs.getInt("quant"));
 soldlist.add(sq);
}*/

}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
}

public static void setProductSold(int id, String name, String date, double Price){
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
/*String selectproduct="SELECT * FROM Solditem WHERE ProductName='"+name+"'";
PreparedStatement ps = conn.prepareStatement(selectproduct);
ResultSet rs = ps.executeQuery();
int recordCount =0;
while(rs.next())
{

recordCount++;
}*/
//if(recordCount==0){
String insertIntocustorderQuery = "INSERT INTO Solditem(Id,ProductName,orderdate,orderPrice) "
+ "VALUES (?,?,?,?);";
PreparedStatement pst = conn.prepareStatement(insertIntocustorderQuery);
pst.setInt(1,id);
pst.setString(2,name);
pst.setString(3,date);
pst.setDouble(4,Price);
pst.execute();
conn.close();
//}
/*else{
    String updatevalue="UPDATE Solditem SET SoldQty=SoldQty+1 WHERE ProductName='"+name+"'";
    ps = conn.prepareStatement(updatevalue);
    ResultSet rs = ps.executeQuery();
}*/
}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
}

public static ArrayList<SoldQty> getSoldQty(){
ArrayList<SoldQty> soldlist=new ArrayList<SoldQty>();
try{

Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String selectproduct="SELECT ProductName,orderPrice,count(ProductName) as quant FROM Solditem group by ProductName,orderPrice";
PreparedStatement ps = conn.prepareStatement(selectproduct);
ResultSet rs = ps.executeQuery();

while(rs.next())
{
 double p= rs.getDouble("orderprice");
 int q= rs.getInt("quant");
 double total= (double)q*p;
 SoldQty sq= new SoldQty(rs.getString("ProductName"),rs.getDouble("orderprice"),rs.getInt("quant"),total);
 soldlist.add(sq);
}

}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
return soldlist;
}


public static SoldQty getSoldProd(String name){
ArrayList<SoldQty> soldlist=new ArrayList<SoldQty>();
soldlist=getSoldQty();
for(SoldQty sq: soldlist){

if(sq.getProductName().equals(name)){
        return sq;

}
}
return null;

}


public static void removeitem(int id){
//ArrayList<SoldQty> soldlist=new ArrayList<SoldQty>();
try{

Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String selectproduct="DELETE FROM Solditem WHERE Id="+id;
PreparedStatement pst = conn.prepareStatement(selectproduct);
pst.execute();
conn.close();

/*while(rs.next())
{
 SoldQty sq= new SoldQty(rs.getString("ProductName"),rs.getDouble("orderprice"),rs.getInt("quant"));
 soldlist.add(sq);
}*/

}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}

//return soldlist;
}


public static ArrayList<SoldQty> getSalebydate(){
ArrayList<SoldQty> soldlist=new ArrayList<SoldQty>();
try{

Class.forName("com.mysql.jdbc.Driver").newInstance();
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase?autoReconnect=true&useSSL=false","root","admin");
String selectproduct="SELECT orderdate,sum(orderPrice) as quant FROM Solditem group by orderdate";
PreparedStatement ps = conn.prepareStatement(selectproduct);
ResultSet rs = ps.executeQuery();

while(rs.next())
{
 SoldQty sq= new SoldQty(rs.getString("orderdate"),rs.getDouble("quant"));
 soldlist.add(sq);
}

}
catch(Exception e){
System.out.println("Error"+e.getMessage());
}
return soldlist;
}

}
