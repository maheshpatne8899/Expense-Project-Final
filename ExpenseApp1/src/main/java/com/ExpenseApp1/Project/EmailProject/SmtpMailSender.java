package com.ExpenseApp1.Project.EmailProject;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class SmtpMailSender {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String send(String to,String subject,String body) throws javax.mail.MessagingException, MailException
	{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		helper.setTo(to);
		helper.setText(subject);
		helper.setSubject(body);
		
		//helper.addAttachment("download.jpg", new ClassPathResource("download.jpg")); 
		
		javaMailSender.send(message);
        return "Mail Sent Successfully!";
    }

}
