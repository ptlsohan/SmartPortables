
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

public class CreateOrder extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();

    String productname = request.getParameter("name");//productID
     String image = request.getParameter("image");
     String maker = request.getParameter("maker");
     double price = Double.parseDouble(request.getParameter("price"));
     String productId= request.getParameter("id");

  String TOMCAT_HOME = System.getProperty("catalina.home");
  String username = session.getAttribute("username").toString();
  String userType = session.getAttribute("usertype").toString();
  double orderPrice=Double.parseDouble(request.getParameter("totalamount"));
  String Address = request.getParameter("Address").toString();
  String Creditcard= request.getParameter("CCard").toString();
  int orderId=0;
  HashMap<Integer, ArrayList<OrderPayment>> orderpayments = new HashMap<Integer, ArrayList<OrderPayment>>();
try{
    FileInputStream fileinputstream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\OrderDetails.txt"));
    ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    Object obj = ois.readObject();
    orderpayments = (HashMap)obj;
    ois.close();
    fileinputstream.close();
}catch (IOException e){
  System.out.println("IO Exception:"+e.getMessage());
}catch (ClassNotFoundException io){
  System.out.println("Class Not Found Exception:"+io.getMessage());
}
orderId= orderpayments.size()+1;
while(orderpayments.containsKey(orderId))
orderId++;
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
