import java.io.*;
import java.net.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class senderinfo extends HttpServlet
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
String f1 = req.getParameter("a1");
String f2 = req.getParameter("s1");
String f3= req.getParameter("s2");
String f4= req.getParameter("s3");
String f5= req.getParameter("s4");
String f6= req.getParameter("s5");
String f7= req.getParameter("s6");
String f8= req.getParameter("s7");


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:cmsdatabase";
Connection con = DriverManager.getConnection(url);
String sql = "SELECT * FROM senderinfo";
PreparedStatement pStmt = con.prepareStatement(sql,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_UPDATABLE);
ResultSet rs = pStmt.executeQuery();
rs.moveToInsertRow();
rs.updateString( "airway_sd" , f1);
rs.updateString( "company_sd" , f2);
rs.updateString( "name_sd" , f3);
rs.updateString( "address_sd" , f4);
rs.updateString( "country_sd" , f5);
rs.updateString( "city_sd" , f6);
rs.updateString( "postal_sd" , f7);
rs.updateString( "phone_sd" , f8);



rs.insertRow( );


PrintWriter out = res.getWriter();
out.println(f1+f2+f3+f4+f5+f6+f7+f8);
out.close();

}catch(Exception sqlEx){
System.out.println(sqlEx);
}
}
}// end FormServlet