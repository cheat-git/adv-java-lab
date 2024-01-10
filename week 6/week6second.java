import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/week6second")
public class week6second extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        Cookie ck1=new Cookie("cookie1","1");
        ck1.setMaxAge(60);
        Cookie ck2=new Cookie("Cookie2","2");
        ck2.setMaxAge(60);
        Cookie ck3=new Cookie("cookie3","3");
        Cookie ck4=new Cookie("cookie4","4");
        
        res.addCookie(ck1);
        res.addCookie(ck2);
        res.addCookie(ck3);
        res.addCookie(ck4);
        Cookie cks[]=req.getCookies();
       if(cks != null)
       {
    	   for(int i=0; i< cks.length;i++)
    	   {
    		   pw.println(cks[i].getName()+":"+cks[i].getValue()+"<br>");
    	   }
       }
       else
       {
    	   pw.println("cookies not found");
       }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
