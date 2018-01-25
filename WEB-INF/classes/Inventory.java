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

public class Inventory extends HttpServlet{

    PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     response.setContentType("text/html");
	     pw= response.getWriter();
	     String pn="";
	     String reb="";
	     int qty=0;
	     String sa="";
	     ProductQty prod=new ProductQty();
	     HashMap<String, Integer> pq = new HashMap<String, Integer>();
	     HashMap<String, Laptop> hm = new HashMap<String, Laptop>();
		//if (CategoryName.equals("null")){
			hm.putAll(SAXParserXMLDataStore.laptops);
		HashMap<String, Phone> hm1 = new HashMap<String, Phone>();
        hm1.putAll(SAXParserXMLDataStore.phones);
        HashMap<String, Smartwatch> hm2 = new HashMap<String, Smartwatch>();
        hm2.putAll(SAXParserXMLDataStore.smartwatches);
        HashMap<String, Speaker> hm3 = new HashMap<String, Speaker>();
        hm3.putAll(SAXParserXMLDataStore.speakers);
        HashMap<String, Headphone> hm4 = new HashMap<String, Headphone>();
        hm4.putAll(SAXParserXMLDataStore.headphones);
        HashMap<String, Estorage> hm5 = new HashMap<String, Estorage>();
        hm5.putAll(SAXParserXMLDataStore.storages);
        HashMap<String, Accessory> hm6 = new HashMap<String, Accessory>();
        hm6.putAll(SAXParserXMLDataStore.accessories);
			//name = "";
		//}
	     for (Map.Entry<String, Laptop> entry : hm.entrySet()) {
			Laptop laptop = entry.getValue();
			prod.setProductName(laptop.getName());
			prod.setRebate(laptop.getRebate());
			if(MySQLDataStore.getSoldProd(laptop.getName())==null)
			prod.setQty(laptop.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(laptop.getName());
                    qty=laptop.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(laptop.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	     for (Map.Entry<String, Phone> entry : hm1.entrySet()) {
			Phone phone = entry.getValue();
			prod.setProductName(phone.getName());
			prod.setRebate(phone.getRebate());
			if(MySQLDataStore.getSoldProd(phone.getName())==null)
			prod.setQty(phone.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(phone.getName());
                    qty=phone.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(phone.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Smartwatch> entry : hm2.entrySet()) {
			Smartwatch smartwatch = entry.getValue();
			prod.setProductName(smartwatch.getName());
			prod.setRebate(smartwatch.getRebate());
			if(MySQLDataStore.getSoldProd(smartwatch.getName())==null)
			prod.setQty(smartwatch.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(smartwatch.getName());
                    qty=smartwatch.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(smartwatch.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Speaker> entry : hm3.entrySet()) {
			Speaker speaker = entry.getValue();
			prod.setProductName(speaker.getName());
			prod.setRebate(speaker.getRebate());
			if(MySQLDataStore.getSoldProd(speaker.getName())==null)
			prod.setQty(speaker.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(speaker.getName());
                    qty=speaker.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(speaker.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Headphone> entry : hm4.entrySet()) {
			Headphone headphone = entry.getValue();
			prod.setProductName(headphone.getName());
			prod.setRebate(headphone.getRebate());
			if(MySQLDataStore.getSoldProd(headphone.getName())==null)
			prod.setQty(headphone.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(headphone.getName());
                    qty=headphone.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(headphone.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }

	      for (Map.Entry<String, Estorage> entry : hm5.entrySet()) {
			Estorage storage = entry.getValue();
			prod.setProductName(storage.getName());
			prod.setRebate(storage.getRebate());
			if(MySQLDataStore.getSoldProd(storage.getName())==null)
			prod.setQty(storage.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(storage.getName());
                    qty=storage.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(storage.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }

	      for (Map.Entry<String, Accessory> entry : hm6.entrySet()) {
			Accessory accessory = entry.getValue();
			prod.setProductName(accessory.getName());
			prod.setRebate(accessory.getRebate());
			if(MySQLDataStore.getSoldProd(accessory.getName())==null)
			prod.setQty(accessory.getQty());
			else{
			    SoldQty sd=MySQLDataStore.getSoldProd(accessory.getName());
                    qty=accessory.getQty()-sd.getQty();
                prod.setQty(qty);
			}
			prod.setSale(accessory.getSale());

			pq.put(prod.getProductName(),prod.getQty());
             //System.out.println("HashMap: "+pq.keySet());

	     }


	     Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");
		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		pw.print("<h4> Total Products Available </h4>");
		pw.print("<table>");
        pw.print("<tr><th> Product Name </th><th> Available Quantity </th></tr>");
	     for (Map.Entry<String, Integer> en : pq.entrySet()) {
                //ProductQty productqty= en.getValue();
               // System.out.println("Map: "+en.getValue());
	     pw.print("<tr><td>"+en.getKey()+"</td><td>  "+en.getValue()+"</td></tr> ");
	     }
	     pw.print("</table>");
	     pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}
}
