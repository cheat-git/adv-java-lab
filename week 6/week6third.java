import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/week6third")
public class week6third extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");

        // Get the session object
        HttpSession session = req.getSession();

        // Get the current count from the session or set it to 0 if not present
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null)
        {
            visitCount = 1;
            session.setAttribute("visitCount", visitCount);
        } 
        else 
        {
            visitCount++;
            session.setAttribute("visitCount", visitCount);
        }

        // Set up the response writer
        PrintWriter out = res.getWriter();

        // Display the welcome message or the visit count
        out.println("<html><body>");
        if (visitCount == 1) 
        {
            out.println("<h2>Welcome! This is your first visit.</h2>");
        } 
        else
        {
            out.println("<h2>Welcome back! You have visited this page " + visitCount + " times.</h2>");
        }
        out.println("</body></html>");

        // Close the response writer
        out.close();
    }
}
