package com.neerav.model;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

 
@Entity
@Table(name = "RUSER")
public class RUsers {
	@Id
    @Column(name = "USERID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userid;
	@Column(name = "USERNAME")
    private String username;
	@Column(name = "PASSWORD")
    private String password;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "USER_COMMENTS", joinColumns = { @JoinColumn(name = "USERID") }, 
    inverseJoinColumns = { @JoinColumn(name = "COMMENTID") })
    private Set <RComment> comment ;
 
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
	
	
	public Set<RComment> getComment() {
		return comment;
	}

	public void setComment(Set<RComment> comment) {
		this.comment = comment;
	}

	
    public long getUserid() {
        return userid;
    }
	
    public void setUserid(long userid) {
		this.userid = userid;
	}
 
   
 
   
}