package com.wyu.mapping;

/**
 * CheckIn entity. @author MyEclipse Persistence Tools
 */

public class CheckIn implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer recordId;
	private String project;
	private String explain;
	private String startData;
	private String endData;
	private String approver;
	private String approverData;

	// Constructors

	/** default constructor */
	public CheckIn() {
	}

	/** full constructor */
	public CheckIn( Integer recordId, String project,
			String explain, String startData, String endData, String approver,
			String approverData) {
		this.recordId = recordId;
		this.project = project;
		this.explain = explain;
		this.startData = startData;
		this.endData = endData;
		this.approver = approver;
		this.approverData = approverData;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getExplain() {
		return this.explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getStartData() {
		return this.startData;
	}

	public void setStartData(String startData) {
		this.startData = startData;
	}

	public String getEndData() {
		return this.endData;
	}

	public void setEndData(String endData) {
		this.endData = endData;
	}

	public String getApprover() {
		return this.approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApproverData() {
		return this.approverData;
	}

	public void setApproverData(String approverData) {
		this.approverData = approverData;
	}

}