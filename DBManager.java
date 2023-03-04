package com.saksoft.CurdOpt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/organization";
	private String uid="root";
	private String password="Java@1234";
	
	public void selectRecords() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uid, password);
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "Java@1234");
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("select * from Employee");
			
			while(result.next()) {
				System.out.println("E ID: "+result.getInt(1));
				System.out.println("E FName: "+result.getString(2));
				System.out.println("E LName: "+result.getString(3));
				System.out.println("E Email: "+result.getString(4));
				System.out.println("E Age: "+result.getInt(5));
				System.out.println("----------------");
			}
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
//insertion updation deletion
		public boolean RecordManipulation(String query) {
			boolean flag=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, uid, password);
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "Java@1234");
			Statement stmt=con.createStatement();
			flag=stmt.executeUpdate(query)> 0 ? true:false;
			con.close();
						
		}catch(Exception e){
			System.out.println(e);
		}
		return flag;
	}

}
