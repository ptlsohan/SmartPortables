import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    Helper helper = new Helper(request, pw);
    HttpSession session= request.getSession();
    String utype="";

		if(helper.isLogin()){
      utype= session.getAttribute("usertype").toString();

      if(request.getParameter("isPress")==null){
			 String productname = request.getParameter("name");//productID
			  String image = request.getParameter("image");
			  String maker = request.getParameter("maker");
			  double price = Double.parseDouble(request.getParameter("price"));
        String productId= request.getParameter("id");
        helper.storeOrder(productname, productId, maker, price, image);
        //response.sendRedirect("Cart");
        //if(utype.equals("Salesman")){
        //  RequestDispatcher rd= request.getRequestDispatcher("CreateOrder");
        //  rd.forward(request, response);
        //}else{
          RequestDispatcher rd= request.getRequestDispatcher("Cart");
          rd.forward(request, response);
        //}
        return;
      }

    }


		else if(!helper.isLogin())
		{
			response.sendRedirect("Login");
			return;
		}
  }
}
