package com.phuocthanh.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class EntityManagerFactory {
	//tao connection
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/estate?useUnicode=true&characterEncoding=utf-8";
			String user="root";
			String passWord="1234564";
			return DriverManager.getConnection(url,user,passWord);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
			
		}
	}
}
