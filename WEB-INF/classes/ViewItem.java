import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class ViewItem extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        Helper helper = new Helper(request,pw);
        HashMap<String, String> acc =new HashMap<String, String>();
        HashMap<String, Accessory> acchandler=new HashMap<String, Accessory>();
        ArrayList<String> hm= new ArrayList<String>();
    String  id = request.getParameter("id");

    for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
      if (entry.getValue().getId().equals(id)){
        acc.putAll(entry.getValue().getAccessories());

      }

    }


		helper.printHtml("site_header.html");
		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + request.getParameter("name") + "</h3>");



			pw.print("<li id='item' style='list-style-type: none; width: auto; height: auto;'><img src= 'images\\"+request.getParameter("image")
                    + "' alt='' style='width: 550px; height: 400px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
            pw.print("<strong>RETAILER:" + request.getParameter("maker") + "</strong><br>");
			pw.print("<strong>PRICE: $" + request.getParameter("price") + "</strong><ul style='margin-left: 0px;'>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" + "<input type='hidden' name='name' value='"
					+ request.getParameter("name")+ "'>" + "<input type='hidden' name='type' value='" +request.getParameter("type")+ "'>"
					+ "<input type='hidden' name='maker' value='" +request.getParameter("maker")+ "'>"
          + "<input type='hidden' name='price' value='" +request.getParameter("price")+ "'>"
          + "<input type='hidden' name='id' value='" +request.getParameter("id")+ "'>"
          + "<input type='hidden' name='image' value='" +request.getParameter("image")+ "'>"
					+ "<input type='submit' value='Add to Cart' ></form></li>");
			pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='WriteReview'>" + "<input type='hidden' name='name' value='"
					+ request.getParameter("name")+ "'>" + "<input type='hidden' name='type' value='" +request.getParameter("type")+ "'>"
					+ "<input type='hidden' name='maker' value='" +request.getParameter("maker")+ "'>"
          + "<input type='hidden' name='price' value='" +request.getParameter("price")+ "'>"
          + "<input type='hidden' name='id' value='" +request.getParameter("id")+ "'>"
          + "<input type='hidden' name='image' value='" +request.getParameter("image")+ "'>"
					+ "<input type='submit' value='Write Reviews'></form></li>");
            //pw.print("</ul></div></td>");
            pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='ViewReview'>" + "<input type='hidden' name='name' value='"
					+ request.getParameter("name")+ "'>" + "<input type='hidden' name='type' value='" +request.getParameter("type")+ "'>"
					+ "<input type='hidden' name='maker' value='" +request.getParameter("maker")+ "'>"
          + "<input type='hidden' name='price' value='" +request.getParameter("price")+ "'>"
          + "<input type='hidden' name='id' value='" +request.getParameter("id")+ "'>"
          + "<input type='hidden' name='image' value='" +request.getParameter("image")+ "'>"
					+ "<input type='submit' value='View Reviews'></form></li>");
            pw.print("</ul></div></td>");
            pw.print("</tr>");
        pw.print("</table>");

        int i = 1;
    		int size = acc.size();
    		//pw.print("No of match:"+size);
    		for (Map.Entry<String, String> entrysm : acc.entrySet()) {
    			String access = entrysm.getValue();

  for(Map.Entry<String, Accessory> entryac: SAXParserXMLDataStore.accessories.entrySet()){
    if (entryac.getValue().getName().equals(access)){
      acchandler.put(entryac.getKey(),entryac.getValue());

    }

  }
}

if(acchandler.size()>0){
        pw.print("<h3>Related Accessories:</h3><br>");
        pw.print("<div id='myCarousel' class='carousel slide' data-ride='carousel'><!-- Indicators -->"+
        "<ol class='carousel-indicators'><li data-target='#myCarousel' data-slide-to='0' class='active'></li>"+
        "<li data-target='#myCarousel' data-slide-to='1'></li>"+
        "<li data-target='#myCarousel' data-slide-to='2'></li>"+
        "</ol><div class='carousel-inner'><div class='item active' style='height:250px; width:280px;margin-left:100px;'>");
         int j=1;
         //pw.print("<table id='bestseller'>");
        for (Map.Entry<String, Accessory> entryacch : acchandler.entrySet()) {
          Accessory accessory = entryacch.getValue();
              // pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
               //pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong>");

        if(j==1){
          pw.print("");// first row
          pw.print("<div>");

          pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+accessory.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
          pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" +
           "<h3>" + accessory.getName() + "</h3>");
          pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
         pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong><ul style='margin-left: 0px;'>"+
         "<input type='hidden' name='name' value='"
              + accessory.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
              + "<input type='hidden' name='maker' value='" + accessory.getRetailer() + "'>"
              + "<input type='hidden' name='image' value='" + accessory.getImage() + "'>"
              + "<input type='hidden' name='id' value='" + accessory.getId() + "'>"
              + "<input type='hidden' name='price' value='" + accessory.getPrice() + "'>"
              + "<input type='submit' value='Add to Cart' ></form></li>");
          pw.print("</div></div>");
        }
        if(j!=1){
        pw.print("<div class='item' style='height:250px;width:280px; margin-left:100px'>");
        pw.print("");// first row
      pw.print("<div>");

      pw.print("<li id='item' style='list-style-type: none; width: 200px;'><img src= 'images\\"+accessory.getImage()+ "' alt='' style='width: 200px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
      pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='AddToCart'>" +
       "<h3>" + accessory.getName() + "</h3>");
      pw.print("<strong>RETAILER:" + accessory.getRetailer() + "</strong><br>");
     pw.print("<strong>PRICE: $" + accessory.getPrice() + "</strong><ul style='margin-left: 0px;'>"+
     "<input type='hidden' name='name' value='"
          + accessory.getName() + "'>" + "<input type='hidden' name='type' value='laptops'>"
          + "<input type='hidden' name='maker' value='" + accessory.getRetailer() + "'>"
          + "<input type='hidden' name='image' value='" + accessory.getImage() + "'>"
          + "<input type='hidden' name='id' value='" + accessory.getId() + "'>"
          + "<input type='hidden' name='price' value='" + accessory.getPrice() + "'>"
          + "<input type='submit' value='Add to Cart' ></form></li>");
      pw.print("</div></div>");
    }
        j++;
}
      //pw.print("</table>");
      pw.print("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>"+
        "<span class='glyphicon glyphicon-chevron-left'></span><span class='sr-only'>Previous</span>"+
        "</a><a class='right carousel-control' href='#myCarousel' data-slide='next'>"+
        "<span class='glyphicon glyphicon-chevron-right'></span><span class='sr-only'>Next</span>"+
        "</a>");
}
        pw.print("</div></section></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
    }
}
