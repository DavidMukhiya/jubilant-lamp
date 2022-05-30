package com.jdbc;

import java.sql.*;

public class JdbcDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/student_manage";
		String user = "root";
		String passWord = "";
		//String query = "select * from student";
		String query = "INSERT INTO `student`(`userID`, `userName`) VALUES (?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, passWord);
		//Statement st = con.createStatement();
		//ResultSet rs = st.executeQuery(query);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, 9);
		st.setString(2, "Dipak");
		
		int count = st.executeUpdate();
		
		System.out.println(count +" Row/s Affected");
		

//		while (rs.next()) {
//			System.out.println(rs.getInt(1) + " ----------->" + rs.getString(2));
//		}
		st.close();
		con.close();

	}
}
