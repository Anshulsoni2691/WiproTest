package org.wipro.java.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.web.client.RestTemplate;
import org.wipro.java.bean.Courses;
import org.wipro.java.bean.Student;
import org.wipro.java.bean.University;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UniversityService {

	static List<University> universityList;
	static HashMap<String, University> UniversityIdMap;
	List<Student> studentList = new ArrayList<Student>();

	/**
	 * Constructor
	 */
	public UniversityService() {
		super();

		if (UniversityIdMap == null || universityList == null) {
			try {
				universityList = getUniversity();

			} catch (Exception e) {
			}

		}

	}

	/**
	 * This mehod is used to get list of university
	 * 
	 * @return university list
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<University> getAllUniversity() throws JsonParseException, JsonMappingException, IOException {

		List<University> allUniversityList = universityList;

		return allUniversityList;
	}

	/**
	 * This method is used to add course/student in university
	 * 
	 * @param universityName
	 * @param studentName
	 * @param coursesName 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void addStudent(String universityName, String studentName, String coursesName)
			throws JsonParseException, JsonMappingException, IOException {
		University universityTemp = new University();
		List<University> universityListtemp = getAllUniversity();

		Iterator<University> iter = universityListtemp.iterator();

		while (iter.hasNext()) {
			universityTemp = iter.next();
			if (universityTemp.getName().equalsIgnoreCase(universityName)) {
				Student student = new Student();
				student.setName(studentName);
				student.setRollNumber((int) (Math.random()* 50 + 1));
				Courses courses = new Courses();
				courses.setCourseName(coursesName);
				studentList.add(student);
				courses.setStudent(studentList);
				universityTemp.setCourses(courses);
			}
		}
		universityList.remove(universityTemp);
		universityList.add(universityTemp);

	}

	/**
	 * 
	 * This method is used to remove Course/Student from university list
	 * 
	 * @param universityName
	 * @param studentName
	 * @param courseName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */

	public void removeStudent(String universityName, String studentName, String courseName)
			throws JsonParseException, JsonMappingException, IOException {
		University universityTemp = new University();
		Student studentTemp = new Student();
		List<University> universityListtemp = getAllUniversity();

		Iterator<University> iter = universityListtemp.iterator();

		while (iter.hasNext()) {
			universityTemp = iter.next();

			if (universityTemp.getName().equalsIgnoreCase(universityName)
					&& (universityTemp.getCourses().getCourseName().equalsIgnoreCase(courseName))) {

				List<Student> studentList = universityTemp.getCourses().getStudent();

				Iterator<Student> studentiter = studentList.iterator();
				while (studentiter.hasNext()) {
					studentTemp = studentiter.next();
					if (studentTemp.getName().equalsIgnoreCase(studentName)) {
						studentList.remove(studentTemp);
					}
				}

			}
		}
	}

	/**
	 * This method is used to call rest service to populate university list
	 * 
	 * @return list
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static List<University> getUniversity() throws JsonParseException, JsonMappingException, IOException {
		final String uri = "http://universities.hipolabs.com/search?name=middle";

		ObjectMapper objectMapper = new ObjectMapper();
		// Set pretty printing of json
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		TypeReference<List<University>> mapType = new TypeReference<List<University>>() {
		};
		List<University> jsonToPersonList = objectMapper.readValue(result, mapType);
		return jsonToPersonList;
	}

}
