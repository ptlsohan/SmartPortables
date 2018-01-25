import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class SignUp extends HttpServlet{
  String error_msg="";
  boolean b=false;
//  HttpSession session=request.getSession();
//  String utype=session.getAttribute("usertype");

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
    diplaySignUpPage(request,response,pw,false);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
    HttpSession session=request.getSession();
    Helper helper =new Helper(request,pw);
    String utype="";
    if(helper.isLogin())
    utype=session.getAttribute("usertype").toString();
  String TOMCAT_HOME = System.getProperty("catalina.home");
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String userType = request.getParameter("usertype");

  HashMap<String, User> hmap = new HashMap<String, User>();
try{
    //FileInputStream fileinputstream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\UserDetails.txt"));
    //ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    //Object obj = ois.readObject();
    //hmap = (HashMap)obj;
    //ois.close();
    //fileinputstream.close();
    hmap= MySQLDataStore.selectUser();
}catch (Exception e){
  System.out.println("IO Exception:"+e.getMessage());
}
  if(hmap.containsKey(username)){
    error_msg = "Username already exist";
    System.out.println(error_msg);
     b=true;
  }
  else{
    User user = new User(username, password, userType);
    hmap.put(username,user);
    MySQLDataStore.insertUser(username,password,userType);
    /*try{
  FileOutputStream fos = new FileOutputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\UserDetails.txt"));
  ObjectOutputStream oos = new ObjectOutputStream(fos);
  oos.writeObject(hmap);
  oos.flush();
  oos.close();
  fos.close();
  if(utype.equals("Salesman"))
  error_msg = "Account successfully created for "+username+"!!";
  else
  error_msg="Account successfully created <a href='Login'>Now Login</a>";

}catch (Exception e){*/
 error_msg="Account successfully created <a href='Login'>Now Login</a>";
}


diplaySignUpPage(request,response,pw,true);
}
protected void diplaySignUpPage(HttpServletRequest request,HttpServletResponse response,
PrintWriter pw, boolean error) throws ServletException, IOException{
  Helper helper = new Helper(request, pw);
  helper.printHtml("site_header.html");
  pw.print("<div id='post'><section id='content'><article>");
  pw.print("<table id='bestseller'>");
  if(error){
    pw.print("<h4>"+error_msg+"</h4>");
  }
  pw.print("<form method='post' action='SignUp'>"
          +"<tr><td>Username:</td><td><input type='text' name='username'></td></tr>"
          +"<tr><td>Password:</td><td><input type='password' name='password'></td></tr>"
          +"<tr><td>Confirm Password:</td><td><input type='password' name='cpassword'></td></tr>"
          +"<tr><td>User type:</td><td><select name='usertype'><option value='Customer' selected>Customer</option><option value='Manager'>Manager</option><option value='Salesman'>Salesman</option></select></td></tr>"
          +"<tr><td><input type='submit' value='Sign Up'></td></tr></form>");
 pw.print("</table></article></section></div>");
 helper.printHtml("site_sidebar.html");
 helper.printHtml("site_footer.html");
}

}

