/**
 * 
 */
package application.model;

/**
 * @author Thierry Edson Noumessi
 * This class is the persistence entity that defines student information.
 *
 */
public class Student {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result	+ ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name
				+ ", major=" + major + ", country=" + country + "]";
	}
	
	/**
	 * Getter
	 * @return student Id
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * Setter
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**Getter
	 * @return student Name
	 */
	public String getName() {
		return name;
	}
	/**  
	 * Setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/** Getter
	 * @return major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * Setter
	 * @param major
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * Getter
	 * @return country
	 */
	public String getcountry() {
		return country;
	}
	/** Setter
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
