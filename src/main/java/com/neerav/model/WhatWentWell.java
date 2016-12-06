package com.neerav.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 *
 */
@Table(name="WHATWENTWELL")
@Entity
public class WhatWentWell {

	@Id
	@Column(name="whatwentwellid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long whatWentWellId;
	
	@ManyToOne
    @JoinColumn(name = "userid")
	private Users user;
	
	@ManyToOne
    @JoinColumn(name = "iterationid")
	private Iteration iteration;
	
	@Column(name="comm")
	private String comment;

	
  
	
	
    public long getWhatWentWellId() {
		return whatWentWellId;
	}


	public void setWhatWentWellId(long whatWentWellId) {
		this.whatWentWellId = whatWentWellId;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public void setIteration(Iteration iteration) {
		this.iteration = iteration;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Iteration getIteration() {
        return iteration;
    }
    
    public String getComment(){
    	return comment;
    }
}