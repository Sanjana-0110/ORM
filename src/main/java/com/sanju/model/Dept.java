package com.sanju.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Dept {

	@Id
	private Integer deptNo;

	private String dName;

	private String location;

	public Dept() {

	}

	public Dept(Integer dno, String dnm, String lc) {

		this.deptNo = dno;

		this.dName = dnm;

		this.location = lc;

	}

	public Integer getDeptNo() {

		return deptNo;

	}

	public void setDeptNo(Integer dno) {

		this.deptNo = dno;

	}

	public String getDName() {

		return dName;

	}

	public void setDName(String dnm) {

		this.dName = dnm;

	}

	public String getLocation() {

		return location;

	}

	public void setJob(String lc) {

		this.location = lc;

	}

	@Override
	public String toString() {

		return "Dept{" + "Dept No=" + deptNo + ", Dept Name='" + dName + '\'' + ", Location='" + location

				+ '\'' + '}';

	}

}
