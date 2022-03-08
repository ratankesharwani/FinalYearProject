import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class trackcustomer extends HttpServlet
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
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 

String url="jdbc:odbc:cmsdatabase";                   // URL connection

Connection con=DriverManager.getConnection(url);    // establish connection

Statement st=con.createStatement();          // create statment 

String f1 = req.getParameter("customerinput");

String sql="SELECT * FROM customerdata "+"WHERE ntn='"+f1+"' ";     // Execute Query

ResultSet rs=st.executeQuery(sql);


if(rs.next()) {


do{
String f2=rs.getString("ntn");
String f3=rs.getString("company");
String f4=rs.getString("contact");
String f5=rs.getString("address");
String f6=rs.getString("country");
String f7=rs.getString("city");
String f8=rs.getString("postal");
String f9=rs.getString("phone");
String f10=rs.getString("date");
String f11=rs.getString("first");
String f12=rs.getString("last");
String f13=rs.getString("total");
int number=Integer.parseInt(f13);


PrintWriter out = res.getWriter();
//header
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Customer Information</u> </font></b></td></tr></table></body></html>");
// customer
out.println("<table border=0 cellpadding=2 cellspacing=0 border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2>");
out.println("<tr>");
out.println("<td width=33%><font face=Arial size=2 color=#666666><b>NTN no:&nbsp;   </b>"+ f2+"</font></td>");
out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Company name:&nbsp;   </b>"+f3+"</font></td>");
out.println("<td width=34%><font face=Arial size=2 color=#666666><b>Contact name:&nbsp;   </b>"+f4+"</font></td>");
  out.println("</tr>");
  out.println("<tr>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Address:&nbsp;   </b>"+f5+"</font></td>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Country:&nbsp;   </b>"+f6+"</font></td>");
out.println("<td width=34%><font face=Arial size=2 color=#666666><b>C</b></font><b><font face=Arial size=2 color=#666666>ity: </font></b><font face=Arial size=2 color=#666666>"+f7+"</font></td>");
  out.println("</tr>");
  out.println("<tr>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Postal code:&nbsp;   </b>"+f8+"</font></td>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Phone no:&nbsp;   </b>"+f9+"<b>   </b></font></td>");
    out.println("<td width=34%><font face=Arial size=2 color=#666666><b>Issued Date:&nbsp;   </b>"+f10+"</font></td>");
  out.println("</tr>");
out.println("</table>");
//Detail 
out.println("<br>");
out.println("<br>");
 out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Shipment Details</u></font></b></td></tr></table>");

out.println("<table border=0 cellpadding=2 cellspacing=0 border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2>");
 out.println("<tr>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>First Shipment:&nbsp;   </b>"+f11+"</font></td>");
    out.println("<td width=33%><font face=Arial size=2 color=#666666><b>Last Shipment:&nbsp;   </b>"+f12+"<b>   </b></font></td>");
    out.println("<td width=34%><font face=Arial size=2 color=#666666><b>Total Shipment:&nbsp;   </b>"+number+"</font></td>");
  out.println("</tr>");
out.println("</table>");
out.close();
con.close();


  
  }while(rs.next());

         
     }
else{
PrintWriter out2 = res.getWriter();
out2.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You entered wrong NTN no "+f1+" which is not found in our database .Please go back and enter again.</font></p></body></html>");
out2.close();

}





con.close();


}catch(Exception sqlEx){

PrintWriter out = res.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>Database is not found.</font></p></body></html>");
out.close();
}
}


}// end FormServlet