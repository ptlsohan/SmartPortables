import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.*;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.servlet.http.HttpSession;

public class Trending extends HttpServlet{
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
	     response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            Helper helper = new Helper(request, pw);
            HttpSession session= request.getSession();
            DBCollection myReviews;
             MongoClient mongo;
            mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("CustomerReviews");
            myReviews= db.getCollection("myReviews");
             helper.printHtml("site_header.html");
             pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Trending Products</a>");
		pw.print("</h2><div class='entry'>");

           try{

			BasicDBObject gtQuery = new BasicDBObject();
			DBCursor cursor = myReviews.find(gtQuery).sort(new BasicDBObject("reviewRating",-1)).limit(6);
			pw.print("<h4>Top five most liked products</h4>");

			ArrayList<String> dpn= new ArrayList<String>();
			pw.print("<table>");
			pw.print("<tr><th> Product Name: </th><th> Ratings: </th></tr>");
			while (cursor.hasNext()) {

				BasicDBObject obj = (BasicDBObject) cursor.next();

				if(!dpn.contains(obj.getString("productName"))){
				dpn.add(obj.getString("productName"));
				pw.print("<tr><td>"+obj.getString("productName")+"</td><td>"+obj.getInt("reviewRating")+"</td></tr>");


				}


			}
			pw.print("</table>");
		}
       catch(Exception e)
{
	pw.print(e);
}


	try
{



           DBObject groupFields = new BasicDBObject( "_id", 0);
            groupFields.put("_id","$RetailerZip");
			groupFields.put("count", new BasicDBObject( "$sum", 1));
			DBObject group = new BasicDBObject("$group", groupFields );

			DBObject sortFields = new BasicDBObject("count", -1);
			DBObject sort = new BasicDBObject("$sort", sortFields );
			BasicDBObject limit=new BasicDBObject("$limit",5);
			AggregationOutput output = myReviews.aggregate(group, sort,limit);
            pw.print("<h4>Top five zip-codes where maximum number of products sold </h4>");

			pw.print("<table>");
			pw.print("<tr><th> ZIP Code: </th><th> Number of products sold: </th></tr>");
			for (DBObject obj : output.results()) {
                BasicDBObject bobj= (BasicDBObject) obj;
				String id = bobj.getString("_id");
				int times = bobj.getInt("count");

				pw.print("<tr><td>"+id+"</td><td>"+times+"</td></tr>");


			}
}
			catch(Exception e)
			{
				pw.print(e);
			}
			pw.print("</table>");


        try
         {DBObject groupFields = new BasicDBObject( "_id", "$productName");

			groupFields.put("productName", new BasicDBObject( "$sum", 1));
			DBObject group = new BasicDBObject("$group", groupFields );
			DBObject sortFields = new BasicDBObject("productName", -1);
			DBObject sort = new BasicDBObject("$sort", sortFields );
			BasicDBObject limit=new BasicDBObject("$limit",5);
			AggregationOutput output = myReviews.aggregate(group, sort,limit);
            pw.print("<h4>Top five most sold products regardless of the rating </h4>");
			pw.print("<table>");
			pw.print("<tr><th> Product name: </th><th> Number of product sold: </th></tr>");

			for (DBObject obj : output.results()) {
				// out.print(obj);
				String id = obj.get("_id").toString();
				String times = obj.get("productName").toString();

				pw.print("<tr><td>" +obj.get("_id").toString()+ "</td><td>" +obj.get("productName").toString()+ "</td></tr>");

			}
			pw.print("</table>");
}
catch(Exception e)
{
	pw.print(e);
}
            pw.print("</div></div></div>");
         helper.printHtml("site_sidebar.html");
		helper.printHtml("site_footer.html");

	}
  }
