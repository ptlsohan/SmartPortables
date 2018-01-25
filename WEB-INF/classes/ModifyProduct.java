import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ModifyProduct")
public class ModifyProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = null;
		String CategoryName = "All";

    if(request.getParameter("deleteitem")!=null){
       String item = request.getParameter("deleteitem");
        Set keyset=SAXParserXMLDataStore.products.keySet();
       System.out.println(keyset);
      SAXParserXMLDataStore.products.remove(item);
			MySQLDataStore.removeProduct(item);

    }

		HashMap<String, Product> hm = new HashMap<String, Product>();
		if (CategoryName.equals("All")){
			hm.putAll(SAXParserXMLDataStore.products);
			name = "";
		}
		else{
			if (CategoryName.equals("Apple")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Apple")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Apple";
					}

				}
			}
			if (CategoryName.equals("Dell")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Dell")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Dell";
					}

				}
			}
			if (CategoryName.equals("HP")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("HP")){
						hm.put(entry.getKey(),entry.getValue());
						name = "HP";
					}

				}
			}
			if (CategoryName.equals("Lenovo")){
				for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
					if (entry.getValue().getRetailer().equals("Lenovo")){
						hm.put(entry.getKey(),entry.getValue());
						name = "Lenovo";
					}

				}
			}
		}


		Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");

		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'>");
		pw.print("<div><button ><a href='AddProduct'>Add new Product</a></button></div>");
		pw.print("<table id='bestseller'>");
		int i = 1;
		int size = hm.size();
		pw.print("No of match:"+size);
		for (Map.Entry<String, Product> entry : hm.entrySet()) {
			Product product = entry.getValue();
			if (i == 1 || (i % 3 == 1 && i <= size))
				pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + product.getName() + "</h3>");


			pw.print("<strong>RETAILER:" + product.getRetailer() + "</strong><br>");
			pw.print("<strong>PRICE: $" + product.getPrice() + "</strong><ul style='margin-left: 0px;'>");

			pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+product.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");

			pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='ModifyProduct'>" + "<input type='hidden' name='name' value='"
					+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
					+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
					+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
					+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
					+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='submit' value='Remove' class='button'><input type='hidden' name='deleteitem' value='"+product.getId()+"'></form></li>");
      pw.print("<li style='list-style-type: none; margin-left: 8px;float: left;'><form method='get' action='UpdateProduct'>" + "<input type='hidden' name='name' value='"
  				+ product.getName() + "'>" + "<input type='hidden' name='type' value='"+product.getType()+"'>"
  				+ "<input type='hidden' name='maker' value='" + product.getRetailer() + "'>"
  				+ "<input type='hidden' name='image' value='" + product.getImage() + "'>"
    			+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
    			+ "<input type='hidden' name='price' value='" + product.getPrice() + "'>"
					+ "<input type='hidden' name='qty' value='" + product.getQty() + "'>"
					+ "<input type='hidden' name='rebate' value='" + product.getRebate() + "'>"
					+ "<input type='hidden' name='sale' value='" + product.getSale() + "'>"
					+"<input type='hidden' name='add' value='no'>"
    			+ "<input type='submit' value='Update' class='button'><input type='hidden' name='updateitem' value='"+product.getId()+"'></form></li>");

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
