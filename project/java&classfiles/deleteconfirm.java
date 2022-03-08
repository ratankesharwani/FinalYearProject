import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class deleteconfirm extends HttpServlet
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
 
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 

String url="jdbc:odbc:cmsdatabase";                   // URL connection

Connection con=DriverManager.getConnection(url);    // establish connection

Statement st=con.createStatement();          // create statment 


String f2 = req.getParameter("f1");

String sql="delete from generalinfo WHERE airwayno='"+f2+"' ";

int num=st.executeUpdate(sql);
if(num==0){
PrintWriter out2 = res.getWriter();
out2.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You enter wrong airway bill no  "+f2+" which is not found in our database.Please go back and enter another airway bill no.</font></p></body></html>");
out2.close();
}else{
PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Successfull Deleted</b></font></p><br><p align=center><font face=arial color=#666666>You deleted "+num+" record in our database airway bill no "+f2+".</font></p></body></html>");
out.close();
  }



con.close();


con.close();
 }
catch(Exception sqlEx){
  PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>Database not found.</font></p></body></html>");
out.close();
}
}
}
