package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class loginServlet
 */

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		ServletConfig config=getServletConfig();
		try {	
		// get servlet init params
		String URL=config.getInitParameter("db_url");
		String user_name=config.getInitParameter("user_name");
		String pass=config.getInitParameter("password");		
		// create dao instances
		userDao=new UserDaoImpl(URL, user_name, pass);
		candidateDao=new CandidateDaoImpl(URL, user_name, pass);
		}catch(Exception e){
			throw new ServletException("Error in init of "+getClass(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
		} catch (SQLException e) {
			System.out.println("error in destroy of "+getClass()+" "+e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set response type
		response.setContentType("text/html");
		//get pw
		try(PrintWriter pw=response.getWriter()){
			//get req params sent from client
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			//invoke dao for authentication
			User user=userDao.authenticateUser(email, password);
			if(user==null)
				pw.print("<h3>invalid email or password,please <a href='login.html'> retry </a></h3>");
			else {   // =>success
				//get httpsession
				HttpSession hs=request.getSession(); 
				System.out.println("is new "+hs.isNew());
				System.out.println("session id "+hs.getId());
				
				hs.setAttribute("user_details", user);
				hs.setAttribute("user_dao", userDao);
				hs.setAttribute("candidate_dao", candidateDao);
				// role based authorization
				if(user.getRole().equals("admin")) {
					//redirect client to admin page
					response.sendRedirect("admin_page");
				}else //voter
				if(user.isVotingStatus()) {
					//already voted redirect to logout
					response.sendRedirect("logout");
				}else {
					//not voted redirect to candidate list page
					response.sendRedirect("candidate_list");
				}
			}	
		} catch (SQLException e) {
			throw new ServletException("Error in doPost of "+getClass(),e);
		}
		
	}

}
