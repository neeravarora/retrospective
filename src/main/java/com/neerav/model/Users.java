package com.neerav.model;
 
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "USERS")
public class Users {
 
    private long userid;
    private String username;
    private String password;
    private Set<WhatWentWell> whatWentWell;
 
    @Id
    @Column(name = "userid")
    @GeneratedValue
    public long getUserid() {
        return userid;
    }
 
    public void setUserid(long userid) {
		this.userid = userid;
	}
 
    public void setWhatWentWell(Set<WhatWentWell> whatWentWell) {
		this.whatWentWell = whatWentWell;
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


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<WhatWentWell> getWhatWentWell() {
        return whatWentWell;
    }
 
   
}