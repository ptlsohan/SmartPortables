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

public class SalesReport extends HttpServlet{
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Helper helper = new Helper(request, pw);
            HttpSession session= request.getSession();
            ArrayList<SoldQty>li=new ArrayList<>();
		li=MySQLDataStore.getSoldQty();
        helper.printHtml("site_header.html");
        pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");

		pw.print("<h4> All Products Sold </h4>");
		pw.print("<table>");
        pw.print("<tr><th> Product Name </th><th> Product Price </th><th>No. of Product sold </th><th> Total Price </th></tr>");
		for (SoldQty disp: li) {

                //disp=entry
			pw.print("<tr><td>"+disp.getProductName()+"</td><td> "+disp.getOrderPrice()+"</td><td> "+disp.getQty()+"</td><td> "+disp.getTotalSale()+"</td></tr> ");
			//pw.print(disp.getOrderdate()+": "+disp.getOrderPrice()+"\n");

		}
		pw.print("</table>");

		 pw.print("</div></div></div>");

         helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");

    }
}
