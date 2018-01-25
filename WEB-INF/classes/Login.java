import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
  String error_msg="";
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
    diplayLoginPage(request,response,pw,false);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

  String TOMCAT_HOME = System.getProperty("catalina.home");
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String userType = request.getParameter("usertype");

  HashMap<String, User> hmap = new HashMap<String, User>();
try{
    /*FileInputStream fileinputstream = new FileInputStream(new File(TOMCAT_HOME+"\\webapps\\trial\\UserDetails.txt"));
    ObjectInputStream ois = new ObjectInputStream(fileinputstream);
    Object obj = ois.readObject();
    hmap = (HashMap)obj;
    ois.close();
    fileinputstream.close();*/
    hmap= MySQLDataStore.selectUser();
}catch (Exception io){
  System.out.println("IO Exception:"+io.getMessage());
}
  if(hmap.containsKey(username)){
    User user= hmap.get(username);
    String user_pwd =user.getPassword();
    String user_type = user.getUserType();
    if(password.equals(user_pwd) && userType.equals(user_type)) {
      HttpSession session= request.getSession(true);
      session.setAttribute("username",user.getUsername());
      session.setAttribute("usertype",user.getUserType());
      response.sendRedirect("Home");
      return;
    }else
    error_msg="Incorrect password";
  }else
  error_msg="Username Not Found";
diplayLoginPage(request,response,pw,true);
}
protected void diplayLoginPage(HttpServletRequest request,HttpServletResponse response,
PrintWriter pw, boolean error) throws ServletException, IOException{
  Helper helper = new Helper(request, pw);
  helper.printHtml("site_header.html");
  pw.print("<div id='post'><section id='content'><article>");
  pw.print("<table id='bestseller'>");
  if(error){
    pw.print("<h4>"+error_msg+"</h4>");
  }
  pw.print("<form method='post' action='Login'>"
          +"<tr><td>Username:</td><td><input type='text' name='username'></td></tr>"
          +"<tr><td>Password:</td><td><input type='password' name='password'></td></tr>"
          +"<tr><td>User type:</td><td><select name='usertype'><option value='Customer' selected>Customer</option><option value='Manager'>Manager</option><option value='Salesman'>Salesman</option></select></td></tr>"
          +"<tr><td></td><td><a href='SignUp'>Create new account</a></td></tr>"
          +"<tr><td><input type='submit' value='Login'></td></tr></form>");
 pw.print("</table></article></section></div>");
 helper.printHtml("site_sidebar.html");
 helper.printHtml("site_footer.html");
}

}
