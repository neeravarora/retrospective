package com.neerav.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "ITERATION")
@Entity
public class Iteration {

	private long iterationid;
	private Date startdate;
	private Date enddate;
	private long iter;
	
	
	private Set<WhatWentWell> whatWentWell;

	 @Id
	 @Column(name = "iterationid")
	 @GeneratedValue
	public long getIterationid() {
		return iterationid;
	}


	public void setIterationid(long iterationid) {
		this.iterationid = iterationid;
	}


	public Date getStartDate() {
		return startdate;
	}


	public void setStartDate(Date startDate) {
		this.startdate = startDate;
	}


	public void setWhatWentWell(Set<WhatWentWell> whatWentWell) {
		this.whatWentWell = whatWentWell;
	}


	public Date getEndDate() {
		return enddate;
	}


	public void setEndDate(Date endDate) {
		this.enddate = endDate;
	}


	public long getIter() {
		return iter;
	}


	public void setIter(long iter) {
		this.iter = iter;
	}

	@OneToMany(mappedBy = "iteration", cascade = CascadeType.ALL)
	public Set<WhatWentWell> getWhatWentWell() {
		return whatWentWell;
	}

	
}
