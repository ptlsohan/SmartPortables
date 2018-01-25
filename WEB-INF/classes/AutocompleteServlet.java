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


//@WebServlet(name = "AutocompleteServlet", urlPatterns = "/autocomplete")
//to search the grocery categories
public class AutocompleteServlet extends HttpServlet {

    private ServletContext context;
    private HashMap<String, Product> products;
  //  private HashMap<String, Tablet> tablets;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("Autocomplete");
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        String type = request.getParameter("type");
        StringBuffer sb = new StringBuffer();
        Helper helper = new Helper(request, response);

        products = SAXParserXMLDataStore.products;
        //tablets = helper.getTablets();


        if (targetId != null) {
        	//targetId = targetId.trim().toLowerCase();

        } else {
            context.getRequestDispatcher("/Error").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {
            // check if user sent empty string
            if (!targetId.equals("")) {

        		Iterator it = products.keySet().iterator();
                while (it.hasNext()) {
                    String id = (String) it.next();
                    Product product = (Product) products.get(id);

                    if (id.toLowerCase().startsWith(targetId.toLowerCase()) ||
                            product.getName().toLowerCase().startsWith(targetId.toLowerCase()) ||
                            product.getRetailer().toLowerCase().startsWith(targetId.toLowerCase())) {
                        sb.append("<item>");
                        sb.append("<id>" + id + "</id>");
                        sb.append("<type>Product</type>");
                        sb.append("<name>" + product.getName() + "</name>");
                        sb.append("</item>");
                        namesAdded = true;
                    }
                }


            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<items>" + sb.toString() + "</items>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {
            // put the target item in the request scope to display
            if (targetId != null && type != null) {
                PrintWriter pw = response.getWriter();
                helper.printHtml("site_header.html");
                pw.print("<div id='content'><div class='post'><h2 class='title meta'>");

                pw.print("</h2><div class='entry'><table id='bestseller'>");

                pw.print("<div id='body'><section id='content'><article class='expanded'>");
                pw.print("<h2>Search Result</h2>");


                if (type.equalsIgnoreCase("product") && products.containsKey(targetId.trim())) {
                    pw.print(new GenerateItemHtmlHandler(targetId, products.get(targetId)).getHtml());
                }


                helper.printHtml("site_sidebar.html");
                helper.printHtml("site_footer.html");
            }
        }
    }
}
