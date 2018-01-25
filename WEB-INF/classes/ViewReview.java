import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewReview")
public class ViewReview extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//String name = null;
		String productname = request.getParameter("name");
        //System.out.println(productname);
		 HashMap<String, ArrayList<Review>> reviews= new HashMap<String, ArrayList<Review>>();
         try
            {reviews=MongoDBDataStoreUtilities.selectReview();
            }
         catch(Exception e)
            { }
         ArrayList<Review> reviewlist= new ArrayList<Review>();
        // System.out.println(reviews.getKey(productname));
		for(Map.Entry<String, ArrayList<Review>> entry: reviews.entrySet()){

		if(entry.getKey().equals(productname)){
           for(Review list: entry.getValue())
           reviewlist.add(list);
         }
		}
		Helper helper = new Helper(request, pw);
		helper.printHtml("site_header.html");

		pw.print("<div class='post' class='width'><section id='content'>");
		pw.print("<div class='entry'><table id='bestseller'>");

		pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<h3>" + request.getParameter("name") + "</h3>");



			pw.print("<li id='item' style='list-style-type: none; width: auto; height: auto;'><img src= 'images\\"+request.getParameter("image")
                    + "' alt='' style='width: 350px; height: 200px; list-style-type: none; display: block; margin-left: auto; margin-right: auto'/></li>");
            pw.print("<strong>RETAILER:" + request.getParameter("maker") + "</strong><br>");
			pw.print("<strong>PRICE: $" + request.getParameter("price") + "</strong><br>");

         pw.print("<li style='list-style-type: none; float: left;'><form method='get' action='WriteReview'>" + "<input type='hidden' name='name' value='"
					+ request.getParameter("name")+ "'>" + "<input type='hidden' name='type' value='consoles'>"
					+ "<input type='hidden' name='maker' value='" +request.getParameter("maker")+ "'>"
          + "<input type='hidden' name='price' value='" +request.getParameter("price")+ "'>"
          + "<input type='hidden' name='id' value='" +request.getParameter("id")+ "'>"
          + "<input type='hidden' name='image' value='" +request.getParameter("image")+ "'>"
					+ "<input type='submit' value='Write Reviews'></form></li><br><br>");
		int size = reviewlist.size();
		pw.print("No of reviews:"+size);

		for (Review ent: reviewlist) {
			Review review = ent;
			//if (i == 1 || (i % 3 == 1 && i <= size))
				pw.print("<tr>");// first row
			pw.print("<td><div id='shop_item'>");
			pw.print("<div style='width:100%'><h4>UserID: " + review.getUsername() + "</h4>");

			pw.print("<strong>Age:</strong>" + review.getUAge() + "");
			 pw.print("<strong>Gender: </strong>" + review.getGender() + " ");
			  pw.print("<strong>Occcupation:</strong> " + review.getUserOccupation() + "  <br>");
			 //pw.print("<strong>Date: " + review.getDate() + "  </strong><br>");
			pw.print("<strong>Rating: </strong>" + review.getRating() + " ");
			pw.print("<strong>Date:</strong> " + review.getDate() + " ");
			pw.print("<strong>City: </strong>" + review.getCity() + " <br>");
			pw.print("<strong>Zipcode: </strong>" + review.getZip() + " ");
			pw.print("<strong>State: </strong>" + review.getState() + " <br>");
			pw.print("<strong>Review:</strong> <p>" + review.getReview() + " </p><br>");
			pw.print("<ul style='margin-left: 0px;'>");


			pw.print("</ul></div></div></td>");

				pw.print("</tr>");

			}


		pw.print("</table></div></div></div>");
		helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");
	}


	}
