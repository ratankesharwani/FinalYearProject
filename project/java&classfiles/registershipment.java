import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class registershipment extends HttpServlet
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

int found=0;

String f1 = req.getParameter("a1");
String f2 = req.getParameter("s1");
String f3= req.getParameter("s2");
String f4= req.getParameter("s3");
String f5= req.getParameter("s4");
String f6= req.getParameter("s5");
String f7= req.getParameter("s6");
String f8= req.getParameter("s7");
String f9= req.getParameter("r1");
String f10= req.getParameter("r2");
String f11= req.getParameter("r3");
String f12= req.getParameter("r4");
String f13= req.getParameter("r5");
String f14= req.getParameter("r6");
String f15= req.getParameter("r7");
String f16= req.getParameter("a2");
String f17= req.getParameter("g1");
String f18= req.getParameter("g2");
String f19= req.getParameter("g4");
String f20= req.getParameter("g5");





// General Info Start Here:

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url3 = "jdbc:odbc:cmsdatabase";
Connection con3 = DriverManager.getConnection(url3);
String sql3 = "SELECT * FROM generalinfo";
PreparedStatement pStmt3 = con3.prepareStatement(sql3,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_UPDATABLE);
ResultSet rs3 = pStmt3.executeQuery();
rs3.moveToInsertRow();
rs3.updateString( "airwayno" , f1);
rs3.updateString( "date" , f16);
rs3.updateString( "trackinfo" , f20);
rs3.updateString( "type" , f17);
rs3.updateString( "weigth" , f18);
rs3.updateString( "amount" , f19);
found=1;
rs3.insertRow( );
con3.close();

if(found==1){

// sender info start here

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
rs.updateString( "date_sd" , f16);
rs.updateString( "company_sd" , f2);
rs.updateString( "name_sd" , f3);
rs.updateString( "address_sd" , f4);
rs.updateString( "country_sd" , f5);
rs.updateString( "city_sd" , f6);
rs.updateString( "postal_sd" , f7);
rs.updateString( "phone_sd" , f8);
rs.insertRow( );
con.close();





// Receiver Info Start Here:

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url2 = "jdbc:odbc:cmsdatabase";
Connection con2 = DriverManager.getConnection(url2);
String sql2 = "SELECT * FROM recieverinfo";
PreparedStatement pStmt2 = con2.prepareStatement(sql2,
ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_UPDATABLE);
ResultSet rs2 = pStmt2.executeQuery();
rs2.moveToInsertRow();
rs2.updateString( "airway_rr" , f1);
rs2.updateString( "date_rr" , f16);
rs2.updateString( "company_rr" , f9);
rs2.updateString( "name_rr" , f10);
rs2.updateString( "address_rr" , f11);
rs2.updateString( "country_rr" , f12);
rs2.updateString( "city_rr" , f13);
rs2.updateString( "postal_rr" , f14);
rs2.updateString( "phone_rr" , f15);
rs2.insertRow( );
con2.close();


PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Succesfully Created</b></font></p><br><p align=center><font face=arial color=#666666>Airwaybill saved in our database</font></p></body></html>");

out.close();
}

}catch(Exception sqlEx){

PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You entered Duplicate airwaybill number please go back and enter another airwaybill number</font></p></body></html>");

out.close();
}
}


}// end FormServlet