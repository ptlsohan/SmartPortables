
import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


public class Home extends HttpServlet {

	public void init() throws ServletException{
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();


		Helper helper = new Helper(request,pw);
		helper.printHtml("site_header.html");
		//helper.printHtml("site_home.html");
		//response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		HashMap<String,Product> selectedproducts=new HashMap<String,Product>();
		HashMap<String,Product> productmap=new HashMap<String,Product>();
		String line=null;
		try
		{
		pw.print("<div id='content'>");
		pw.print("<div class='post'>");
		pw.print("<h2 class='title'>");
		pw.print("<a href='Home'>Welcome to SmartPortables </a></h2>");
		pw.print("<img src='images\\imag.jpg' style='width: 100%; display: block; margin-left: auto; margin-right: auto' />");
		pw.print("<div class='entry'>");
		pw.print("<br> <br>");
		pw.print("<h4>The world trusts us to deliver SPEEDY service</h4>");
		pw.print("<br> <br>");
		pw.print("<h3>We beat our competitors in all aspects. Price-Match Guaranteed</h3>");

		productmap=MySQLDataStore.selectProduct();
		}
		catch(Exception e){}

		System.out.println(productmap.size());
		for(Map.Entry<String, Product> en : productmap.entrySet())
		{
		  Product prod=en.getValue();
		if(selectedproducts.size()<2 && !selectedproducts.containsKey(prod.getName()))
		{
		String TOMCAT_HOME = System.getProperty("catalina.home");
		BufferedReader reader = new BufferedReader(new FileReader (new File(TOMCAT_HOME+"\\webapps\\csj\\DealMatches.txt")));
		line=reader.readLine();
		if(line==null)
		{ pw.print("<h3 align='center'>No Offers Found</h3>");break;}
		else
		{ do {
		if(line.contains(prod.getName()))
		{
		pw.print("<h4>"+line+"</h4>");
		pw.print("<br>");
		selectedproducts.put(prod.getId(),prod);
		break;
		}
		}while((line = reader.readLine()) != null);

		}
		}
		}
		//pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<h2>Deal Matches:</h2>");
		pw.print("<div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = selectedproducts.size();
		//pw.print("No of match:"+size);
		if (size==0){
			pw.print("<h3 align='center'>No Deals Found</h3>");
		}
		else{
		for (Map.Entry<String, Product> entry : selectedproducts.entrySet()) {
		  Product product = entry.getValue();
		  if (i == 1 || (i % 3 == 1 && i <= size))
		    pw.print("<tr>");// first row
		  pw.print("<td><div id='shop_item'>");
		  pw.print("<h3>" + product.getName() + "</h3>");


		  pw.print("<strong>RETAILER:" + product.getRetailer() + "</strong><br>");
		  pw.print("<strong>PRICE: $" + product.getPrice() + "</strong><ul style='margin-left: 0px;'>");

		  pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+product.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
		  pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" + "<input type='hidden' name='name' value='"
		      + product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
		      + "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
		      + "<input type='hidden' name='image' value='" + product.getImage() + "'>"
		      + "<input type='hidden' name='id' value='" + product.getId() + "'>"
		      + "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
		      + "<input type='submit' value='Add to Cart' ></form></li>");
		  pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewItem'>" + "<input type='hidden' name='name' value='"
		      + product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
		      + "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
		      + "<input type='hidden' name='image' value='" + product.getImage() + "'>"
		      + "<input type='hidden' name='id' value='" + product.getId() + "'>"
		      + "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
		      + "<input type='submit' value='View Item'></form></li>");
		  pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='WriteReview'>" + "<input type='hidden' name='name' value='"
		      + product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
		      + "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
		      + "<input type='hidden' name='image' value='" + product.getImage() + "'>"
		      + "<input type='hidden' name='id' value='" + product.getId() + "'>"
		      + "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
		      + "<input type='submit' value='Write Review'></form></li>");
		  pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewReview'>" + "<input type='hidden' name='name' value='"
		      + product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
		      + "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
		      + "<input type='hidden' name='image' value='" + product.getImage() + "'>"
		      + "<input type='hidden' name='id' value='" + product.getId() + "'>"
		      + "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
		      + "<input type='submit' value='View Review'></form></li>");
		  pw.print("</ul></div></td>");
		  i++;
		  if (i % 3 == 1) {
		    pw.print("</tr>");
		    if (i <=size)
		      pw.print("<tr>");

		  }
		}
	}

		pw.print("</table></div></div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}
}
