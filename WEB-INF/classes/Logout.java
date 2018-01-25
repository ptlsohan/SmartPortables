import java.util.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    HttpSession session = request.getSession(false);
    session.removeAttribute("username");
    session.removeAttribute("usertype");
    session.removeAttribute("cid");
    session.invalidate();
    response.sendRedirect("Home");
  }
}
