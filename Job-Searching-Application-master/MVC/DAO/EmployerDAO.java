package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.EmployerBean;
import Model.JobBean;
import Util.DBUtil;

public class EmployerDAO {

	public EmployerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void addEmployer(EmployerBean employer) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();

			String sql = "INSERT INTO employers (eName, address, contact, aboutUs, website, username, password)"
					+ "VALUES(?,?,?,?,?,?,?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, employer.getEName());
			pStmt.setString(2, employer.getAddress());
			pStmt.setString(3, employer.getContact());
			pStmt.setString(4, employer.getAboutUs());
			pStmt.setString(5, employer.getWebsite());
			pStmt.setString(6, employer.getUsername());
			pStmt.setString(7, employer.getPassword());
			
			pStmt.executeUpdate();
			
			if(pStmt.executeUpdate() != 0) {
				System.out.println("new employer is added");
			}else {
				System.out.println("adding employer is failed");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public EmployerBean getEmployer(String username, String password) {
	
		System.out.println("method: getEmployer using username and password");
		Connection conn = null;
		EmployerBean em = new EmployerBean();
		
		
		try {
			System.out.println("DAO getconnect");
			conn = DBUtil.getConnection();
			System.out.println("DAO finish connect");
			String sql = "SELECT * FROM employers WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			//pstmt.setString(2, password);
			
			ResultSet rSet = pstmt.executeQuery();
			
			System.out.println("inside try");
			
			while(rSet.next()) { //if the employer exists				
				System.out.println("inside while");
				
				em.setEmployerId(rSet.getInt("employerID"));
				em.setEName(rSet.getString("eName"));
				em.setAboutUs(rSet.getString("aboutUs"));
				em.setAddress(rSet.getString("address"));
				em.setContact(rSet.getString("contact"));
				em.setWebsite(rSet.getString("website"));
				em.setPassword(rSet.getString("password"));
				em.setUsername(rSet.getString("username"));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		
		return em;
	}
	
	public boolean EmployerUsernameExists(String username) {
		
		System.out.println("method: getEmployer using username and password");
		Connection conn = null;
		EmployerBean em = new EmployerBean();
		
		try {
			System.out.println("DAO getconnect");
			conn = DBUtil.getConnection();
			System.out.println("DAO finish connect");
			String sql = "SELECT * FROM employers WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rSet = pstmt.executeQuery();
			
			System.out.println("inside try");
			
			if(rSet.next()) { //if the employer exists				
				System.out.println("employer UserName Already Exists!!!");
				return true;
				
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		
		return false;	

	}
	
	public EmployerBean getEmployer1(int jobId) {
		System.out.println("method: getEmployer using jobId");
		Connection conn = null;
		EmployerBean em = new EmployerBean();
		
		try {
			System.out.println("DAO getconnect");
			conn = DBUtil.getConnection();
			System.out.println("DAO finish connect");
			
			//get an employer using jobId
			String sql = "SELECT * FROM employers WHERE employerID = (SELECT employerID FROM jobs WHERE jobID = ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jobId);		
			System.out.println(pstmt);
			ResultSet rSet = pstmt.executeQuery(); //will hold one employer
			
			System.out.println("inside try");
			
			if(rSet.next()) { //if the job exists				
				System.out.println("inside while");
					em.setEmployerId(rSet.getInt("employerID"));
					em.setEName(rSet.getString("eName"));
					em.setAboutUs(rSet.getString("aboutUs"));
					em.setAddress(rSet.getString("address"));
					em.setContact(rSet.getString("contact"));
					em.setWebsite(rSet.getString("website"));
					em.setPassword(rSet.getString("password"));
					em.setUsername(rSet.getString("username"));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return em;
	}
	
	
	public EmployerBean getEmployer2(int employerId) {
		System.out.println("method: getEmployer using employerId");
		Connection conn = null;
		EmployerBean em = new EmployerBean();
		
		try {
			System.out.println("DAO getconnect");
			conn = DBUtil.getConnection();
			System.out.println("DAO finish connect");
			
			//get an employer using jobId
			String sql = "SELECT * FROM employers WHERE emplyerID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employerId);			
			ResultSet rSet = pstmt.executeQuery(); //will hold one employer
			
			System.out.println("inside try");
			
			if(rSet.next()) { //if the job exists				
				System.out.println("inside while");
					em.setEmployerId(rSet.getInt("employerID"));
					em.setEName(rSet.getString("eName"));
					em.setAboutUs(rSet.getString("aboutUs"));
					em.setAddress(rSet.getString("address"));
					em.setContact(rSet.getString("contact"));
					em.setWebsite(rSet.getString("website"));
					em.setPassword(rSet.getString("password"));
					em.setUsername(rSet.getString("username"));
			}	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection(conn);
		}
		return em;
	}
	
	
	public List<EmployerBean> getAllEmployers(){
		Connection conn = null;
		List<EmployerBean> employers = new ArrayList<EmployerBean>();
		
		try {
			conn = DBUtil.getConnection();
			
			String query = "SELECT * FROM employers";
			Statement stmt = conn.createStatement();
			
			if(stmt==null) {
				System.out.println("createStatement error");
			}
			else {
//				Statement stmt = conn.createStatement();
				if(stmt.executeQuery(query) == null) {
					System.out.println("There is no results");
				}
				else {
					ResultSet rSet = stmt.executeQuery(query);
					while(rSet.next()) {
						EmployerBean em = new EmployerBean();
						em.setUsername(rSet.getString("username"));
						
						employers.add(em);
					}
				}
			}
			
//			ResultSet rSet = stmt.executeQuery(query);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);	
		}
		return employers;
	}
	
}
