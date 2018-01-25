import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class Checkout extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session=request.getSession();
    helper.printHtml("site_header.html");
    pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Cart("+helper.CartCount()+")</a>");
		pw.print("</h2><div class='entry'>");
		//if(helper.CartCount()>0){
		pw.print("<table id='bestseller'>");
		int i = 1;
		double total = 0;
		for (OrderItem oi : helper.getCustomerOrders()) {
			pw.print("<tr>");
			pw.print("<td>"+i+".</td><td>"+oi.getProductname()+"</td><td>: "+oi.getPrice());
			pw.print("</tr>");

			pw.print("<tr>");



			total = total +oi.getPrice();
			i++;
		}
		pw.print("<tr><th></th><th>Total</th><th>"+total+"</th>");
    pw.print("<tr><td></td><td></td>");
    pw.print("</table>");
    pw.print("<form method='get' action='StorePayment'>" +
        "<input type='hidden' name='totalamount' value='"+total+"'>"+
        "<input type='hidden' name='type' value=''>");
        if(session.getAttribute("usertype").toString().equals("Salesman")){
          pw.print("<br>Username.:<input type='text' name='uname'>");
        }
pw.print( "<br>Credit card no.:<input type='text' name='CCard'>"+
        "<br>Billing Address:<input type='textfield' name='Address'>"+
        //"<input type='hidden' name='access' value=''>"+
    "<br><input type='submit' class='button' value='Make Payment' href='#'></input></form>");


    pw.print("</div></div></div>");
    helper.printHtml("site_sidebar.html");
    helper.printHtml("site_footer.html");
    }

    }
