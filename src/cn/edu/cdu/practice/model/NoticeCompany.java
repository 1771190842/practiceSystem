package cn.edu.cdu.practice.model;

import java.sql.Timestamp;
/**
 * @Copyright (C), 2017, 成都大学信息科学与工程学院JavaWeb教材编写组.
 * @FileName Company.java
 * @version 1.0
 * @Description: model层，与数据表对应的实体类
 * @Author 于曦
 * @Date： 2017-4-15:上午15:04:04
 * Modification User： 程序修改时由修改人员编写
 * Modification Date： 程序修改时间
 */

public class NoticeCompany implements java.io.Serializable {

	// Fields

	private Integer id;
	private String companyUsername;
	private Timestamp releaseDate;
	private Timestamp auditDate;
	private String content;

	// Constructors

	/** default constructor */
	public NoticeCompany() {
	}

	/** minimal constructor */
	public NoticeCompany(String companyUsername, Timestamp releaseDate,
			String content) {
		this.companyUsername = companyUsername;
		this.releaseDate = releaseDate;
		this.content = content;
	}

	/** full constructor */
	public NoticeCompany(String companyUsername, Timestamp releaseDate,
			Timestamp auditDate, String content) {
		this.companyUsername = companyUsername;
		this.releaseDate = releaseDate;
		this.auditDate = auditDate;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyUsername() {
		return this.companyUsername;
	}

	public void setCompanyUsername(String companyUsername) {
		this.companyUsername = companyUsername;
	}

	public Timestamp getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}