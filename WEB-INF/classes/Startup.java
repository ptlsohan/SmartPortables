import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Startup extends HttpServlet {
    public void init() throws ServletException{
        SAXParserXMLDataStore.addHashMap( );

        for(Map.Entry<String, Product> entry: SAXParserXMLDataStore.products.entrySet()){
                MySQLDataStore.insertProduct(entry.getValue().getId(),entry.getValue().getName(),entry.getValue().getType(),entry.getValue().getPrice(),entry.getValue().getImage(),entry.getValue().getRetailer(),entry.getValue().getQty(),entry.getValue().getRebate(),entry.getValue().getSale());


				}
        for(Map.Entry<String, Accessory> entry: SAXParserXMLDataStore.accessories.entrySet()){
                MySQLDataStore.insertProduct(entry.getValue().getId(),entry.getValue().getName(),entry.getValue().getType(),entry.getValue().getPrice(),entry.getValue().getImage(),entry.getValue().getRetailer(),entry.getValue().getQty(),entry.getValue().getRebate(),entry.getValue().getSale());


				}


    }
}
