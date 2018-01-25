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

public class DailySale extends HttpServlet{
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

        li=MySQLDataStore.getSalebydate();
		pw.print("<h4> Daily sales transactions</h4>");
		pw.print("<table>");
        pw.print("<tr><th> Date </th><th> Total Sale</th></tr>");
		for (SoldQty disp: li) {

			//pw.print(disp.getProductName()+": "+disp.getOrderPrice()+":"+disp.getQty()+"\n");
			pw.print("<tr><td>"+disp.getOrderdate()+"</td><td> "+disp.getOrderPrice()+"</td></tr> ");

		}

		pw.print("</table>");

		 pw.print("</div></div></div>");

         helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");

    }
}
