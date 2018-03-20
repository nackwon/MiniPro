package com.jimmy.project01;

public class Person {

	private String name;
	private String phone;
	private String company;

	public Person() {

	}

	public Person(String name, String phone, String company) {
		this.name = name;
		this.phone = phone;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void showInfo() {
		System.out.println(name + " " + phone + " " + company);
	}
}
