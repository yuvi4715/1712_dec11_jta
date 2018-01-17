package com.revature.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 7570906930843536924L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqname")
	@SequenceGenerator(name="seqname", sequenceName="emp_seq_name", initialValue=1,allocationSize=1)
	@Column(name="EMP_ID", nullable=false)
	private int empId;
	
	@Column(name="EMP_NAME", length=40)
	private String empName;
	
	@Column(name="CREATEDBY", length=0)
	private String createdBy;
	
	@Column(name="CREATEDDATE", length=10)
	private Date createdDate;
	
	public Employee() {
		super();
	}

	
	public Employee(String empName, String createdBy, Date createdDate) {
		super();
		this.empName = empName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}


	public Employee(int empId, String empName, String createdBy, Date createdDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + "]";
	}

	
}
