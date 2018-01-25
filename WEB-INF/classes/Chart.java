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

public class Chart extends HttpServlet{

    PrintWriter pw;
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     response.setContentType("text/html");
	     pw= response.getWriter();
	      Helper helper = new Helper(request, pw);
	      ArrayList<SoldQty>li=new ArrayList<>();
		li=MySQLDataStore.getSoldQty();

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
          pw.print("['Product', 'Sales'],");
          for (SoldQty disp: li) {
         pw.print(" ['"+disp.getProductName()+"', "+disp.getTotalSale()+" ],");
         }
         //pw.print(" ['2015', 1170, 460, 250],");
         //pw.print(" ['2016', 660, 1120, 300],");
        //pw.print("  ['2017', 1030, 540, 350]");
       pw.print(" ]);");

       pw.print(" var options = {");
         pw.print(" chart: {");
         pw.print("   title: 'Total Sale for Every Product',");
         pw.print("   ");
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
    pw.print("<div id='barchart_material' style='width: 600px; height: 1000px;'></div>");

  pw.print("</div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");


	}
}
