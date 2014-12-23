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
	private String country;
	
	public Student(int studentId, String name, String major, String country) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.country = country;
	}
	public Student(){
		this.studentId=0;
		this.country="";
		this.major="";
		this.name="";
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", major=" + major + ", country=" + country + "]";
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
	public String getcountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
