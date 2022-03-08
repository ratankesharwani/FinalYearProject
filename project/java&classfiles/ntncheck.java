import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;

public class ntncheck extends HttpServlet{

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
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 

String url="jdbc:odbc:cmsdatabase";                   // URL connection

Connection con=DriverManager.getConnection(url);    // establish connection

Statement st=con.createStatement();          // create statment 

String f1 = request.getParameter("ntninput");


String sql="SELECT * FROM customerdata "+"WHERE ntn='"+f1+"' ";     // Execute Query

ResultSet rs=st.executeQuery(sql);

if(rs.next()) {


do{


String f2=rs.getString("first");
String f3=rs.getString("last");
String f4=rs.getString("total");
int total=Integer.parseInt(f4);
int subtotal=1;
subtotal=subtotal+total;

// get date from here
Date now = new Date();
DateFormat df = DateFormat.getDateInstance();
String today = df.format(now);



// customer data storage start here 

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 
String url2="jdbc:odbc:cmsdatabase";                   // URL connection
Connection con2=DriverManager.getConnection(url2);    // establish connection
Statement st2=con2.createStatement();          // create statment 
   
   if(f2==null){
   String sql2= "UPDATE customerdata SET first = '"+today+"' " + "WHERE ntn = '"+f1+"'";
   int num2=st2.executeUpdate(sql2);
   }

   String sql3= "UPDATE customerdata SET last = '"+today+"' " + "WHERE ntn = '"+f1+"'";
   int num3=st2.executeUpdate(sql3);

   String sql4= "UPDATE customerdata SET total = '"+subtotal+"' " + "WHERE ntn = '"+f1+"'";
   int num4=st2.executeUpdate(sql4);

con2.close();
response.sendRedirect("registershipment.html");
}while(rs.next());

         
     }

else{
PrintWriter out2 = response.getWriter();
out2.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>NTN # "+f1+" not found in our database .</font></p></body></html>");
out2.close();

}


con.close();


}catch(Exception sqlEx){

PrintWriter out = response.getWriter();
out.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>Database is not found.</font></p></body></html>");
out.close();
}
}


}// end FormServlet