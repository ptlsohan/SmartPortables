import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class UpdateHashmap extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Product newp= new Product();

        Helper helper = new Helper(request,pw);
        String name=request.getParameter("name");
        String maker=request.getParameter("maker");
        String type=request.getParameter("type");
        double price=Double.parseDouble(request.getParameter("price"));
        String id=request.getParameter("id");
        String image=request.getParameter("image");
        int qty=Integer.parseInt(request.getParameter("qty"));
        String rebate=request.getParameter("rebate");
        String sale=request.getParameter("sale");

        newp.setName(name);
        newp.setRetailer(maker);
        newp.setType(type);
        newp.setPrice(price);
        newp.setId(id);
        newp.setImage(image);
        newp.setQty(qty);
        newp.setRebate(rebate);
        newp.setSale(sale);

        SAXParserXMLDataStore.products.put(id,newp);
        if(request.getParameter("add").equals("yes"))
        MySQLDataStore.insertProduct(id,name,type,price,image,maker,qty,rebate,sale);
        else
        MySQLDataStore.updateProduct(id,name,type,price,image,maker,qty,rebate,sale);

        response.sendRedirect("ModifyProduct");
        return;


   }
}
