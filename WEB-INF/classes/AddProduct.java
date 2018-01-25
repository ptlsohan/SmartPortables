import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class AddProduct extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Helper helper = new Helper(request,pw);



		helper.printHtml("site_header.html");
		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table class=table>");
		pw.print("");// first row
			//pw.print("<div id='shop_item'>");
			//pw.print("<h3>" + name + "</h3>");

            pw.print("<strong>Product Details:</strong><br>");
			pw.print("<ul style='margin-left: 0px;'>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='UpdateHashmap'>" + "<tr><td>Product name</td><td><input type='text' name='name' value=''></td></tr>" + "<tr><td>Product type</td><td><input type='text' name='type' value=''></td></tr>"
					+ "<tr><td>Manufacturer</td><td><input type='text' name='maker' value=''></td></tr>"
          + "<tr><td>Product price</td><td><input type='text' name='price' value=''></td></tr>"
          + "<tr><td>Quantity</td><td><input type='text' name='qty' value=''></td></tr>"
          + "<tr><td>Product id</td><td><input type='text' name='id' value=''></td></tr>"
          + "<tr><td>Rebate</td><td><input type='text' name='rebate' value=''></td></tr>"
          + "<tr><td>Sale</td><td><input type='text' name='sale' value=''></td></tr>"
          + "<tr><td>Product image</td><td><input type='text' name='image' value=''></td></tr>"
          +"<input type='hidden' name='add' value='yes'>"
					+ "<tr><td><input type='submit' value='Add' ></td></tr></form></li>");

            pw.print("</ul>");
            pw.print("");
        pw.print("</table>");


        pw.print("</div></section></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
    }
}
