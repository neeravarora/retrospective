package com.neerav.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 *
 */
@Table(name="RCOMMENTS")
@Entity
public class RComment{

	@Id
	@Column(name="COMMENTID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long commentid;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TYPE")
	private String type;
	
	@ManyToMany(mappedBy="comment")
	private Set <RUsers> users = new HashSet<RUsers>();
	@ManyToMany(mappedBy="comment")
	private Set <RIteration> iteration = new HashSet<RIteration>();

	public long getCommentid() {
		return commentid;
	}

	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<RUsers> getUsers() {
		return users;
	}

	public void setUsers(Set<RUsers> users) {
		this.users = users;
	}

	public Set<RIteration> getIteration() {
		return iteration;
	}

	public void setIteration(Set<RIteration> iteration) {
		this.iteration = iteration;
	}
	
   
}