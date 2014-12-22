/**
 * 
 */
package application.model;

/**
 * @author root
 *
 */
public class Student {
	private int studentId;
	private String name;
	private String major;
	private String status;
	
	public Student(int studentId, String name, String major, String status) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.status = status;
	}
	public Student(){
		this.studentId=0;
		this.status="";
		this.major="";
		this.name="";
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", major=" + major + ", status=" + status + "]";
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
