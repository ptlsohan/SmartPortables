/*import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
public class SignUpPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

    Helper helper = new Helper(request, pw);
    helper.printHtml("site_header.html");
    pw.print("<div id='post'><section id='content'><article>");
		pw.print("<table id='bestseller'>");
    pw.print("<form method='get' action='SignUp'>"
            +"<tr><td>Username:</td><td><input type='text' name='username'></td></tr>"
            +"<tr><td>Password:</td><td><input type='password' name='password'></td></tr>"
            +"<tr><td>User type:</td><td><select><option value='Customer'>Customer</option><option value='Manager'>Manager</option><option value='Salesman'>Salesman</option></select></td></tr>"
            +"<tr><td><input type='submit' value='Sign Up'></td></tr></form>");
   pw.print("</table></article></section></div>");
   helper.printHtml("site_sidebar.html");
   helper.printHtml("site_footer.html");
  }

}
*/
