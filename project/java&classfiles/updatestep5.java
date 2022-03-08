import java.io.*;

import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class updatestep5 extends HttpServlet
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
try{



String f3 = req.getParameter("dateinput");  
String f4 = req.getParameter("statusinput");
String f5 = req.getParameter("locationinput");
String f2 = req.getParameter("f1");


Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 

String url="jdbc:odbc:cmsdatabase";                   // URL connection

Connection con=DriverManager.getConnection(url);    // establish connection

Statement st=con.createStatement();          // create statment 
   String sql= "UPDATE generalinfo SET date5 = '"+f3+"' " + "WHERE airwayno = '"+f2+"'";
   String sql2= "UPDATE generalinfo SET trackinfo5 = '"+f4+"' " + "WHERE airwayno = '"+f2+"'";
   String sql3= "UPDATE generalinfo SET location5 = '"+f5+"' " + "WHERE airwayno = '"+f2+"'";
int num=st.executeUpdate(sql);
int num2=st.executeUpdate(sql2);
int num3=st.executeUpdate(sql3);
if(num==0 || num2==0 || num3==0){
PrintWriter out2 = res.getWriter();
out2.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You enter incorrect information.</font></p></body></html>");
out2.close();
}else if(num==1 && num2==1 && num3==1){
PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Successfull Updated</b></font></p><br><p align=center><font face=arial color=#666666>You updated "+num+" record in our database.</font></p></body></html>");
out.close();
}

con.close();

}
catch(Exception sqlEx){
  PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>Database not found.</font></p></body></html>");
out.close();
}
}


}// end FormServlet
