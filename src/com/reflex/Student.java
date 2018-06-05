package com.reflex;

import java.util.ArrayList;
import java.util.List;

public class Student {



	private String name;
	private String courseName;
	private String teaName;

	private List<String> list = new ArrayList<>();

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}



	public Student(String name, String courseName, String teaName) {
		this.name = name;
		this.courseName = courseName;
		this.teaName = teaName;
	}

	public Student(String teaName) {
		this.teaName = teaName;
	}

	public Student() {
	}

	public List<String> getList() {
		return list;
	}
}
