package com.freethinker.AccountManagement.Model;

import javax.persistence.*;

@Entity
@Table(name="account_tb")
public class Account {
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name="supervisor_id")
	private Integer supervisorId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="middlename")
	private String middleName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="jobtitle")
	private String jobTitle;
	
	@Column(name="immediatesupervisor")
	private String immediateSuperVisor;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pswrd")
	private String password;
	
	
	
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getImmediateSuperVisor() {
		return immediateSuperVisor;
	}
	public void setImmediateSuperVisor(String immediateSuperVisor) {
		this.immediateSuperVisor = immediateSuperVisor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void copy(Account anotherAccount) {
		
		if(anotherAccount.getAccountId() != null)
			this.accountId = anotherAccount.getAccountId();
		
		if(anotherAccount.getSupervisorId() != null)
			this.supervisorId = anotherAccount.getSupervisorId();
		
		if(anotherAccount.getFirstName() != null)
			this.firstName = anotherAccount.getFirstName();
		
		if(anotherAccount.getLastName() != null)
			this.lastName = anotherAccount.getLastName();
		
		if(anotherAccount.getMiddleName() != null)
			this.middleName = anotherAccount.getMiddleName();
		
		if(anotherAccount.getImmediateSuperVisor() != null)
			this.immediateSuperVisor = anotherAccount.getImmediateSuperVisor();
		
		if(anotherAccount.getDepartment() != null)
			this.department = anotherAccount.getDepartment();
		
		if(anotherAccount.getJobTitle() != null)
			this.jobTitle = anotherAccount.getJobTitle();
		
		if(anotherAccount.getUsername() != null)
			this.username = anotherAccount.getUsername();
		
		if(anotherAccount.getPassword() != null)
			this.password = anotherAccount.getPassword();
	}
	
}
