//package src.main.javaSpringMVC.com.SpringMVC.controller;
package com.SpringMVC.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld-processForm";
	}
	
	@RequestMapping("/processFormCapitalLetter")
	public String processFormCapitalLetter(HttpServletRequest request, Model model) {
		
		// Using the Objects.requireNonNull in Private Method checkNotNull
		// to check if a value is null
		// as recommended by one of StackOverflow's answer
//		if(request.equals(null) == true) {
//			logger.error("The HTTP Servlet Request is null");
//		}
		
		checkNotNull(request);
		
		/* Read the request parameter from the HTML form,
		 * the NAME attribute of the INPUT tag. Try uncommenting the following
		 * statement to see how it returns null when wrong Parameter name
		 * is passed to the getParameter method
		*/
//		String theName = request.getParameter("userNameText");
		String theName = request.getParameter("usernameText");
		/*
		Give the error in the log instead of catching the NullPointerException
		if theName variable is null, so that there is NullPointerException at runtime.
		Using the following advice from Oracle tutorial:
		https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
		Here's the bottom line guideline: If a client can reasonably be expected to recover 
		from an exception, make it a checked exception. 
		If a client cannot do anything to recover from the exception, 
		make it an unchecked exception. 
		*/
		if(theName instanceof String == false) {
			logger.error( "Parameter does not exist");
		}
		
		theName = theName.toUpperCase();
		
		String result = "Waheguru Ji Ka Khalsa !! Waheguru Ji KI Fateh " + theName;
		
		model.addAttribute("message", result);
		
		return "helloWorld-processFormCapitalLetter";
	}
	
	private Object checkNotNull(Object obj) {
		return obj = Objects.requireNonNull(obj, obj+"must not be null");
	}
}
