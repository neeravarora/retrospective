package com.neerav.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neerav.model.Users;
import com.neerav.model.WhatWentWell;
import com.neerav.util.HibernateUtil;



@Controller
public class LoginController {
	
	String username;
	String password;
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView processCredentials(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		String message = "Invalid credentials";
		if(!userName.equals("") && !password.equals("")) {
				this.username=username;
				this.password=password;
				message = "Welcome " + userName + "!!";
			
		}
		return new ModelAndView("home","message",message);
	}
	@RequestMapping(value="/CurrentIterationWhatWentWell",method = RequestMethod.POST)
	public ModelAndView processCredentialss() {
     	String message = "Invalid credentials";		
	
     	String hql = "from WhatWentWell p inner join p.user"
                   + " inner join p.iteration";
     	//String hql = "from WhatWentWell";
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Query query =  session.createQuery(hql);
      	List<Object[]> listResult = query.list();
      	WhatWentWell whatWentWell = new WhatWentWell();
		for (Object[] aRow : listResult) {
		    whatWentWell = (WhatWentWell) aRow[0];
		    //Users category = (Users) aRow[1];
		    //System.out.println(product.getName() + " - " + category.getName());
		}
		return new ModelAndView("CurrentIterationWhatWentWell","comment",whatWentWell);
	}
	
	
}
