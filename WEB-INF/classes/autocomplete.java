import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;


//@WebServlet(name = "autocomplete", urlPatterns = "/autocomplete")
//to search the grocery categories
public class autocomplete extends HttpServlet {

    private ServletContext context;
    private HashMap<String, Product> products;
  //  private HashMap<String, Tablet> tablets;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int size=0;
      //  System.out.println("Autocomplete");
        String action =request.getParameter("action");
        String searchId = request.getParameter("searchId");
        StringBuffer sb = new StringBuffer();
        Helper helper = new Helper(request, response);

        products = MySQLDataStore.selectProduct();//SAXParserXMLDataStore.products;






        boolean namesAdded = false;
        if (action.equals("complete")) {

            if (!searchId.equals("")) {

        		Iterator it = products.keySet().iterator();
                while (it.hasNext()) {
                    String id = (String) it.next();
                    Product product = (Product) products.get(id);

                    if (id.toLowerCase().startsWith(searchId.toLowerCase()) ||
                            product.getName().toLowerCase().startsWith(searchId.toLowerCase()) ||
                            product.getRetailer().toLowerCase().startsWith(searchId.toLowerCase())) {
                        sb.append("<product>");
                        sb.append("<id>" + product.getId() + "</id>");
                        sb.append("<productName>" + product.getName() + "</productName>");
                        sb.append("</product>");
                        size++;
                        namesAdded = true;
                    }
                }


            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.getWriter().write("<product>" + sb.toString() + "</product>");
            } else {

                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {
            if (searchId != null) {
                PrintWriter pw = response.getWriter();
                helper.printHtml("site_header.html");
                pw.print("<div id='content'><div class='post'><h2 class='title meta'>");

                pw.print("</h2><div class='entry'><table id='bestseller'>");

                pw.print("<div id='body'><section id='content'><article class='expanded'>");
                pw.print("<h2>Search Result</h2>");


                Iterator it = products.keySet().iterator();
                    while (it.hasNext()) {
                        String id = (String) it.next();
                        Product product = (Product) products.get(id);
                        int i=0;
                        //System.out.println(id);
                if (id.toLowerCase().startsWith(searchId.toLowerCase()) ||product.getName().toLowerCase().startsWith(searchId.toLowerCase()) ||
                product.getRetailer().toLowerCase().startsWith(searchId.toLowerCase())) {
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

            		pw.print("</table></div></div></div>");
            		helper.printHtml("site_sidebar.html");
            		helper.printHtml("site_footer.html");
            }
        }
    }
}
