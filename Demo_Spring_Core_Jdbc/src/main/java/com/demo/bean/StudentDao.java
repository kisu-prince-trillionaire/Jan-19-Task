package com.demo.bean;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertStudent(Student s) {
		String query = "insert into student values('" + s.getRollNo() + "','" + s.getName() + "','" + s.getMarks()
				+ "')";
		return jdbcTemplate.update(query);
	}

	public int updateStudent(Student s) {
		String query = "update student set name='" + s.getName() + "',marks='" + s.getMarks() + "' where rollNo='"
				+ s.getRollNo() + "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteStudent(int id) {
		String query = "delete from student where id='" + id + "' ";
		return jdbcTemplate.update(query, id);
	}
}
