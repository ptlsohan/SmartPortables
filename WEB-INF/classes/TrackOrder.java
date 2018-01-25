
import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class TrackOrder extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();

    String TOMCAT_HOME = System.getProperty("catalina.home");
    String username = session.getAttribute("username").toString();
    String usertype = session.getAttribute("usertype").toString();
    double orderPrice;
    String Address ;
    String Creditcard;
    int orderId=0;
    HashMap<Integer, ArrayList<OrderPayment>> trackorder = new HashMap<Integer, ArrayList<OrderPayment>>();

    try{
      /*FileInputStream fileinputstream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\OrderDetails.txt"));
      ObjectInputStream ois = new ObjectInputStream(fileinputstream);
      Object obj = ois.readObject();
      trackorder = (HashMap)obj;
      ois.close();
      fileinputstream.close();*/
      trackorder=MySQLDataStore.selectOrder();
    }catch (Exception e){
      System.out.println("Exception:"+e.getMessage());
    }
    if(request.getParameter("cancelOrder")!=null){
      Integer coid =Integer.parseInt(request.getParameter("cancelOrder"));
      trackorder.remove(coid);
      MySQLDataStore.removeOrder(coid);
      MySQLDataStore.removeitem(coid);
    }
   /* try{
  FileOutputStream fos = new FileOutputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\OrderDetails.txt"));
  ObjectOutputStream oos = new ObjectOutputStream(fos);
  oos.writeObject(trackorder);
  oos.flush();
  oos.close();
  fos.close();
}catch (Exception e){}*/
    ArrayList<OrderPayment> arr= new ArrayList<OrderPayment>();
    ArrayList<OrderPayment> arrtrk= new ArrayList<OrderPayment>();
    if(usertype.equals("Customer")){
    for(Map.Entry<Integer, ArrayList<OrderPayment>> en: trackorder.entrySet()){
      //OrderPayment orp = en.getValue();
      for(OrderPayment trkorder: en.getValue()){
        if(trkorder.getUserName().equals(username)){
          arrtrk.add(trkorder);
        }

      }


    }
  }
  if(usertype.equals("Salesman")){
  for(Map.Entry<Integer, ArrayList<OrderPayment>> en: trackorder.entrySet()){
    //OrderPayment orp = en.getValue();
    for(OrderPayment trkorder: en.getValue()){
      if(trkorder.getUserType().equals(usertype)){
        arrtrk.add(trkorder);
      }

    }


  }
}

    helper.printHtml("site_header.html");
    pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Orders:</a>");
		pw.print("</h2><div class='entry'>");
		//if(helper.CartCount()>0){
		pw.print("<table  class='gridtable'>");
    pw.print("<tr><th></th><th>Date</th>");
    if(usertype.equals("Salesman")){
      pw.print("<th>Username</th>");
    }
    pw.print("<th>Order Number</th><th>Amount</th><th>Exp. Delivery date</th></tr>");
		int ind = 1;
		double total = 0;
		for (OrderPayment op : arrtrk) {
			pw.print("<tr>");
			pw.print("<td>"+ind+".</td><td>"+op.getOrderDate()+".</td>");
      if(usertype.equals("Salesman")){
        pw.print("<th>"+op.getUserName()+"</th>");
      }
      pw.print("<td>Order No.:"+op.getOrderId()+"</td><td>"+op.getOrderPrice()
              +"</td><td>"+op.getDeliveryDate()+".</td><td><form action='TrackOrder'><input value='Cancel Order' type='submit' class='button'><input type='hidden' name='cancelOrder' value='"+op.getOrderId()+"'></form></td>");
			pw.print("</tr>");

			pw.print("<tr>");

			ind++;
		}


		// pw.print("<tr><td></td><td></td><td><a href='CheckOut' class='btnbuy'>Check Out</a></td>");
		pw.print("<tr><td></td><td></td>");
		pw.print("</table>");
    pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
  }
}
