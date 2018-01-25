import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class Cart extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();
     String id ="a";
    if(request.getParameter("id")!=null)
      id = request.getParameter("id");
   //helper.setcarouselId(id);
   if(helper.isLogin()){
   //char caid ='a';
   char caid = id.charAt(0);
   if(caid != 'a')
   session.setAttribute("cid",id);
 }

    if(request.getParameter("deleteitem")!=null){
       int itemno = Integer.parseInt(request.getParameter("deleteitem"))-1;
      helper.remOrder(itemno);

    }
    displayCart(request,response,pw,helper);
  }
  protected void displayCart(HttpServletRequest request,HttpServletResponse response,
  PrintWriter pw, Helper helper) throws ServletException, IOException{
    response.setContentType("text/html");
  //  PrintWriter pw = response.getWriter();
    //Helper helper = new Helper(request, pw);
    helper.printHtml("site_header.html");
    HttpSession session= request.getSession();
  //  String id = helper.getcarouselId();

    String id="a";
    if(session.getAttribute("cid")!=null)
    id =session.getAttribute("cid").toString();
    HashMap<String, String> acc =new HashMap<String, String>();
    HashMap<String, Accessory> acchandler=new HashMap<String, Accessory>();
    ArrayList<String> hm= new ArrayList<String>();


for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
  if (entry.getValue().getId().equals(id)){
    acc.putAll(entry.getValue().getAccessories());

  }

}

		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Cart("+helper.CartCount()+")</a>");
		pw.print("</h2><div class='entry'>");
		if(helper.CartCount()>0){
		pw.print("<table  class='gridtable'>");
		int ind = 1;
		double total = 0;
		for (OrderItem oi : helper.getCustomerOrders()) {
			pw.print("<tr>");
			pw.print("<td>"+ind+".</td><td>"+oi.getProductname()+"</td><td>: "+oi.getPrice()
              +"</td><td><form action='Cart'><input value='Remove' type='submit' class='button'><input type='hidden' name='deleteitem' value='"+ind+"'></form></td>");
			pw.print("</tr>");

			pw.print("<tr>");



			total = total +oi.getPrice();
			ind++;
		}
		pw.print("<tr><th></th><th>Total</th><th>"+total+"</th>");

		// pw.print("<tr><td></td><td></td><td><a href='CheckOut' class='btnbuy'>Check Out</a></td>");
		pw.print("<tr><td></td><td></td>");
		pw.print("</table>");
    pw.print("<form method='get' action='Checkout'>" +
				"<input type='hidden' name='totalamount' value='"+total+"'>"+
				"<input type='hidden' name='type' value=''>"+
				//"<input type='hidden' name='maker' value='"+CategoryName+"'>"+
				//"<input type='hidden' name='access' value=''>"+
		"<input type='submit' class='button' value='Check Out' href='#'></input></form>");
    char caid = id.charAt(0);
    if(caid != 'a'){


    int i = 1;
    int size = acc.size();
    //pw.print("No of match:"+size);
    for (Map.Entry<String, String> entrysm : acc.entrySet()) {
      String access = entrysm.getValue();

  for(Map.Entry<String, Accessory> entryac: SAXParserXMLDataStore.accessories.entrySet()){
  if (entryac.getValue().getName().equals(access)){
  acchandler.put(entryac.getKey(),entryac.getValue());

  }

  }
  }

  if(acchandler.size()>0){
    pw.print("<h3>Accessories:</h3><br>");
    pw.print("<div id='myCarousel' class='carousel slide' data-ride='carousel'><!-- Indicators -->"+
    "<ol class='carousel-indicators'><li data-target='#myCarousel' data-slide-to='0' class='active'></li>"+
    "<li data-target='#myCarousel' data-slide-to='1'></li>"+
    "<li data-target='#myCarousel' data-slide-to='2'></li>"+
    "</ol><div class='carousel-inner'><div class='item active' style='height:250px; width:280px;margin-left:100px;'>");
     int j=1;
     //pw.print("<table id='bestseller'>");
    for (Map.Entry<String, Accessory> entryacch : acchandler.entrySet()) {
      Accessory accessory = entryacch.getValue();
          // pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
           //pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong>");

    if(j==1){
      pw.print("");// first row
      pw.print("<div>");

      pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+accessory.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
      pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" +
       "<h3>" + accessory.getName() + "</h3>");
      pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
     pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong><ul style='margin-left: 0px;'>"+
     "<input type='hidden' name='name' value='"
          + accessory.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
          + "<input type='hidden' name='maker' value='" + accessory.getRetailer() + "'>"
          + "<input type='hidden' name='image' value='" + accessory.getImage() + "'>"
          + "<input type='hidden' name='id' value='" + accessory.getId() + "'>"
          + "<input type='hidden' name='price' value='" + accessory.getPrice() + "'>"
          + "<input type='submit' value='Add to Cart' ></form></li>");
      pw.print("</div></div>");
    }
    if(j!=1){
    pw.print("<div class='item' style='height:250px;width:280px; margin-left:100px'>");
    pw.print("");// first row
  pw.print("<div>");

  pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+accessory.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
  pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" +
   "<h3>" + accessory.getName() + "</h3>");
  pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
  pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong><ul style='margin-left: 0px;'>"+
  "<input type='hidden' name='name' value='"
      + accessory.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
      + "<input type='hidden' name='maker' value='" + accessory.getRetailer() + "'>"
      + "<input type='hidden' name='image' value='" + accessory.getImage() + "'>"
      + "<input type='hidden' name='id' value='" + accessory.getId() + "'>"
      + "<input type='hidden' name='price' value='" + accessory.getPrice() + "'>"
      + "<input type='submit' value='Add to Cart' ></form></li>");
  pw.print("</div></div>");
  }
    j++;
  }
  //pw.print("</table>");
  pw.print("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>"+
    "<span class='glyphicon glyphicon-chevron-left'></span><span class='sr-only'>Previous</span>"+
    "</a><a class='right carousel-control' href='#myCarousel' data-slide='next'>"+
    "<span class='glyphicon glyphicon-chevron-right'></span><span class='sr-only'>Next</span>"+
    "</a></div></div></div>");
  }}
  }else{
    pw.print("<h4 style='color:red'>Your Cart is empty</h4>");
  }


		pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
  }

  }
