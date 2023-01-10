package com.appregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OwnerViewPage {
 
	static final String DB_URL = "jdbc:mysql://Localhost:3306/jdbcapp";
	static final String USER = "root";
	static final String PASS = "Password1";

	public void viewpage(Scanner scan){
		Connection conn = null;
		Statement stmt = null;
		try{
		      //STEP 1: Register JDBC driver

		      //STEP 2: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 3: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      
		      boolean querying = true;
		      System.out.println("Admin Page");
		      
		      try  {
		    	  while(querying)
		           {
		               //Print the menu
		    		   System.out.println();
		        	   System.out.println("********************************");
		               System.out.println("Please select a query below!");
		       
		               System.out.println("1. Enter New Model");
		               System.out.println("2. Update Price ");
		               System.out.println("3. Update Availablity");
		               System.out.println("4. Delete Model");
		               System.out.println("5. Place Order");
		               System.out.println("6. Logout");
		               System.out.println("********************************");
		               System.out.println();
		               
		               System.out.println("Enter Your Choice");
		               String input = scan.nextLine();
		               int answer;
		               try{
		            	   answer=Integer.valueOf(input);
		               }
		               catch(Exception e)
		               {
		            	   answer=-1;
		               }
		               if(answer == -1 || answer < 1 || answer > 6)
		               {
		                   //User entered incorrect input
		                   System.out.println("Incorrect Input!");
		                   System.out.println("Please enter a number 1-6");
		               }
		               
		               else if (answer==1)
		               {
		            	   String Model = "";
		                   String Details = "";
		                   Integer Price = 0;
		                   Integer Avail = 0;
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter Details");
		 		    	   Details = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter Price");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   System.out.println("Enter Availablity");
		 		    	   Avail = scan.nextInt();
		 		    	   String sql = "INSERT INTO machine VALUES " + "( '"+ Model + "' , " + "'" + Details + "', " + "" + Price + ", " + "" + Avail + ")";
				    	   stmt.execute(sql);
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==2)
		               {
		            	   String Model = "";  
		                   Integer Price = 0;
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter New Price");
		 		    	   Price = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE machine SET machine.Price = ? where machine.Model=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Price);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==3)
		               {
		            	   String Model = "";  
		                   Integer Avail = 0;
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	  
		 		    	   System.out.println("Enter New Availablity");
		 		    	   Avail = scan.nextInt();
		 		    	  
		 		    	   String sql1 = "UPDATE machine SET machine.Avail = ? where machine.Model=?";
	                	   PreparedStatement stmt1 = conn.prepareStatement(sql1);
	                	   stmt1.setInt(1, Avail);
	                	   stmt1.setString(2, Model);
	                	   stmt1.executeUpdate();
				    	   System.out.println("Success!");
		               }
		               
		               else if (answer==4)
		               {
		            	   String Model = "";  
		                   
		                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM machine WHERE LOWER(Model) LIKE LOWER('%" + Model + "%')";
	                       
	                       //Execute the sql
	                       stmt.execute(sqlDel);
	                       
	                       System.out.println("Model deleted!");
				    	   
		               }
		               
		               else if (answer==5)
		               {
		            	   String Model = "";  
		                   
			                 
		 		    	   System.out.println("Enter Model No");
		 		    	   Model = scan.nextLine();
		 		    	   String sqlDel = "DELETE FROM confirm WHERE LOWER(Model) LIKE LOWER('%" + Model + "%')";
	                       
	                       //Execute the sql
	                       stmt.execute(sqlDel);
	                       
	                       System.out.println("Model Ordered!");
				    	 
		            	   
		               }
		               
		               else if (answer==6)
		               {
		            	   
		            	   querying= false;
		               }
		           }
		    	  
		      }
		    	  
		    	  catch (Exception e)
		      {
		    	  System.out.println(e);
		      }
		      
		      
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		         
		         //Inform user of error
		         
		         System.out.println("Error closing connection to the database!");
		      }//end finally try
		   }//end try
		return;
	}
}
