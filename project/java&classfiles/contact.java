import java.io.*;
import java.net.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class contact extends HttpServlet
{
protected void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException, IOException
{
processRequest(req,res);
}
protected void doPost(HttpServletRequest req,HttpServletResponse res)
throws ServletException, IOException
{processRequest(req,res);
}
protected void processRequest(HttpServletRequest req,HttpServletResponse res)
throws ServletException, IOException
{
try {
String s1 = req.getParameter("f1");
String s2 = req.getParameter("f2");
String s3= req.getParameter("f3");



Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:cmsdatabase";
Connection con = DriverManager.getConnection(url);
String sql = "SELECT * FROM contact";
PreparedStatement pStmt = con.prepareStatement(sql,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_UPDATABLE);
ResultSet rs = pStmt.executeQuery();
rs.moveToInsertRow();
rs.updateString( "name" , s1);
rs.updateString( "email" , s2);
rs.updateString( "comment" , s3);
rs.insertRow( );

PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Thanks!!</b></font></p><br><p align=center><font face=arial color=#666666>Your comments added in our database .We will contact you on your e-mail address as soon as possible.</font></p></body></html>");

out.close();
con.close();
}catch(Exception sqlEx){
System.out.println(sqlEx);
}
}
}