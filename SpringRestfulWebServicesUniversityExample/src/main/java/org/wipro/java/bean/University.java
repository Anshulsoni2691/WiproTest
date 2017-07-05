package org.wipro.java.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Model class for University.
 * 
 * @author Anshul
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class University {

	private String alpha_two_code;
	private String name;
	private String country;
	private String web_page;
	private String domain;

	private Courses Courses;

	public Courses getCourses() {
		return Courses;
	}

	public void setCourses(Courses courses) {
		Courses = courses;
	}

	public University() {
		super();
	}

	public University(String alpha_two_code, String name, String country, String web_page, String domain,
			org.wipro.java.bean.Courses courses) {
		super();
		this.alpha_two_code = alpha_two_code;
		this.name = name;
		this.country = country;
		this.web_page = web_page;
		this.domain = domain;
		Courses = courses;
	}

	public String getAlpha_two_code() {
		return alpha_two_code;
	}

	public void setAlpha_two_code(String alpha_two_code) {
		this.alpha_two_code = alpha_two_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWeb_page() {
		return web_page;
	}

	public void setWeb_page(String web_page) {
		this.web_page = web_page;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "University [alpha_two_code=" + alpha_two_code + ", name=" + name + ", country=" + country
				+ ", web_page=" + web_page + ", domain=" + domain + ", Courses=" + Courses + "]";
	}

}