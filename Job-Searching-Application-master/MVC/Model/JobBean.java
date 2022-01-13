package Model;

import java.io.Serializable;
import java.util.Date;

public class JobBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int jobId;
	private int employerId;
	private String title;
	private String city; // Mississauga, Brampton, Oakville, Toronto **Enum class?
	private String address;
	private int	numOfPosition;
	private String description;
	private String qualification;
	private String postingDate;
	private String closingDate;
	private String note;
	
	public JobBean() {
		// TODO Auto-generated constructor stub
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}	
	
	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumOfPosition() {
		return numOfPosition;
	}

	public void setNumOfPosition(int numOfPosition) {
		this.numOfPosition = numOfPosition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "JobBean [jobId=" + jobId + ", employerId=" + employerId + ", title=" + title + ", city=" + city
				+ ", address=" + address + ", numOfPosition=" + numOfPosition + ", description=" + description
				+ ", qualification=" + qualification + ", postingDate=" + postingDate + ", closingDate=" + closingDate
				+ ", note=" + note + "]";
	}

}
