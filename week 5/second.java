

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second")
public class second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String fname=req.getParameter("fname");
		String sname=req.getParameter("sname");
		String email=req.getParameter("amil");
		String dob=req.getParameter("dob");
		int birthYear=Integer.parseInt(dob.substring(0,4));
		int currentYear=java.time.Year.now().getValue();
		int currentAge=currentYear-birthYear;
		if (currentAge <= 18)
		{
			pw.println("not eligible to vote!");
		}
		else
		{
			pw.println("eligable to vote!");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
