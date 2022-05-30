package com.jdbc.dao;

import java.sql.SQLException;

public class MainDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDao std = new StudentDao();
		Student s = std.getStudent(2);
		System.out.println(s.stdName);
		
		Student s1 = new Student();
		s1.stdName = "Bijay";
		s1.stdRollNo = 16;
		
		std.addStudent(s1);
		
	}
}
