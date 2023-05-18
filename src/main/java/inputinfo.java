
import java.sql.*;

import javax.swing.JOptionPane;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class inputinfo
 */
public class inputinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inputinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int choice = Integer.parseInt(request.getParameter("SelectList"));
		
		
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/myhospital","root","");
			    System.out.println("CONNECTED!");
			}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);  
			}   
		
		
		
		
		
		
		
		if (choice == 1)
		{
			String title = "Lab Test List";
			out.println(
		            "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#FFFFFF\">\n" +
		            "<h1 align = \"center\">" + title + "</h1>\n");
			
			try
			{
			String Query = "SELECT * FROM lablist";
			PreparedStatement s = conn.prepareStatement(Query);
			ResultSet rs = s.executeQuery();
			
			out.println("<style> table, th, td {\r\n"
            		+ "  border: 3px solid black;\r\n"
            		+ "  border-collapse: collapse;\r\n"
            		+ "background-color: #c2ffff;"
            		+ "padding: 20px;"
            		+ "} "
            		+ "table {margin: auto; margin-top: 80px;}"
            		+ "</style>");
            
            out.println("<table>"
            		+ "<tr>\r\n"
            		+ "            <th>Account Name</th>\r\n"
            		+ "            <th>Account Number</th>\r\n"
            		+ "            <th>Current Balance</th>\r\n"
            		+ "          </tr>");
            
            while (rs.next())
            {
            	
            	String name = rs.getString(1);
            	String rate = rs.getString(2);
            	String Time = rs.getString(3);
            	out.println("<tr>"
            			+ "<th> "+name+" </th>\n"
            			+ "<th>"+rate+"</th>\n"
            			+ "<th>"+Time+" </th>\n"
            			+ "</tr>");
            }
            out.println("</table>");
			
			
			}
			
			catch (Exception E)
			{
				System.out.println(E);
			}
			
		}
		else if (choice == 2)
		{
			String title = "Doctor List";
			out.println(
		            "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#FFFFFF\">\n" +
		            "<h1 align = \"center\">" + title + "</h1>\n");
			
			try
			{
				String Query = "SELECT * FROM doctor";
				PreparedStatement s = conn.prepareStatement(Query);
				ResultSet rs = s.executeQuery();
				
				out.println("<style> table, th, td {\r\n"
	            		+ "  border: 3px solid black;\r\n"
	            		+ "  border-collapse: collapse;\r\n"
	            		+ "background-color: #c2ffff;"
	            		+ "padding: 20px;"
	            		+ "} "
	            		+ "table {margin: auto; margin-top: 80px;}"
	            		+ "</style>");
	            
	            out.println("<table>"
	            		+ "<tr>\r\n"
	            		+ "            <th>Doctor ID</th>\r\n"
	            		+ "            <th>Doctor Name</th>\r\n"
	            		+ "            <th>Specialization</th>\r\n"
	            		+ "            <th>Qualification</th>\r\n"
	            		+ "            <th>Channel Fee</th>\r\n"
	            		+ "            <th>phone</th>\r\n"
	            		+ "            <th>Room id</th>\r\n"
	            		+ "          </tr>");
	            
	            while (rs.next())
	            {
	            	
	            	String id = rs.getString(1);
	            	String name = rs.getString(2);
	            	String spec = rs.getString(3);
	            	String qual = rs.getString(1);
	            	String fee = rs.getString(2);
	            	String phone = rs.getString(3);
	            	String room = rs.getString(3);
	            	out.println("<tr>"
	            			+ "<th> "+id+" </th>\n"
	            			+ "<th>"+name+"</th>\n"
	            			+ "<th>"+spec+" </th>\n"
	            			+ "<th> "+qual+" </th>\n"
	            			+ "<th>"+fee+"</th>\n"
	            			+ "<th>"+phone+" </th>\n"
	            			+ "<th>"+room+" </th>\n"
	            			+ "</tr>");
	            }
	            out.println("</table>");
				
				
			}
			
			catch (Exception E)
			{
				System.out.println(E);
			}
			
		}
		else if (choice == 3)
		{
			String title = "Lab Test List";
			out.println(
		            "<html>\n" +
		            "<head><title>" + title + "</title></head>\n" +
		            "<body bgcolor = \"#FFFFFF\">\n" +
		            "<h1 align = \"center\">" + title + "</h1>\n");
			
			try
			{
				String Query = "SELECT * FROM patient";
				PreparedStatement s = conn.prepareStatement(Query);
				ResultSet rs = s.executeQuery();
				
				out.println("<style> table, th, td {\r\n"
	            		+ "  border: 3px solid black;\r\n"
	            		+ "  border-collapse: collapse;\r\n"
	            		+ "background-color: #c2ffff;"
	            		+ "padding: 20px;"
	            		+ "} "
	            		+ "table {margin: auto; margin-top: 80px;}"
	            		+ "</style>");
	            
	            out.println("<table>"
	            		+ "<tr>\r\n"
	            		+ "            <th>Patiend Id</th>\r\n"
	            		+ "            <th>Patient Name</th>\r\n"
	            		+ "            <th>Phone Number</th>\r\n"
	            		+ "            <th>Address</th>\r\n"
	            		+ "          </tr>");
	            
	            while (rs.next())
	            {
	            	
	            	String id = rs.getString(1);
	            	String name = rs.getString(2);
	            	String phone = rs.getString(3);
	            	String add = rs.getString(3);
	            	out.println("<tr>"
	            			+ "<th> "+id+" </th>\n"
	            			+ "<th>"+name+"</th>\n"
	            			+ "<th>"+phone+" </th>\n"
	            			+ "<th>"+add+" </th>\n"
	            			+ "</tr>");
	            }
	            out.println("</table>");
				
				
			}
			
			catch (Exception E)
			{
				System.out.println(E);
			}
			
		}
		else
		{
			out.print("Enter Valid Choice");
		}
		
	}

}
