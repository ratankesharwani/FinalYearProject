import java.io.*;
import java.net.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;

public class registration extends HttpServlet
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
String s1 = req.getParameter("ntn");
String s2 = req.getParameter("company");
String s3= req.getParameter("contact");
String s4= req.getParameter("address");
String s5= req.getParameter("country");
String s6= req.getParameter("city");
String s7= req.getParameter("phone");
String s8= req.getParameter("postal");

// get date from here
Date now = new Date();
DateFormat df = DateFormat.getDateInstance();
String today = df.format(now);




Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:cmsdatabase";
Connection con = DriverManager.getConnection(url);
String sql = "SELECT * FROM customerdata";
PreparedStatement pStmt = con.prepareStatement(sql,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_UPDATABLE);
ResultSet rs = pStmt.executeQuery();
rs.moveToInsertRow();
rs.updateString( "ntn" , s1);
rs.updateString( "company" , s2);
rs.updateString( "contact" , s3);
rs.updateString( "address" , s4);
rs.updateString( "country" , s5);
rs.updateString( "city" , s6);
rs.updateString( "phone" , s7);
rs.updateString( "postal" , s8);
rs.updateString( "date" , today);

rs.insertRow( );

PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Successfully Saved!!</b></font></p><br><p align=center><font face=arial color=#666666>You added new customer data in our database . </font></p></body></html>");

out.close();
con.close();
}catch(Exception sqlEx){
PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You entered Duplicate NTN number please go back and enter another NTN number</font></p></body></html>");

out.close();
}
}
}// end FormServlet