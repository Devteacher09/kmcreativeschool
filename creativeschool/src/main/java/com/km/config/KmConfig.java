package com.km.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.km.common.exception.KmAccessDeniedException;

@Configuration
public class KmConfig implements WebMvcConfigurer{
	
	@Bean
	JavaMailSender javaMailSender() {
		Properties mailData=new Properties();
		mailData.put("mail.smtp.auth", "true");
        mailData.put("mail.smtp.starttls.enable", "true");
        mailData.put("mail.smtp.host", "smtp.gmail.com");
        mailData.put("mail.smtp.port", "587");
        mailData.put("mail.debug", "true");

//        mailData.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		JavaMailSenderImpl sender=new JavaMailSenderImpl();
		sender.setUsername("teacherdev09@gmail.com");
		sender.setPassword("ibgzqktxlpvkmlhb");
		sender.setJavaMailProperties(mailData);
		
		return sender;
	}
	
	@Bean
	public HandlerExceptionResolver handlerExceptionResolver() {
		Properties exceptionProp=new Properties();

		exceptionProp.setProperty(KmAccessDeniedException.class.getName(), "common/error");
		
		SimpleMappingExceptionResolver exceptionResolver=new SimpleMappingExceptionResolver();
		exceptionResolver.setExceptionMappings(exceptionProp);
		
		return exceptionResolver;
	}
	
	
}





