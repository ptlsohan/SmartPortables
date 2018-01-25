
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

public class StoreReviews extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();
    //String utype=session.getAttribute("username").toString();

  String TOMCAT_HOME = System.getProperty("catalina.home");
  String username = session.getAttribute("username").toString();
  String productname = request.getParameter("productname");
  String manufacturer = request.getParameter("manufacturer");
  String type = request.getParameter("type");
  int UAge = Integer.parseInt(request.getParameter("UAge"));
  String userOccupation = request.getParameter("userOccupation");
  double orderprice=Double.parseDouble(request.getParameter("price"));
  String RCity = request.getParameter("RCity");
  int RZip = Integer.parseInt(request.getParameter("RZip"));
  String RState = request.getParameter("RState");
  String Gender = request.getParameter("gender");
  int rating = Integer.parseInt(request.getParameter("rating"));
  String rvw = request.getParameter("review");
 // String Creditcard= request.getParameter("CCard").toString();
 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  LocalDate localDate = LocalDate.now();
  String orderdate = dtf.format(localDate).toString();

 HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
try
{reviews=MongoDBDataStoreUtilities.selectReview();
}
catch(Exception e)
{ }
if(!reviews.containsKey(productname)){
ArrayList<Review> arr = new ArrayList<Review>();
reviews.put(productname, arr);
}
ArrayList<Review> listReview = reviews.get(productname);
Review review = new Review(username,productname,manufacturer,orderprice,type,UAge,userOccupation,RCity,RZip,RState,Gender,rating,orderdate,rvw);
listReview.add(review);


   try
{
MongoDBDataStoreUtilities.insertReview(username,productname,manufacturer,orderprice,type,UAge,userOccupation,RCity,RZip,RState,Gender,rating,orderdate,rvw);
}
catch(Exception e)
{ }


  helper.printHtml("site_header.html");
  pw.print("<div id='post'><section id='content'><article>");
  pw.print("<h4 style='color:green'><strong>Review Submitted!!</strong></h4><br>");
  pw.print("</article></section></div>");
  helper.printHtml("site_sidebar.html");
  helper.printHtml("site_footer.html");
}
}
