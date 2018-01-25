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

public class PAChart extends HttpServlet{

    PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     response.setContentType("text/html");
	     pw= response.getWriter();

            Helper helper = new Helper(request, pw);

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
	     pw.print("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Strict//EN''http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>"+
"<html xmlns='http://www.w3.org/1999/xhtml'>");
pw.print( "<head>");
pw.print("<meta http-equiv='content-type' content='text/html; charset=utf-8' />");
pw.print("<title>SmartPortables</title>");
pw.print("<meta name='keywords' content='' />");
pw.print("<meta name='description' content='' />");
pw.print("<link href='styles.css' rel='stylesheet' type='text/css' media='screen' />");

pw.print("  <meta name='viewport' content='width=device-width, initial-scale=1'>");
pw.print("  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
pw.print("  <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");



    pw.print("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
    pw.print("<script type='text/javascript'>");
      pw.print("google.charts.load('current', {'packages':['bar']});");
      pw.print("google.charts.setOnLoadCallback(drawChart);");

      pw.print("function drawChart() {");
        pw.print("var data = google.visualization.arrayToDataTable([");
          pw.print("['Product', 'Available Qty'],");
          for (Map.Entry<String, Integer> en : pq.entrySet()) {
         pw.print(" ['"+en.getKey()+"', "+en.getValue()+" ],");
         }

       pw.print(" ]);");

       pw.print(" var options = {");
         pw.print(" chart: {");
         pw.print("   title: 'Total Number of Products Available',");
         pw.print(" ");
       pw.print("   },");
        pw.print("  bars: 'horizontal'");
      pw.print("  };");

       pw.print(" var chart = new google.charts.Bar(document.getElementById('barchart_material'));");

       pw.print(" chart.draw(data, google.charts.Bar.convertOptions(options));");
    pw.print("  }");
   pw.print(" </script> ");


  pw.print( " <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
  pw.print("</head>");
  pw.print("<body>");

  pw.print( "<div id='container'>");
	pw.print( "<header>");
     pw.print( "   <h1><a href='#'>SMART PORTABLE</a></h1>");

    pw.print( "</header>");

	pw.print( "<nav>");
      pw.print( "  <ul>");
           pw.print( " <li class='start selected'><a href='Home'>Home</a></li>");
           pw.print( " <li><a href='ModifyProduct'>View Products</a></li>");
						//result +="<li><a href='TrackOrder'>Track order</a></li>";
						 pw.print( " <li><a href='Trending'>Trending</a></li>");
						pw.print( "<li><a href='InReport'>Inventory</a></li>");
						pw.print( "<li><a href='SaleReport'>Sales</a></li>");
						pw.print( "<li><a href='#'>Data Analysis</a></li>");
                        pw.print("<li><a href='Logout'>Logout</a></li>");
                         pw.print("</ul></nav><div id='page'>");
//pw.print( ");");
            pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("</h2><div class='entry'>");

    pw.print("<div id='barchart_material' style='width: 600px; height: 2500px;'></div>");
   // pw.print("</div></div></div></div>");

 pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");


	}
}
