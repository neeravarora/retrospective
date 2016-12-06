package com.neerav.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "RITERATION")
@Entity
public class RIteration {
	
	 @Id
	 @Column(name = "iterationid")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private long iterationid;
	private Date startdate;
	private Date enddate;
	private long iter;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "ITERATION_COMMENTS", joinColumns = { @JoinColumn(name = "ITERATIONID", nullable = false, updatable = false) }, 
    inverseJoinColumns = { @JoinColumn(name = "COMMENTSID", nullable = false, updatable = false) })
	private Set <RComment> comment = new HashSet<RComment>();
	 

	public long getIterationid() {
		return iterationid;
	}
	public void setIterationid(long iterationid) {
		this.iterationid = iterationid;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public long getIter() {
		return iter;
	}
	public void setIter(long iter) {
		this.iter = iter;
	}
	
	public Set<RComment> getComment() {
		return comment;
	}
	public void setComment(HashSet<RComment> comment) {
		this.comment = comment;
	}
	
}
