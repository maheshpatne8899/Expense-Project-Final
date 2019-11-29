package com.ExpenseApp1.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExpenseApp1.Project.EmailProject.SmtpMailSender;

@RestController
@RequestMapping("/mail")
public class EmailController {
	
	
	
	@Autowired 
	SmtpMailSender smtpMailSender;

	/**
	 * Method used to sendMail
	 * @param Mail 
	 * @return status string
	 */
	@GetMapping("/sendMail")
	public String sendMail() throws MailException, javax.mail.MessagingException
	{
	return smtpMailSender.send("maheshpatne8899@gmail.com", "Testing Mail from Springboot", "Mail USing SprinBoot");

	}

}
