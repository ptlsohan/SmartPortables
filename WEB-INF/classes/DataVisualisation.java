import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/DataVisualisation")
public class DataVisualisation extends HttpServlet {

 private static final long serialVersionUID = 1L;

 public DataVisualisation() {
  //super();
 }

 protected void doGet(HttpServletRequest request,
   HttpServletResponse response) throws ServletException, IOException {

  ArrayList<SoldQty> list = new ArrayList<SoldQty>();
  list=MySQLDataStore.getSoldQty();
/*ProductSaleData psale=new ProductSaleData();
  ArrayList<ProductSaleData> li = new ArrayList<ProductSaleData>();
  for(SoldQty sd: list){

    psale.setProductName(sd.getProductName());
    System.out.println(sd.getProductName());
    psale.setTotalSale(sd.getTotalSale());
    li.add(psale);
  }*/
  Gson gson = new Gson();

  String jsonString = gson.toJson(list);

  response.setContentType("application/JSON");
  PrintWriter pw = response.getWriter();
  pw.print("1123456");
  pw.print(jsonString);
  response.getWriter().write(jsonString);

 }
}
