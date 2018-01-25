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

public class RebateTable extends HttpServlet{

   // PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     HashMap<String,String> pq=new HashMap<String,String>();
	     pq=Generate.generatedata();
	     response.setContentType("text/html");
	     PrintWriter pw = response.getWriter();
	     Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");
		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		pw.print("<h4> List of Product currently on Manufacturer Rebate</h4>");
		pw.print("<table>");
        pw.print("<tr><th> Product Name </th><th> </th></tr>");
	     for (Map.Entry<String, String> en : pq.entrySet()) {
                //ProductQty productqty= en.getValue();
               // System.out.println("Map: "+en.getValue());
         if(en.getValue().equals("yes"))
	     pw.print("<tr><td>"+en.getKey()+"</td><td>  "+"</td></tr> ");
	     }
	     pw.print("</table>");
	     pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}
}
