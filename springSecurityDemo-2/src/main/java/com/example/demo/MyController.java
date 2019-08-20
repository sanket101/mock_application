package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Register;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin(origins="http://localhost:8882")
@RestController
@RequestMapping("/api/v1")
public class MyController{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	//
	@GetMapping(value="/sendmail/{uid}", produces= {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public Object sendingEmail(@PathVariable("uid") String userid) {
		int id = Integer.parseInt(userid);
		//System.out.println(userid);
	
    	Register e = employeeService.findById(id);
    	
    	//System.out.println(e.getEmailid());
    	ObjectNode o = mapper.createObjectNode();
    	//try {
    		//employeeService.sendEmail(e.getEmailid(),e.getUserid());
            e.setEmailconfirmationflag(true);
        	Register a = employeeService.save(e);
        	if(a != null) {
        		o.put("response", "Congrats! Your account has been successfully activated...");
        	}
        	else {
        		o.put("response", "Error...");
        	}
            
        //} 
//    	catch (MessagingException me) {
//            me.printStackTrace();
//            o.put("response", "Error...");
//        }
    	
    	
    	//o.put("response", "Email Has been successfully sent");
    	
		return o;
	}
    
	/*
	 * public void sendEmail(String email, String uid) { SimpleMailMessage msg = new
	 * SimpleMailMessage(); msg.setTo(email);
	 * msg.setSubject("Account Activation Link"); String url =
	 * "http:localhost:8765/api/v1/confirmmail/" + uid;
	 * msg.setText("Click on the following link to activate your account :" + url,
	 * "UTF-8", "html"); javaMailSender.send(msg); }
	 */
    
	
    
	//
    @GetMapping(value="/confirmmail/{uid}", produces= {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
   	public Object confirmingEmail(@PathVariable("uid") String userId) {
    	int id = Integer.parseInt(userId);
    	Register e = employeeService.findById(id);
    	e.setEmailconfirmationflag(true);
    	Register a = employeeService.save(e);
    	
    	ObjectNode o = mapper.createObjectNode();
    	if(a != null) {
    		o.put("response", "Congrats! Your account has been successfully activated...");
    	}
    	else {
    		o.put("response", "Error...");
    	}
    	//String email = "sanketgiri48@gmail.com";
        //sendEmail(email,uid);
   		//return "<h1>Congrats! Your account with UserId : " + userId + " has been successfully activated...</h1>";
		return o;
    }
}
