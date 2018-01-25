
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Helper
	{
	HttpServletRequest req;
	PrintWriter pw;
	String url;
	HttpSession session;
	String carouselId="";
   // HashMap <String,Integer> listofsolditem=new HashMap<String,Integer>();
	public Helper(HttpServletRequest req, PrintWriter pw)
	{
		this.req = req;
		this.pw = pw;
		//this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

	public Helper(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		this.req = req;
		this.pw = res.getWriter();
		//this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

	public Helper()
	{

	}



	public void printHtml(String file)
	{
		String result = HtmlToString(file);
		String usertype = "";
		if (file == "site_header.html")
		{
				if(isLogin()){
					String username = session.getAttribute("username").toString();
					usertype = session.getAttribute("usertype").toString();

					//String username=session.getAttribute("username").toString();
					usertype = session.getAttribute("usertype").toString();
					result +="<li><a href='#'>Hi "+username+"</a></li>";
					if(usertype.equals("Customer")){
						result +="<li><a href='TrackOrder'>Track oreder</a></li>";
                        result +="<li><a href='Trending'>Trending</a></li>";
						result +="<li><a href='Cart?isPress=true'>Cart("+CartCount()+")</a></li>";
					}
					else if(usertype.equals("Manager")){
						result +="<li><a href='ModifyProduct'>View Products</a></li>";
						//result +="<li><a href='TrackOrder'>Track order</a></li>";
						result +="<li><a href='Trending'>Trending</a></li>";
						result +="<li><a href='InReport'>Inventory</a></li>";
						result +="<li><a href='SaleReport'>Sales</a></li>";
						result +="<li><a href='#'>Data Analysis</a></li>";

					}
					else if(usertype.equals("Salesman")){
						result +="<li><a href='SignUp'>Create User Account</a></li>";
						result +="<li><a href='TrackOrder'>View user Order</a></li>";

					}
					result +="<li><a href='Logout'>Logout</a></li>";
				}
				else
					result = result + "<li><a href='Login'>Login</a></li>";


				//if(!usertype.equals("manager") && session.getAttribute("username")!=null)

				//result += "<li class='end'><a href='Cart?fromHelper=true'>Cart("+CartCount()+")</a></li>";
				result += "</ul></nav><div id='page'>";
				pw.print(result);
				}

				else

				pw.print(result);//}
	}







	public String HtmlToString(String file)
	{    url="http://localhost/csj/";
		 String result = null;
		try {
			String webPage = url + file;
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			result = sb.toString();
		} catch (Exception e) {
		}
		return result;
	}
	public boolean isLogin(){
		if(session.getAttribute("username")!=null){
			return true;
		}
		return false;
	}
	public ArrayList<OrderItem> getCustomerOrders(){
		ArrayList<OrderItem> order = new ArrayList<OrderItem>();
		if(OrderHashMap.orders.containsKey(session.getAttribute("username").toString())){
			order=OrderHashMap.orders.get(session.getAttribute("username").toString());
			//return order;
		}
		return order;
	}
	public int CartCount(){
		if(isLogin()){
			return getCustomerOrders().size();
		}
		return 0;
	}
	public void storeOrder(String productname,String productId, String retailer, double price, String image){
			if(!OrderHashMap.orders.containsKey(session.getAttribute("username").toString())){
				ArrayList<OrderItem> ordItem= new ArrayList<OrderItem>();
				OrderHashMap.orders.put(session.getAttribute("username").toString(),ordItem);
			}
			ArrayList<OrderItem> ord= OrderHashMap.orders.get(session.getAttribute("username").toString());
			OrderItem oi=new OrderItem(productname, productId, retailer, price, image);
			ord.add(oi);
	}
	public void remOrder(int i){
		ArrayList<OrderItem> ord= getCustomerOrders();
			//int val=ord.indexOf(i)-1;
			System.out.println(i);
		 ord.remove(i);
		 return;


	}
	public void setcarouselId(String id){
		char cid = id.charAt(0);
		if(cid != 'a')
		this.carouselId=id;
		System.out.println("Carousel Id"+carouselId);
	}
	public String getcarouselId(){
		return carouselId;
		//System.out.println("Return Carousel Id "+carouselId);
	}
	public void setProductSold(OrderItem oi){
      int soldno=0;
      if(SoldHashMap.listofsolditem.containsKey(oi.getProductname()))
        soldno=SoldHashMap.listofsolditem.get(oi.getProductname())+1;
    else
        soldno=1;
    System.out.println("Soldno"+soldno);
    SoldHashMap.listofsolditem.put(oi.getProductname(),soldno);

	}
	public HashMap<String,Integer> getProductSold(){
        return SoldHashMap.listofsolditem;
	}

	}
