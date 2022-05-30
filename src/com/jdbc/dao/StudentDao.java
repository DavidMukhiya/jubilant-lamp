package com.jdbc.dao;

import java.sql.*;

public class StudentDao {
	public Student getStudent(int rollNo) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/student_manage";
		String userName = "root";
		String passWord = "";
		String query = "SELECT `userName` FROM `student` WHERE userID ="+rollNo;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,userName,passWord);
		Statement st = con.createStatement();
		
		
		
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		
		String name = rs.getString(1);
	
		
		Student std = new Student();
		std.stdName = name;
		
		return std;
	}
	
	public void addStudent(Student s) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/student_manage";
		String userName = "root";
		String passWord = "";
		String query = "INSERT INTO `student`(`userID`, `userName`) VALUES (?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,userName,passWord);
		
		PreparedStatement st = con.prepareStatement(query);
		
		int rollNo = s.stdRollNo;
		String name = s.stdName;
		st.setInt(1, rollNo);
		st.setString(2, name);
		
		int count = st.executeUpdate();
		
		System.out.println(count +" Row/s Affected");
	}
}
