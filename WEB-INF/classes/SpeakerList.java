import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SpeakerList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = request.getParameter("maker");

		HashMap<String, Speaker> hm = new HashMap<String, Speaker>();
		if (CategoryName.equals("null")){
			hm.putAll(SAXParserXMLDataStore.speakers);
			name = "";
		}
		else{
			if (CategoryName.equals("JBL")){
				for(Map.Entry<String, Speaker> entry: SAXParserXMLDataStore.speakers.entrySet()){
					if (entry.getValue().getRetailer().equals("JBL")){
						hm.put(entry.getKey(),entry.getValue());
						name = "JBL";
					}

				}
			}
			if (CategoryName.equals("Bose")){
				for(Map.Entry<String, Speaker> entry: SAXParserXMLDataStore.speakers.entrySet()){
					if (entry.getValue().getRetailer().equals("Bose")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Bose";
					}

				}
			}
			if (CategoryName.equals("Philips")){
				for(Map.Entry<String, Speaker> entry: SAXParserXMLDataStore.speakers.entrySet()){
					if (entry.getValue().getRetailer().equals("Philips")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Philips";
					}

				}
			}
			if (CategoryName.equals("Logitech")){
				for(Map.Entry<String, Speaker> entry: SAXParserXMLDataStore.speakers.entrySet()){
					if (entry.getValue().getRetailer().equals("Logitech")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Logitech";
					}

				}
			}
		}

		Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");

		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		pw.print("No of match:"+size);
		for (Map.Entry<String, Speaker> entry : hm.entrySet()) {
			Speaker speaker = entry.getValue();
			if (i == 1 || (i % 3 == 1 && i <= size))
				pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + speaker.getName() + "</h3>");

			pw.print("<strong>RETAILER:" + speaker.getRetailer() + "</strong><br>");
			pw.print("<strong>PRICE: $" + speaker.getPrice() + "</strong><ul style='margin-left: 0px;'>");

			pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+speaker.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" + "<input type='hidden' name='name' value='"
					+ speaker.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
					+ "<input type='hidden' name='maker' value='" + speaker.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + speaker.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + speaker.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + speaker.getPrice() + "'>"
					+ "<input type='submit' value='Add to Cart' ></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewItem'>" + "<input type='hidden' name='name' value='"
					+ speaker.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
					+ "<input type='hidden' name='maker' value='" + speaker.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + speaker.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + speaker.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + speaker.getPrice() + "'>"
					+ "<input type='submit' value='View Item'></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='WriteReview'>" + "<input type='hidden' name='name' value='"
					+ speaker.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
					+ "<input type='hidden' name='maker' value='" + speaker.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + speaker.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + speaker.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + speaker.getPrice() + "'>"
					+ "<input type='submit' value='Write Review'></form></li>");
			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ViewReview'>" + "<input type='hidden' name='name' value='"
					+ speaker.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
					+ "<input type='hidden' name='maker' value='" + speaker.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + speaker.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + speaker.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + speaker.getPrice() + "'>"
					+ "<input type='submit' value='View Review'></form></li>");
			pw.print("</ul></div></td>");
			i++;
			if (i % 3 == 1) {
				pw.print("</tr>");
				if (i <=size)
					pw.print("<tr>");

			}
		}

		pw.print("</table></div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}

}
