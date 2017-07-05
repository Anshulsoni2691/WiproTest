package org.wipro.java.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wipro.java.bean.University;
import org.wipro.java.service.UniversityService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * This class is controller class
 * @author anshul soni
 *
 */

@RestController
public class universityController {

	
UniversityService universityService = new UniversityService();


	
	/**
	 * This method is used to get all university list with courses and student list
	 * 
	 * @return list
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/university", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<University> getUniversity() throws JsonParseException, JsonMappingException, IOException {
		List<University> listOfUniversity = universityService.getAllUniversity();
		return listOfUniversity;
	}
	
	
	/**
	 * This method is used to add student and course in university.
	 * @param universityName
	 * @param coursesName
	 * @param studentName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addStudent(@RequestParam(value="universityName", required=true) String universityName,@RequestParam(value="studentName", required=false) String coursesName,
	        @RequestParam(value="studentName", required=false) String studentName) throws JsonParseException, JsonMappingException, IOException {
		universityService.addStudent(universityName, studentName );
	}
	
	/**
	 * This method is used to remove student and course in university.
	 * @param universityName
	 * @param studentName
	 * @param coursesName
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/removeStudent", method = RequestMethod.POST, headers = "Accept=application/json")
	public void  removeStudent(@RequestParam(value="universityName", required=true) String universityName,
	        @RequestParam(value="studentName", required=false) String studentName, @RequestParam(value="coursesName", required=false) String coursesName) throws JsonParseException, JsonMappingException, IOException {
		universityService.removeStudent(universityName, studentName,coursesName );
	}
	
}
