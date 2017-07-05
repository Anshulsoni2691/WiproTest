package org.wipro.java.bean;

import java.util.List;
/**
 * Model class for Courses.
 * @author Anshul
 *
 */
public class Courses {

	private String courseName;
	private List<Student> Student;

	public Courses() {
	}

	public Courses(String courseName, List<org.wipro.java.bean.Student> student) {
		super();
		this.courseName = courseName;
		Student = student;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List getStudent() {
		return Student;
	}

	public void setStudent(List student) {
		Student = student;
	}

}
