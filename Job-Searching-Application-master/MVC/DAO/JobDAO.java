package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.JobBean;
import Util.DBUtil;

public class JobDAO {
	
	

	public JobDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void addJob(JobBean job) {
		System.out.println("inside addJob");
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO jobs"
					+ "(employerID, title, city, address, numOfPosition, "			//1,2,3,4,5
					+ "description, qualification, postingDate, closingDate, note)" //6,7,8,9,10
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");  //10, jobID will be automatically set with next value
			pstmt.setInt(1, job.getEmployerId());
			pstmt.setString(2, job.getTitle());
			pstmt.setString(3, job.getCity());
			pstmt.setString(4, job.getAddress());
			pstmt.setInt(5, job.getNumOfPosition());
			pstmt.setString(6, job.getDescription());
			pstmt.setString(7, job.getQualification());
			pstmt.setString(8, job.getPostingDate());
			pstmt.setString(9, job.getClosingDate());
			pstmt.setString(10, job.getNote());	
			
			System.out.println(pstmt);
			pstmt.executeUpdate();
			System.out.println("added one job");	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	
	public void deleteJob(int jobID) {
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(
					"DELETE FROM jobs WHERE jobID = ?"); 
			
			pstmt.setInt(1, jobID);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	
	public void updateJob(JobBean job) {
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE jobs SET "
					+ "title=?, city=?, address=?, numOfPosition=?, "
					+ "description=?, qualification=?, postingDate=?, "
					+ "closingDate=?, note=? where jobID=?");

			pstmt.setString(1, job.getTitle());
			pstmt.setString(2, job.getCity());
			pstmt.setString(3, job.getAddress());
			pstmt.setInt(4, job.getNumOfPosition());
			pstmt.setString(5, job.getDescription());
			pstmt.setString(6, job.getQualification());
			pstmt.setString(7, job.getPostingDate());
			pstmt.setString(8, job.getClosingDate());
			pstmt.setString(9, job.getNote());
			pstmt.setInt(10, job.getJobId());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public List<JobBean> getAllJobs(){
		Connection conn = null;
		List<JobBean> jobs = new ArrayList<JobBean>();
		
		try {
			conn = DBUtil.getConnection();
			System.out.println(conn.toString());
			Statement stmt = conn.createStatement();
			ResultSet rSet = stmt.executeQuery("SELECT * FROM jobs");
			
			while(rSet.next()) { // Move the cursor to the next row, return false if no more row
				JobBean job = new JobBean();				
				job.setJobId(rSet.getInt("jobID"));
				job.setEmployerId(rSet.getInt("employerID"));
				job.setTitle(rSet.getString("title"));
				job.setCity(rSet.getString("city"));
				job.setAddress(rSet.getString("address"));
				job.setNumOfPosition(rSet.getInt("numOfPosition"));
				job.setDescription(rSet.getString("description"));
				job.setQualification(rSet.getString("qualification"));
//				job.setPostingDate(rSet.getDate("postingDate"));
//				job.setClosingDate(rSet.getDate("closingDate"));
				job.setPostingDate(rSet.getString("postingDate"));
				job.setClosingDate(rSet.getString("closingDate"));
				job.setNote(rSet.getString("note"));
				
				jobs.add(job);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return jobs;
	}
	
	public JobBean getJobById(int jobId){
		Connection conn = null;
		JobBean job = new JobBean();	
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM jobs WHERE jobID = ?");
			pStmt.setInt(1, jobId);
			ResultSet rSet = pStmt.executeQuery();	
			System.out.println("inside dao.getJobById.try");
			
			while(rSet.next()) {//if rSet has something in it
				System.out.println("inside dao.getJobById.while");
						
				job.setJobId(rSet.getInt("jobID"));
				job.setEmployerId(rSet.getInt("employerID"));
				job.setTitle(rSet.getString("title"));
				job.setCity(rSet.getString("city"));
				job.setAddress(rSet.getString("address"));
				job.setNumOfPosition(rSet.getInt("numOfPosition"));
				job.setDescription(rSet.getString("description"));
				job.setQualification(rSet.getString("qualification"));
//				job.setPostingDate(rSet.getDate("postingDate"));
//				job.setClosingDate(rSet.getDate("closingDate"));
				job.setPostingDate(rSet.getString("postingDate"));
				job.setClosingDate(rSet.getString("closingDate"));
				job.setNote(rSet.getString("note"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		System.out.println("will return job object");
		return job;
		
	}
	
	public List<JobBean> getJobByEmployerId(int EmpId){
		Connection conn = null;
		List<JobBean> jobs = new ArrayList<JobBean>();	
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM jobs WHERE employerID = ?");
			pStmt.setInt(1, EmpId);
			ResultSet rSet = pStmt.executeQuery();	
			System.out.println("inside dao.getJobById.try");
			
			while(rSet.next()) {//if rSet has something in it
				System.out.println("inside dao.getJobById.while");
				JobBean job = new JobBean();		
				job.setJobId(rSet.getInt("jobID"));
				job.setEmployerId(rSet.getInt("employerID"));
				job.setTitle(rSet.getString("title"));
				job.setCity(rSet.getString("city"));
				job.setAddress(rSet.getString("address"));
				job.setNumOfPosition(rSet.getInt("numOfPosition"));
				job.setDescription(rSet.getString("description"));
				job.setQualification(rSet.getString("qualification"));
//				job.setPostingDate(rSet.getDate("postingDate"));
//				job.setClosingDate(rSet.getDate("closingDate"));
				job.setPostingDate(rSet.getString("postingDate"));
				job.setClosingDate(rSet.getString("closingDate"));
				job.setNote(rSet.getString("note"));
				
				jobs.add(job);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		System.out.println("will return job by this particular employee");
		return jobs;
		
	}
	
	public JobBean getNewJob(int employerId){
		Connection conn = null;
		JobBean job = new JobBean();	
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM jobs WHERE jobID = (SELECT max(jobID) FROM jobs WHERE employerID = ?)");
			pStmt.setInt(1, employerId);
			ResultSet rSet = pStmt.executeQuery();	
			System.out.println("inside dao.getJobById.try");
			
			while(rSet.next()) {//if rSet has something in it
				System.out.println("inside dao.getJobById.while");
						
				job.setJobId(rSet.getInt("jobID"));
				job.setEmployerId(rSet.getInt("employerID"));
				job.setTitle(rSet.getString("title"));
				job.setCity(rSet.getString("city"));
				job.setAddress(rSet.getString("address"));
				job.setNumOfPosition(rSet.getInt("numOfPosition"));
				job.setDescription(rSet.getString("description"));
				job.setQualification(rSet.getString("qualification"));
				job.setPostingDate(rSet.getString("postingDate"));
				job.setClosingDate(rSet.getString("closingDate"));
				job.setNote(rSet.getString("note"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		System.out.println("will return NEW job object");
		
		return job;
		
	}
	
	public List<JobBean> searchJobs(String title, String city) {
		Connection conn = null;
		List<JobBean> jobs = new ArrayList<JobBean>();
		System.out.println("inside dao.searchJobs");
		
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM jobs WHERE title LIKE ? AND city=?");
			String title2 = "%" + title + "%";
			pStmt.setString(1, title2);
			pStmt.setString(2, city);
			System.out.println(pStmt);
			ResultSet rSet = pStmt.executeQuery();	
			System.out.println("inside dao.searchJobs.try");
			
			while(rSet.next()) {//if rSet has something in it
				System.out.println("inside dao.searchJobs.while");
				JobBean job = new JobBean();	
				
				job.setJobId(rSet.getInt("jobID"));
				job.setEmployerId(rSet.getInt("employerID"));
				job.setTitle(rSet.getString("title"));
				job.setCity(rSet.getString("city"));
				job.setAddress(rSet.getString("address"));
				job.setNumOfPosition(rSet.getInt("numOfPosition"));
				job.setDescription(rSet.getString("description"));
				job.setQualification(rSet.getString("qualification"));
//				job.setPostingDate(rSet.getDate("postingDate"));
//				job.setClosingDate(rSet.getDate("closingDate"));
				job.setPostingDate(rSet.getString("postingDate"));
				job.setClosingDate(rSet.getString("closingDate"));
				job.setNote(rSet.getString("note"));
				
				jobs.add(job);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return jobs;
	}
	
}
