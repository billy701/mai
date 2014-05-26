package com.wyu.mapping;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String salary;
	
	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	private String duty;

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** full constructor */
	public Staff(String name, String password, String salary,String duty) {
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.duty = duty;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}