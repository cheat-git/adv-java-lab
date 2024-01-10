

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class first extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String uname=req.getParameter("uname");
		String passwd=req.getParameter("passwd");
		   if (passwd.length() < 8)
		    {
			   pw.println("password length should be > 8");
		    }
		   else if (uname.equals("abc") && passwd.equals("12345678")) 
		   {
		        pw.println("Welcome Mr." + uname);
		    } 
		   else 
		   {
		        pw.println("Username/password is wrong. Please try again later.");
		    }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
