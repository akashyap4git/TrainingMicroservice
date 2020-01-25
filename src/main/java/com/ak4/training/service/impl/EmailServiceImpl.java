package com.ak4.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ak4.training.service.EMailService;

@Service
public class EmailServiceImpl implements EMailService {
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String emailId, Boolean status) {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailId);
        if(status == null) {
            msg.setSubject("Proposed for Courses");
            msg.setText("Hello " + emailId + ",\n You are proposed for courses");
        } else {
        	if(status) {
                msg.setSubject("Confirmed for Courses");
                msg.setText("Hello " + emailId + ",\n You are confirmed for courses");        		
        	} else {
                msg.setSubject("Declined for Courses");
                msg.setText("Hello " + emailId + ",\n You are declined for courses");
        	}
        }
        javaMailSender.send(msg);
	}
}
