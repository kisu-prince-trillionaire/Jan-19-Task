package com.student.bean;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {

	public static void main(String[] args) {
		//ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println(student.getSubject());
	}

}
