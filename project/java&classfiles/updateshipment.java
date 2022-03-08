import java.io.*;
import java.net.*;
import javax.swing.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.text.DateFormat;

public class updateshipment extends HttpServlet
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

// get date from here
Date now = new Date();
DateFormat df = DateFormat.getDateInstance();
String today = df.format(now);




Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");      // Load Driver 

String url="jdbc:odbc:cmsdatabase";                   // URL connection

Connection con=DriverManager.getConnection(url);    // establish connection

Statement st=con.createStatement();          // create statment 

String f1 = req.getParameter("updateinput");

String sql="SELECT * FROM generalinfo "+"WHERE airwayno='"+f1+"' ";     // Execute Query

ResultSet rs=st.executeQuery(sql);


if(rs.next()) {


do{
String d=rs.getString("date");
String t=rs.getString("trackinfo");
String d1=rs.getString("date1");
String t1=rs.getString("trackinfo1");
String d2=rs.getString("date2");
String t2=rs.getString("trackinfo2");
String d3=rs.getString("date3");
String t3=rs.getString("trackinfo3");
String d4=rs.getString("date4");
String t4=rs.getString("trackinfo4");
String d5=rs.getString("date5");
String t5=rs.getString("trackinfo5");
String p=rs.getString("type");
String l1=rs.getString("location1");
String l2=rs.getString("location2");
String l3=rs.getString("location3");
String l4=rs.getString("location4");
String l5=rs.getString("location5");
String w1=rs.getString("weigth");
String w2=rs.getString("amount");
if(d!=null && d1==null && d2==null && d3==null && d4==null && d5==null){

PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table><table><tr><td width=100% align=left><font face=Arial size=2 color=#666666><u><i><b>Update the shipment from below </b>(after this four more updation left):</i></u></td></tr></table></body></html>");
// Other Status
out.println("<form METHOD=POST ACTION=http://localhost:8080/myapp/update1servlet Name=myForm> <table border=1 cellspacing=0 width=100% id=AutoNumber1 bordercolorlight=#C0C0C0 bordercolordark=#C0C0C0 style=border-collapse:collapse collapse bordercolor=#111111 cellpadding=3><tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Date:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Status:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Location:   </b></font></td></tr><tr><td width=33.33% ><p align=center><INPUT TYPE=string name=dateinput size=20 value=\""+today+"\" ><INPUT  type=hidden  name=f1  value="+f1+"></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=statusinput size=20></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=locationinput size=20></td></tr></table><table border=0 cellpadding=0 cellspacing=0 style=border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2><tr><td width=50%><p align=center>&nbsp;<input type=submit value=Update></td><td width=50%><p align=center><input type=reset value=Clear></td> </tr></table></form>");
// update shipment
 

out.close();
con.close();

}
else if(d!=null && d1!=null && d2==null && d3==null && d4==null && d5==null){
PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table></body></html>");
// Other Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Date:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Status:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Location:   </b></font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l1+"</font></td></tr></table><table><tr><td width=100% align=left><font face=Arial size=2 color=#666666><u><i><b>Update the shipment from below </b>(after this three more updation left):</i></u></td></tr></table>");

out.println("<form METHOD=POST ACTION=http://localhost:8080/myapp/update2servlet Name=myForm> <table border=1 cellspacing=0 width=100% id=AutoNumber1 bordercolorlight=#C0C0C0 bordercolordark=#C0C0C0 style=border-collapse:collapse collapse bordercolor=#111111 cellpadding=3><tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Date:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Status:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Location:   </b></font></td></tr><tr><td width=33.33% ><p align=center><INPUT TYPE=text name=dateinput size=20 value=\""+today+"\"><INPUT  type=hidden  name=f1  value="+f1+"></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=statusinput size=20></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=locationinput size=20></td></tr></table><table border=0 cellpadding=0 cellspacing=0 style=border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2><tr><td width=50%><p align=center>&nbsp;<input type=submit value=Update></td><td width=50%><p align=center><input type=reset value=Clear></td> </tr></table></form>");

out.close();
con.close();
}
else if(d!=null && d1!=null && d2!=null && d3==null && d4==null && d5==null){
PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table></body></html>");
// Other Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Date:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Status:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Location:   </b></font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l1+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l2+"</font></td></tr></table><table><tr><td width=100% align=left><font face=Arial size=2 color=#666666><u><i><b>Update the shipment from below </b>(after this two more updation left):</i></u></td></tr></table>");

out.println("<form METHOD=POST ACTION=http://localhost:8080/myapp/update3servlet Name=myForm> <table border=1 cellspacing=0 width=100% id=AutoNumber1 bordercolorlight=#C0C0C0 bordercolordark=#C0C0C0 style=border-collapse:collapse collapse bordercolor=#111111 cellpadding=3><tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Date:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Status:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Location:   </b></font></td></tr><tr><td width=33.33% ><p align=center><INPUT TYPE=text name=dateinput size=20 value=\""+today+"\"><INPUT  type=hidden  name=f1  value="+f1+"></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=statusinput size=20></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=locationinput size=20></td></tr></table><table border=0 cellpadding=0 cellspacing=0 style=border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2><tr><td width=50%><p align=center>&nbsp;<input type=submit value=Update></td><td width=50%><p align=center><input type=reset value=Clear></td> </tr></table></form>");
// update shipment

out.close();
con.close();
}
else if(d!=null && d1!=null && d2!=null && d3!=null && d4==null && d5==null){
PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table></body></html>");
// Other Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Date:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Status:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Location:   </b></font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l1+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l2+"</font></td></tr><tr><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+d3+"</font></td><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+t3+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l3+"</font></td></tr><table><tr><td width=100% align=left><font face=Arial size=2 color=#666666><u><i><b>Update the shipment from below </b>(after this one more updation left):</i></u></td></tr></table></table>");
out.println("<form METHOD=POST ACTION=http://localhost:8080/myapp/update4servlet Name=myForm> <table border=1 cellspacing=0 width=100% id=AutoNumber1 bordercolorlight=#C0C0C0 bordercolordark=#C0C0C0 style=border-collapse:collapse collapse bordercolor=#111111 cellpadding=3><tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Date:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Status:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Location:   </b></font></td></tr><tr><td width=33.33% ><p align=center><INPUT TYPE=text name=dateinput size=20 value=\""+today+"\"><INPUT  type=hidden  name=f1  value="+f1+"></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=statusinput size=20></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=locationinput size=20></td></tr></table><table border=0 cellpadding=0 cellspacing=0 style=border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2><tr><td width=50%><p align=center>&nbsp;<input type=submit value=Update></td><td width=50%><p align=center><input type=reset value=Clear></td> </tr></table></form>");
// update shipment


out.close();
con.close();

}
else if(d!=null && d1!=null && d2!=null && d3!=null && d4!=null && d5==null){
PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table></body></html>");
// Other Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Date:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Status:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Location:   </b></font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l1+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l2+"</font></td></tr><tr><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+d3+"</font></td><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+t3+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l3+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d4+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t4+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l4+"</font></td></tr><table><tr><td width=100% align=left><font face=Arial size=2 color=#666666><u><i><b>Update the shipment from below </b>(after this no more updation left):</i></u></td></tr></table></table>");

out.println("<form METHOD=POST ACTION=http://localhost:8080/myapp/update5servlet Name=myForm> <table border=1 cellspacing=0 width=100% id=AutoNumber1 bordercolorlight=#C0C0C0 bordercolordark=#C0C0C0 style=border-collapse:collapse collapse bordercolor=#111111 cellpadding=3><tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Date:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Status:   </b></font></tr><td width=33.33% >&nbsp;<font face=Arial size=2 color=#666666><b>Location:   </b></font></td></tr><tr><td width=33.33% ><p align=center><INPUT TYPE=text name=dateinput size=20 value=\""+today+"\"><INPUT  type=hidden  name=f1  value="+f1+"></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=statusinput size=20></tr><td width=33.33% ><p align=center><INPUT TYPE=text name=locationinput size=20></td></tr></table><table border=0 cellpadding=0 cellspacing=0 style=border-collapse: collapse bordercolor=#111111 width=100% id=AutoNumber2><tr><td width=50%><p align=center>&nbsp;<input type=submit value=Update></td><td width=50%><p align=center><input type=reset value=Clear></td> </tr></table></form>");

out.close();
con.close();
}

else if(d!=null && d1!=null && d2!=null && d3!=null && d4!=null && d5!=null){
PrintWriter out = res.getWriter();
//Tracking Online
out.println("<html><body><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3><u>Online Updating System</u> </font></b></td></tr><tr><td width=100%>&nbsp;</td></tr> <tr><td width=100%><font color=#666666 face=arial size=2>You will update shipment here step by step.</font></td></tr><tr><td width=100%>&nbsp;</td></tr><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Summary</font></b></td></tr></table></body></html>");
// 1st Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=50%><b><font face=Arial size=2 color=#666666>Tracking no:   </b></font><font face=Arial size=2 color=#666666>"+f1+"</font>&nbsp;&nbsp;</td><td width=50%><b><font face=Arial size=2 color=#666666>Booking Date:   </b></font><font face=Arial size=2 color=#666666>"+d+"</font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Type:   </b></font><font face=Arial size=2 color=#666666>"+p+"</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Picked Up at:   </b></font><font face=Arial size=2 color=#666666>"+t+" </font></td></tr><tr><td width=50%><b><font face=Arial size=2 color=#666666>Weigth:   </b></font><font face=Arial size=2 color=#666666>"+w1+" kg's</font></td><td width=50%><b><font face=Arial size=2 color=#666666>Amount:   </b></font><font face=Arial size=2 color=#666666>"+w2+" Rs</font></td></tr></table>");
//Detail 
out.println("<html><body><br><table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=100% bgcolor=#F0F0F0><b><font face=Arial color=#666666 size=3>Details </font></b></td></tr></table></body></html>");
// Other Status
out.println("<table border=0 cellspacing=1 width=100% id=AutoNumber1><tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Date:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Status:   </b></font></tr><td width=33.33% >&nbsp;<b><font face=Arial size=2 color=#666666>Location:   </b></font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t1+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l1+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t2+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l2+"</font></td></tr><tr><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+d3+"</font></td><td width=33.33%><font face=Arial size=2 color=#666666>&nbsp;"+t3+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l3+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d4+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t4+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l4+"</font></td></tr><tr><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+d5+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+t5+"</font></td><td width=33.33% ><font face=Arial size=2 color=#666666>&nbsp;"+l5+"</font></td></tr><tr><td width=50% align=left><font face=Arial size=2 color=#666666><b><i>No more updation required because shipment is delieverd.</i></b></td></tr></table>");

}
  
  }while(rs.next());

         
     }
else{
PrintWriter out2 = res.getWriter();
out2.println("<html><body><br><p align=center><font size=4 color=#686868 face=arial><b>Error Occured</b></font></p><br><p align=center><font face=arial color=#666666>You entered wrong Airway Bill no "+f1+" which is not found in our database .Please go back and enter again.</font></p></body></html>");
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