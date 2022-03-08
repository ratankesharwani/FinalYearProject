import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class loginservlet extends HttpServlet{

protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
throws ServletException,IOException
{
   processRequest(request,response);
}


protected void doPost(HttpServletRequest request,
                              HttpServletResponse response)

throws ServletException,IOException
{

processRequest(request,response);

}

protected void processRequest(HttpServletRequest request,
                              HttpServletResponse response)

throws ServletException,IOException
{
  String id=request.getParameter("userid");
  String pwd=request.getParameter("pwd");
if(id.equals("admin")&&pwd.equals("cmsadmin")){

response.sendRedirect("welcome_admin.html");

}
else if(id.equals("staff")&&pwd.equals("cmsstaff")){

response.sendRedirect("staff_home.html");

}
else{
response.sendRedirect("loginfail.html");

} 



}
}
