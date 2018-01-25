import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class WriteReview extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session=request.getSession();
    if(!helper.isLogin()){
        response.sendRedirect("Login");
			return;
    }
    String uname = session.getAttribute("username").toString();
    helper.printHtml("site_header.html");
    pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		//pw.print("<a style='font-size: 24px;'>Cart("+helper.CartCount()+")</a>");
		pw.print("</h2><div class='entry'>");
		//if(helper.CartCount()>0){
		 pw.print("<form method='get' action='StoreReviews'>");
		pw.print("<table id='bestseller'>");
		//int i = 1;
		//double total = 0;
		//for (OrderItem oi : helper.getCustomerOrders()) {
		pw.print("<tr><th></th><th>Write Review</th><th></th></tr>");
			pw.print("<tr>");
			pw.print("<td>Product name</td><td>"+request.getParameter("name")+"</td></tr><tr><td>Price</td><td>"+request.getParameter("price"));
			pw.print("</td></tr>");
            pw.print("<td>Manufacturer</td><td>"+request.getParameter("maker")+"</td></tr><tr><td>Type</td><td>"+request.getParameter("type"));
			pw.print("</td></tr>");
			//pw.print("<tr>");


		//}

    //pw.print("<tr><td></td><td></td>");


      //  "<input type='hidden' name='totalamount' value='"+total+"'>"+
        //"<input type='hidden' name='type' value=''>");
        //if(session.getAttribute("usertype").toString().equals("Salesman")){
          //pw.print("<br>Username.:<input type='text' name='uname'>");
        //}

pw.print("<input type='hidden' name='price' value='" +request.getParameter("price")+ "'><input type='hidden' name='productname' value='" +request.getParameter("name")+ "'><input type='hidden' name='type' value='Laptop'><input type='hidden' name='manufacturer' value='" +request.getParameter("maker")+ "'>");
pw.print("<tr><td>User Age:</td><td><input type='number' name='UAge' min='1' max='100'></td></tr><tr><td>Occupation :</td><td><input type='text' name='userOccupation'></td></tr><tr><td>Retailer City:</td><td><input type='text' name='RCity'></td></tr>");
pw.print("<tr><td>Retailer Zipcode:</td><td><input type='number' name='RZip' min='10000' max='99999'></td></tr>"+
        "<tr><td>Retailer State:</td><td><input type='text' name='RState'></td></tr>");
pw.print("<tr><td>Gender: </td><td><input type='radio' name='gender' value='male'> Male  <input type='radio' name='gender' value='female'> Female  <input type='radio' name='gender' value='other'> Other</td></tr>"+
        //"<input type='hidden' name='access' value=''>"+
    "<tr><td>Review Rating:</td><td><select name='rating'><option value='0'>0</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select></td></tr>"+
    "<tr><td>Review:</td><td><textarea rows='4' cols='50' name='review'></textarea></td></tr><tr><td><input type='submit' value='Submit Review'></input></td></tr></form>");
pw.print("</table>");

    pw.print("</div></div></div>");
    helper.printHtml("site_sidebar.html");
    helper.printHtml("site_footer.html");
    }

    }
