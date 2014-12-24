/**
 * 
 */
package application.model;

/**
 * @author root
 *
 */
public class Student {
	private String studentId;
	private String name;
	private String major;
	private String country;
	
	public Student(String studentId, String name, String major, String country) {
		super() ;
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.country = country;
	}
	public Student(){
		this.studentId="";
		this.country="";
		this.major="";
		this.name="";
	}
	public Student(Student s){
		this.studentId=s.studentId;
		this.country=s.country;
		this.major=s.major;
		this.name=s.name;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", major=" + major + ", country=" + country + "]";
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
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
	public String getcountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
