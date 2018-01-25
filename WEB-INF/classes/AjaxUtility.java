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
import java.io.*;
import java.sql.*;
import java.util.*;


public class AjaxUtility extends HttpServlet
{
public AjaxUtility(){}

public static HashMap<String,Product> getData()
{ HashMap<String,Product> hm=new HashMap<String,Product>();
try
{ Class.forName("com.mysql.jdbc.Driver").newInstance();
 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","admin");
Statement stmt=conn.createStatement();
String selectCustomerQuery="select * from product";
ResultSet rs = stmt.executeQuery(selectCustomerQuery);
while(rs.next())
{
Product p = new Product(rs.getString("Id"), rs.getString("Name"));
hm.put(rs.getString("Id"), p);
}
}
catch (Exception e){
  System.out.println("Exception:"+e.getMessage());
}
return hm;
}
public StringBuffer readdata(String searchId)
{
HashMap<String,Product> data;
StringBuffer sb=new StringBuffer();
data=getData();
Iterator it = data.entrySet().iterator();
while (it.hasNext())
{
Map.Entry pi = (Map.Entry)it.next();
Product p=(Product)pi.getValue();
if (p.getName().toLowerCase().startsWith(searchId))
{
sb.append("<product>");
sb.append("<id>" + p.getId() + "</id>");
sb.append("<productName>" + p.getName() + "</ productName >");
sb.append("</ product >");
}
}
return sb;
}


}
