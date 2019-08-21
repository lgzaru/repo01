package fileupload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Redirect
 */
@WebServlet(name = "MyRedirect", urlPatterns = { "/MyRedirect" })
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String fileName = request.getParameter("fileName");
		String clientid = request.getParameter("client_id");
		System.out.println("clientid is:"+clientid);
		String projectname = request.getParameter("projectname");
		String summary = request.getParameter("summary");
		String datereceived = request.getParameter("datereceived");
		
		HttpSession session = request.getSession(true); 
		//session.setAttribute("fileName1", fileName);
		session.setAttribute("clientid1", clientid);
		session.setAttribute("projectname1", projectname);
		session.setAttribute("summary1",summary);
		session.setAttribute("datereceived1", datereceived);
		
		RequestDispatcher rd = request.getRequestDispatcher("uploadfile.jsp");
		rd.include(request, response);
		
		
	}

}
