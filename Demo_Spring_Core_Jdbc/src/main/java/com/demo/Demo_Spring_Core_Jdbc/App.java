package com.demo.Demo_Spring_Core_Jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.bean.Student;
import com.demo.bean.StudentDao;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		StudentDao dao = (StudentDao) context.getBean("edao");

		// Insert into student
		int status1 = dao.insertStudent(new Student(103, "Rahul Kumar", 98));
		System.out.println(status1);

		// Update student
		int status2 = dao.updateStudent(new Student(102, "Rahul Kumar", 98));
		System.out.println(status2);

		// Delete student
		int status3 = dao.deleteStudent(101);
		System.out.println(status3);

		((AbstractApplicationContext) context).close();
	}
}
