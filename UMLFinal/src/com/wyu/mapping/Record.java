package com.wyu.mapping;

/**
 * Record entity. @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private String birthday;
	private String idCard;
	private String nation;
	private String nativePlace;
	private String marriage;
	private String politicsStatus;
	private String educationBackground;
	private String major;
	private String department;
	private String duty;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record( String name, String sex, String birthday,
			String idCard, String nation, String nativePlace, String marriage,
			String politicsStatus, String educationBackground, String major,
			String department, String duty) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.idCard = idCard;
		this.nation = nation;
		this.nativePlace = nativePlace;
		this.marriage = marriage;
		this.politicsStatus = politicsStatus;
		this.educationBackground = educationBackground;
		this.major = major;
		this.department = department;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getPoliticsStatus() {
		return this.politicsStatus;
	}

	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}

	public String getEducationBackground() {
		return this.educationBackground;
	}

	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

}