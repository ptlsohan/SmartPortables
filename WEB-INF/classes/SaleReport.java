import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.HttpSession;

public class SaleReport extends HttpServlet{

   // PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
         response.setContentType("text/html");
	     PrintWriter pw = response.getWriter();
	     Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");
		 pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");

		pw.print("<table>");
		pw.print("<tr><td>Generate list of total no of product Sold</td><td><button type='button'><a href='SalesReport'>Generate!</a></button>");
		pw.print("<tr><td>Generate bar chart for total no of product Sale</td><td><button type='button'><a href='Chart'>Generate!</a></button>");
		pw.print("<tr><td>Generate Daily Sale transaction</td><td><button type='button'><a href='DailySale'>Generate!</a></button>");
		pw.print("</table>");
	     pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}
}
