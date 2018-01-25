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

public class SaleTable extends HttpServlet{

   // PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
         response.setContentType("text/html");
	     PrintWriter pw = response.getWriter();
	     Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");
	     String pn="";
	     String reb="";
	     int qty=0;
	     String sa="";
	     ProductQty prod=new ProductQty();
	     HashMap<String, String> pq = new HashMap<String, String>();
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

			prod.setSale(laptop.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	     for (Map.Entry<String, Phone> entry : hm1.entrySet()) {
			Phone phone = entry.getValue();
			prod.setProductName(phone.getName());
			prod.setSale(phone.getSale());
			prod.setRebate(phone.getRebate());

			//prod.setSale(phone.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Smartwatch> entry : hm2.entrySet()) {
			Smartwatch smartwatch = entry.getValue();
			prod.setProductName(smartwatch.getName());
			prod.setRebate(smartwatch.getRebate());

			prod.setSale(smartwatch.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Speaker> entry : hm3.entrySet()) {
			Speaker speaker = entry.getValue();
			prod.setProductName(speaker.getName());
			prod.setRebate(speaker.getRebate());

			prod.setSale(speaker.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }
	      for (Map.Entry<String, Headphone> entry : hm4.entrySet()) {
			Headphone headphone = entry.getValue();
			prod.setProductName(headphone.getName());
			prod.setRebate(headphone.getRebate());

			prod.setSale(headphone.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }

	      for (Map.Entry<String, Estorage> entry : hm5.entrySet()) {
			Estorage storage = entry.getValue();
			prod.setProductName(storage.getName());
			prod.setRebate(storage.getRebate());

			prod.setSale(storage.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }
        pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");
		pw.print("<h4> List of Products currently on Sale</h4>");
		pw.print("<table>");
        pw.print("<tr><th> Product Name </th><th> </th></tr>");
	      for (Map.Entry<String, Accessory> entry : hm6.entrySet()) {
			Accessory accessory = entry.getValue();
			prod.setProductName(accessory.getName());
			prod.setRebate(accessory.getRebate());

			prod.setSale(accessory.getSale());

			pq.put(prod.getProductName(),prod.getSale());
             //System.out.println("HashMap: "+pq.keySet());

	     }

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
