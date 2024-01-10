

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/week6first")
public class week6first extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
      res.setContentType("text/html");
      PrintWriter pw=res.getWriter();
      int fname=Integer.parseInt(req.getParameter("fnum"));
      int sname=Integer.parseInt(req.getParameter("snum"));
      String opt=req.getParameter("opt");
      if(opt.equals("add") )
      {
    	  pw.println("addition:"+(fname+sname));
      }
      else if(opt.equals("sub"))
      {
    	  pw.println("substrsction:"+(fname-sname));
      }
      else if(opt.equals("mul"))
      {
    	  pw.println("multiplication:"+(fname*sname));
      }
      else if(opt.equals("div"))
      {
    	  pw.println("diviosion:"+(fname/sname));
      }
      else if(opt.equals("ex"))
      {
    	  pw.println("e^x:"+(Math.exp(fname)));
      }
      else {
    	  pw.println("invalid operation type!");
      }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
