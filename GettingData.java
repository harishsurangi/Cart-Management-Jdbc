package com.appregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GettingData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String pwd="Password1";
		String query="select * from employee ";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		Statement st =con.createStatement();
	   ResultSet  rs =st.executeQuery(query);
      System.out.println("eno\tename\tesalary\teaddress");
      System.out.println("------------------------------------------");
      boolean flag=false;
	   while(rs.next()) {
		   
		   System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
		   flag=true;
	   }
	   if(flag==false) {
		   System.out.println("no records available");
	   }
	    con.close();
	}

}
