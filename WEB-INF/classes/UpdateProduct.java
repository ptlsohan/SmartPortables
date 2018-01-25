import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class UpdateProduct extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Helper helper = new Helper(request,pw);
        String name=request.getParameter("name");
        String maker=request.getParameter("maker");
        String type=request.getParameter("type");
        double price=Double.parseDouble(request.getParameter("price"));
        String id=request.getParameter("id");
        int qty=Integer.parseInt(request.getParameter("qty"));


		helper.printHtml("site_header.html");
		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table class=table>");
		pw.print("");// first row
			//pw.print("<div id='shop_item'>");
			pw.print("<h3>" + name + "</h3>");



			pw.print("<li id='item' style='list-style-type: none; width: auto; height: auto;'><img src= 'images\\"+request.getParameter("image")
                    + "' alt='' style='width: 550px; height: 400px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
            pw.print("<strong>Product Details:</strong><br>");
			pw.print("<ul style='margin-left: 0px;'>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='UpdateHashmap'>" + "<tr><td>Product name</td><td><input type='text' name='name' value='"
					+name+ "'></td></tr>" + "<tr><td>Product type</td><td><input type='text' name='type' value='" +type+ "'></td></tr>"
					+ "<tr><td>Manufacturer</td><td><input type='text' name='maker' value='" +maker+ "'></td></tr>"
          + "<tr><td>Product Price</td><td><input type='text' name='price' value='" +price+ "'></td></tr>"
          + "<tr><td>Quantity</td><td><input type='text' name='qty' value='" +qty+ "'></td></tr>"
          + "<input type='hidden' name='id' value='" +id+ "'>"
          + "<input type='hidden' name='rebate' value='" +request.getParameter("rebate")+ "'>"
          + "<input type='hidden' name='sale' value='" +request.getParameter("sale")+ "'>"
          + "<input type='hidden' name='image' value='" +request.getParameter("image")+ "'>"
          +"<input type='hidden' name='add' value='no'>"
					+ "<tr><td><input type='submit' value='Update' ></td></tr></form></li>");

            pw.print("</ul>");
            pw.print("");
        pw.print("</table>");


        pw.print("</div></section></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
    }
}
