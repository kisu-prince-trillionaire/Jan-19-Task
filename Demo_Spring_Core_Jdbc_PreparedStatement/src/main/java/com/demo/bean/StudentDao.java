package com.demo.bean;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class StudentDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertStudent(Student s) {
		String query = "insert into student values(?,?,?)";
		jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ps.setInt(1, s.getRollNo());
				ps.setString(2, s.getName());
				ps.setInt(3, s.getMarks());

				return ps.execute();
			}
		});
		System.out.println("Data inserted Successfully");
		return 1;
	}

	public int updateStudent(Student s) {
		String query = "update student set name=?, marks=? where rollNo=?";
		return jdbcTemplate.update(query);
	}

	public int deleteStudent(int id) {
		String query = "delete from employee where rollNo=?";
		return jdbcTemplate.update(query, id);
	}
}
