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
 * @author pankaj
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

	
    public Users getUsers() {
        return user;
    }
	
	
    public Iteration getIteration() {
        return iteration;
    }
    
    public String getComment(){
    	
    	return comment;
    }
}