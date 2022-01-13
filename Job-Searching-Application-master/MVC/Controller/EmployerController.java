package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployerDAO;
import DAO.JobDAO;
import Model.EmployerBean;

@WebServlet("/EmployerController")
public class EmployerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployerDAO emDao = new EmployerDAO();
	private JobDAO jobDao = new JobDAO();
       
    public EmployerController() {
        super();
        emDao = new EmployerDAO();
        jobDao = new JobDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		

		if(action.equalsIgnoreCase("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username + password);
			
			try {
				EmployerBean em = emDao.getEmployer(username, password); //em contains every info about the employer
				System.out.println("The website of this company is " + em.getWebsite());
				//HttpSession session = request.getSession();
				
				int empId = em.getEmployerId();
				request.setAttribute("jobs",jobDao.getJobByEmployerId(empId));
				
				session.setAttribute("employer", em);

				
				RequestDispatcher view = request.getRequestDispatcher("EmpJobList.jsp");
				view.forward(request, response);
			}
			catch(NullPointerException e) {
				e.getMessage();
				System.out.println("NullPointerException");
			}
		}
		
		else if(action.equalsIgnoreCase("firstlogin")) {
//			String username = request.getParameter("username");
//			String password = request.getParameter("password");
//			System.out.println(username + password);
			
			try {
				EmployerBean em = (EmployerBean)session.getAttribute("employer");
				String username = em.getUsername();
				String password = em.getPassword();
				
				EmployerBean em1 = emDao.getEmployer(username, password); //em contains every info about the employer
				System.out.println("The website of this company is " + em.getWebsite());
				//HttpSession session = request.getSession();
				
				int empId = em1.getEmployerId();
				request.setAttribute("jobs",jobDao.getJobByEmployerId(empId));
				
				session.setAttribute("employer", em1);

				
				RequestDispatcher view = request.getRequestDispatcher("EmpJobList.jsp");
				view.forward(request, response);
			}
			catch(NullPointerException e) {
				e.getMessage();
				System.out.println("NullPointerException");
			}
		}
		
			else if(action.equalsIgnoreCase("afterupdate")) {
				EmployerBean em = (EmployerBean) session.getAttribute("employer");
				int empId = em.getEmployerId();
				request.setAttribute("jobs",jobDao.getJobByEmployerId(empId));
				RequestDispatcher view = request.getRequestDispatcher("EmpJobList.jsp");
				view.forward(request, response);
				
			}
		
		else if(action.equalsIgnoreCase("newAccount")) {
			RequestDispatcher view = request.getRequestDispatcher("emCreateAccount.jsp");
			view.forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("createAccount")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String eName = request.getParameter("eName");
			String address = request.getParameter("address");
			String contact = request.getParameter("contact");
			String aboutUs = request.getParameter("aboutUs");
			String website = request.getParameter("website");
			
			String error = "Username " + username + " already Exists!!" ;
			
			if(emDao.EmployerUsernameExists(username)) {
				request.setAttribute("error", error);
				RequestDispatcher view = request.getRequestDispatcher("emCreateAccount.jsp");
				view.forward(request, response);
			}
			
			else {
			
			EmployerBean em = new EmployerBean(username, password, eName, address, contact, aboutUs, website);
			emDao.addEmployer(em);
			session.setAttribute("employer", emDao.getEmployer(username, password));
			
			RequestDispatcher view = request.getRequestDispatcher("PostJob.jsp");
			view.forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("logout")){ 
			
			session.invalidate();
			response.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		doGet(request, response);
	}

}
