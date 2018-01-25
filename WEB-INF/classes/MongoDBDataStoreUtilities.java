import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.*;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.*;

import java.util.List;
import java.util.Set;
import java.util.Date;




public class MongoDBDataStoreUtilities
{
static DBCollection myReviews;
public static void getConnection()
{
MongoClient mongo;
mongo = new MongoClient("localhost", 27017);
DB db = mongo.getDB("CustomerReviews");
myReviews= db.getCollection("myReviews");
}

public static void insertReview(String username,String productname,String manufacturer,double price,String type,int userage,String userOccupation,String city,int zip,String state,String gender,int rating,String rdate,String review)
{
    String retailerName="SmartPortables";
    //String //userOccupation="None";
getConnection();
BasicDBObject doc = new BasicDBObject("title", "myReviews").
append("productName", productname).
				append("type", type).
				append("ProductPrice", price).
				append("retailerName", retailerName).
				append("RetailerZip", zip).
				append("RetailerCity", city).
				append("RetailerState", state).
				append("ManufacturerName", manufacturer).
				append("userID", username).
				append("userAge", userage).
				append("userGender", gender).
				append("userOccupation", userOccupation).
				append("reviewRating", rating).
				append("reviewDate", rdate).
				append("reviewText", review);
myReviews.insert(doc);
}

public static HashMap<String, ArrayList<Review>> selectReview()
{
getConnection();

HashMap<String, ArrayList<Review>> reviewHashmap=new HashMap<String, ArrayList<Review>>();
DBCursor cursor = myReviews.find();
System.out.println(cursor.count());

while (cursor.hasNext())
{

BasicDBObject obj = (BasicDBObject) cursor.next();

if(!reviewHashmap.containsKey(obj.getString("productName")))
{

ArrayList<Review> arr = new ArrayList<Review>();
reviewHashmap.put(obj.getString("productName"), arr);
}

//String username,String productname,String manufacturer,double price,String type,int userage,String userOccupation,String city,int zip,String state,String gender,int rating,String rdate,String review)
ArrayList<Review> listReview = new ArrayList<Review>();
listReview =reviewHashmap.get(obj.getString("productName"));
String uid=obj.getString("userID");
String pname=obj.getString("productName");
String mname=obj.getString("ManufacturerName");
double pp=obj.getDouble("ProductPrice");

String t=obj.getString("type");
int uagee=obj.getInt("userAge");
String uo=obj.getString("userOccupation");
String rc=obj.getString("RetailerCity");
int rz=obj.getInt("RetailerZip");
String rs=obj.getString("RetailerState");
String ug=obj.getString("userGender");
int rr=obj.getInt("reviewRating");
String rd=obj.getString("reviewDate");
String rt=obj.getString("reviewText");
//
Review review =new Review(uid,pname,mname,pp,t,uagee,uo,rc,rz,rs,ug,rr,rd,rt);
System.out.println("Select mongo endwhile ere:"+reviewHashmap.containsKey("MacbookPro"));
listReview.add(review);

}

// System.out.println("in mongo:"+reviewHashmap.containsKey("MacBookPro"));
return reviewHashmap;
}
}
