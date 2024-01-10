

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class third extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/htnl");
	PrintWriter pw=res.getWriter();
	String usn=req.getParameter("usn");
	String name=req.getParameter("name");
	double sgpa1=Double.parseDouble(req.getParameter("sgpa1"));
	double sgpa2=Double.parseDouble(req.getParameter("sgpa2"));
	Double cgpa=(sgpa1+sgpa2)/2;
	pw.println("cgpa is:"+cgpa);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
