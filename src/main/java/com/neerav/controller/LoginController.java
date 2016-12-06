package com.neerav.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neerav.model.Iteration;
import com.neerav.model.RComment;
import com.neerav.model.RUsers;
import com.neerav.model.Users;
import com.neerav.model.WhatWentWell;
import com.neerav.util.HibernateUtil;



@Controller
public class LoginController {
	
	String username;
	String password;
	long userid;
	long iterationid;
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static final Logger logger = Logger.getLogger(LoginController.class);

	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		String message = "Invalid credentials";
		if(!userName.equals("") && !password.equals("")) {
				this.username=userName;
				this.password=password;
				
				message = "Welcome " + userName + "!!";
			
		}
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		return new ModelAndView("home","message",message);
	}
	@RequestMapping(value="/CurrentIterationWhatWentWell",method = RequestMethod.POST)
	public ModelAndView retrieveCurrentIterationWhatWentWellComment() {
     	String message = "Invalid credentials";		
	
     	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
     	Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   
		System.out.println(dateFormat.format(date));
		this.iterationid = getIterationId(date);
		this.userid=getUserId();
		
     	//String hql = "from Rusers u join uhere p.user =:userid";
                  
     	//String hql = "from WhatWentWell";
     	
		RUsers user = (RUsers) session.get(RUsers.class, this.userid);
		Set<RComment> comments = user.getComment();

		
		//org.hibernate.Query query =  session.createQuery(hql);
		//query.setLong("userid",this.userid);
		//query.setLong("iterationid", this.iterationid);
//      	List<Object[]> listResult = query.list();
//      	WhatWentWell whatWentWell = new WhatWentWell();
//		for (Object[] aRow : listResult) {
//		    whatWentWell = (WhatWentWell) aRow[0];
//		    //Users category = (Users) aRow[1];
//		    //System.out.println(product.getName() + " - " + category.getName());
//		}
		return null;
		//return new ModelAndView("CurrentIterationWhatWentWell","comment",whatWentWell);
	}
	
	public long getUserId()
	{
		String hql = "select userid from RUsers where username = :username and password = :password ";
     	
     	 
     	org.hibernate.Query query = session.createQuery(hql);
     	query.setParameter("username",username);
     	query.setParameter("password",password);
     	List results = query.list();
     	
     	
     	return (long) results.get(0);
	}
	
	public long getIterationId(Date date)
	{
		String hql = "select iterationid from RIteration where startdate <=:date and enddate >=:date ";
     	
     	 
     	org.hibernate.Query query = session.createQuery(hql);
     	query.setParameter("date",date);
     	List results = query.list();
     	
     	
     	return (long) results.get(0);
	}
	
	@ResponseBody 
	@RequestMapping(value="/UpdateCurrentIterationWhatWentWell",method = RequestMethod.POST)
	 public String updateCurrentIterationWhatWentWellComment(@RequestParam("comment")String updatedComment) {
     	

		   DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		   //get current date time with Date()
		   Date date = new Date();
		   System.out.println(dateFormat.format(date));
		   
		System.out.println(dateFormat.format(date));
     	this.iterationid = getIterationId(date);
     	this.userid=getUserId();
         
        String hql = "update WhatWentWell set comment = :comment where user.userid = :userId and iteration.iterationid = :iterationId";
     	org.hibernate.Query  query = session.createQuery(hql);
     	query.setParameter("comment",updatedComment);
     	
     	
     	query.setParameter("iterationId",this.iterationid);
     	query.setParameter("userId", userid);
     	
     	 
     	int rowsAffected = query.executeUpdate();
     	if (rowsAffected > 0) {
     	    System.out.println("Updated " + rowsAffected + " rows.");
     	}
     	else
     	{
     		WhatWentWell whatWentWellObj=new WhatWentWell();
     		whatWentWellObj.setComment(updatedComment);
     		Iteration iterationObj = new Iteration();
     		iterationObj.setIterationid(this.iterationid);
     		whatWentWellObj.setIteration(iterationObj);
     		whatWentWellObj.setComment(updatedComment);
     		// to do code a logic to generate unique id 
     		whatWentWellObj.setWhatWentWellId(new Long(3));
     		Users user = new Users();
     		user.setUserid(this.userid);
     		whatWentWellObj.setUser(user);
     		
     		
     		
     		session.save(whatWentWellObj);
            session.getTransaction().commit();
     	    session.close();
     	    return "comment successfully inserted.";
     	}
        Transaction tx=session.beginTransaction();
        tx.commit();
          session.close();
		return "comment successfully updated...";
	}
	
	
}
