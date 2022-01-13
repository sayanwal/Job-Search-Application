package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import Model.EmployerBean;
import Model.JobBean;
import DAO.EmployerDAO;
import DAO.JobDAO;

@WebServlet("/JobController")
public class JobController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JobDAO dao = new JobDAO();
	private EmployerDAO emdao = new EmployerDAO();
	
    public JobController() {
        super();
        dao = new JobDAO();
        emdao = new EmployerDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
//		JobBean job = new JobBean();
		
		if(action.equals("post")) {
			JobBean job = new JobBean();
			
			String title = request.getParameter("title");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			int numOfPosition = Integer.parseInt(request.getParameter("numOfPosition"));
			String description = request.getParameter("description");
			String qualification = request.getParameter("qualification");
			String note = request.getParameter("note");
			String postingDate = request.getParameter("postingdate");
			String closingDate = request.getParameter("closingdate");
			
			EmployerBean em = (EmployerBean)session.getAttribute("employer");
			int employerId = em.getEmployerId();

			job.setEmployerId(employerId);
			job.setTitle(title);
			job.setCity(city);
			job.setAddress(address);
			job.setNumOfPosition(numOfPosition);
			job.setDescription(description);
			job.setQualification(qualification);
			job.setNote(note);
			job.setPostingDate(postingDate);
			job.setClosingDate(closingDate);
			
			System.out.println("This job is ");
			job.toString();
			
			dao.addJob(job); // update the table
			JobBean newjob = dao.getNewJob(employerId);
			System.out.println("New job id is #" + newjob.getJobId());
			
			request.setAttribute("jobdetail", dao.getJobById(newjob.getJobId())); //send the job object we just created
//			request.setAttribute("eName", eName);
			
			RequestDispatcher view = request.getRequestDispatcher("JobDetail.jsp");
			view.forward(request, response);
			
		}	
		else if(action.equalsIgnoreCase("update")) {
			JobBean job = new JobBean();
			
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			String title = request.getParameter("title");
			String city = request.getParameter("city");
			String address = request.getParameter("address");
			int numOfPosition = Integer.parseInt(request.getParameter("numOfPosition"));
			String description = request.getParameter("description");
			String qualification = request.getParameter("qualification");
			String note = request.getParameter("note");
			String postingDate = request.getParameter("postingdate");
			String closingDate = request.getParameter("closingdate");
			
			EmployerBean em = (EmployerBean)session.getAttribute("employer");
			int employerId = em.getEmployerId();
			job.setJobId(jobId);
			job.setEmployerId(employerId);
			job.setTitle(title);
			job.setCity(city);
			job.setAddress(address);
			job.setNumOfPosition(numOfPosition);
			job.setDescription(description);
			job.setQualification(qualification);
			job.setNote(note);
			job.setPostingDate(postingDate);
			job.setClosingDate(closingDate);
			
			System.out.println("This job is ");
			job.toString();
			
			dao.updateJob(job);
			System.out.print("updated job bean in table");// update the table
			request.setAttribute("jobdetail", dao.getJobById(jobId));
			System.out.println("Updated Job is: " + dao.getJobById(jobId));
			RequestDispatcher view = request.getRequestDispatcher("UpdatedJob.jsp");
			view.forward(request, response);
			
		}
		
		else if(action.equalsIgnoreCase("delete")) {
			
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			
			JobBean job = new JobBean();
			job = dao.getJobById(jobId);
			
			EmployerBean em = new EmployerBean();
			em = emdao.getEmployer1(jobId);
			System.out.println("Company name: " + em.getEName());
			
			request.setAttribute("jobdetail", job);
			request.setAttribute("employer", em);
			
			RequestDispatcher view = request.getRequestDispatcher("DeleteConfirm.jsp");
			view.forward(request, response);
			
		}
		
		else if(action.equalsIgnoreCase("deleteconfirmed")) {
			
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			dao.deleteJob(jobId);
			System.out.println("jobDeleted:");
			response.sendRedirect("EmployerController?action=afterupdate");
		}
		
		else if(action.equals("search")) 
		{
			//Get job title and city
			String title = request.getParameter("title");
			String city = request.getParameter("city");
			
			//Search jobs based on user's input(job title, city)
			request.setAttribute("jobs", dao.searchJobs(title, city));
			
			RequestDispatcher view = request.getRequestDispatcher("JobList.jsp");
			view.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("detail")) // more actions should be added later: delete, edit
		{ 
			System.out.println("JobController: action = detail");
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			
			JobBean job = new JobBean();
			job = dao.getJobById(jobId);
			
			EmployerBean em = new EmployerBean();
			em = emdao.getEmployer1(jobId);
			System.out.println("Company name: " + em.getEName());
			
			request.setAttribute("jobdetail", job);
			session.setAttribute("employer", em);
			//request.setAttribute("eName", em.getEName());
			
			RequestDispatcher view = request.getRequestDispatcher("EmployeeJobDetail.jsp");
			view.forward(request, response);
			
		}else if(action.equalsIgnoreCase("allJobs")) {
			System.out.println("JobController: action = allJobs");
			
			//get all jobs
			request.setAttribute("jobs", dao.getAllJobs());
			
			RequestDispatcher view = request.getRequestDispatcher("JobList.jsp");
			view.forward(request, response);
		}
		
		else if(action.equalsIgnoreCase("edit")) {
			int jobId = (Integer.parseInt(request.getParameter("jobId")));
			JobBean jobBean = dao.getJobById(jobId);
			System.out.println(jobBean.toString());
			request.setAttribute("job", jobBean);
			System.out.print("jobId:" + jobBean.getJobId());
			RequestDispatcher rd = request.getRequestDispatcher("UpdateJob.jsp");
			rd.forward(request, response);
			
			//dao.updateJob(jobBean);
			System.out.println("jobBean Updated:");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
