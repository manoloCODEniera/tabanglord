package studentdb2;
import java.io.Serializable;

public class Course implements Serializable {

	private String courseCode;
	private String courseDescription;
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String toString(){
		return courseCode+"\n"+courseDescription+"\n";
	}
}
