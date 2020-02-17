package xyz.ariesfish.spcache.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender;
	private Integer departmentId;

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Integer departmentId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.departmentId = departmentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", departmentId=" + departmentId +
				'}';
	}
}
