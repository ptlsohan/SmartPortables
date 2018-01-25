
import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;

public class StorePayment extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();
    //String utype=session.getAttribute("username").toString();

  String TOMCAT_HOME = System.getProperty("catalina.home");
  String username = session.getAttribute("username").toString();
  String userType = session.getAttribute("usertype").toString();
  double orderPrice=Double.parseDouble(request.getParameter("totalamount"));
  String Address = request.getParameter("Address").toString();
  String Creditcard= request.getParameter("CCard").toString();
  int orderId=0;
  if(userType.equals("Salesman")){
    username=request.getParameter("uname").toString();
  }
  HashMap<Integer, ArrayList<OrderPayment>> orderpayments = new HashMap<Integer, ArrayList<OrderPayment>>();
try{
   /* FileInputStream fileinputstream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\OrderDetails.txt"));
    ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    Object obj = ois.readObject();
    orderpayments = (HashMap)obj;
    ois.close();
    fileinputstream.close();*/
    orderpayments= MySQLDataStore.selectOrder();
}catch (Exception e){
  System.out.println("IO Exception:"+e.getMessage());
}
orderId= orderpayments.size()+1;
while(orderpayments.containsKey(orderId)){
orderId++;}
  if(!orderpayments.containsKey(orderId)){
    ArrayList<OrderPayment> arr= new ArrayList<OrderPayment>();
    orderpayments.put(orderId, arr);
  }
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  LocalDate localDate = LocalDate.now();
  String orderdate = dtf.format(localDate).toString();
  String dt = dtf.format(localDate).toString();  // Start date
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
Calendar c = Calendar.getInstance();
try{
c.setTime(sdf.parse(dt));
}
catch (Exception io){
  System.out.println("Class Not Found Exception:"+io.getMessage());
}

c.add(Calendar.DATE, 14);  // number of days to add
dt = sdf.format(c.getTime());

  System.out.println("Order date:"+dt);

  ArrayList<OrderPayment> orderlist = orderpayments.get(orderId);
  OrderPayment ord= new OrderPayment(orderId, username, userType, orderPrice, Address, Creditcard,orderdate, dt);
  orderlist.add(ord);
    try{
  /*FileOutputStream fos = new FileOutputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\OrderDetails.txt"));
  ObjectOutputStream oos = new ObjectOutputStream(fos);
  oos.writeObject(orderpayments);
  oos.flush();
  oos.close();
  fos.close();*/
  MySQLDataStore.insertOrder(orderId, username, userType, orderPrice, Address, Creditcard,orderdate, dt);
   for (OrderItem oi : helper.getCustomerOrders()) {
    MySQLDataStore.setProductSold(orderId,oi.getProductname(),orderdate,oi.getPrice());
   }
}catch (Exception e){}

  ArrayList<OrderItem> al1=helper.getCustomerOrders();
  al1.removeAll(al1);
  helper.printHtml("site_header.html");
  pw.print("<div id='post'><section id='content'><article>");
  pw.print("<h4 style='color:green'><strong>Your order was successfully placed!!</strong></h4><br>");
  pw.print("<h4>Order No:"+orderId+"</h4><br><h4>Expected Delivery Date:"+dt+"</h4>");
  pw.print("</article></section></div>");
  helper.printHtml("site_sidebar.html");
  helper.printHtml("site_footer.html");
}
}
