package com.appregistration;

import java.util.Scanner;

public class Test {
	
	public static void view(){
		boolean querying = true;
		try ( //Our input scanner
	               Scanner scan = new Scanner(System.in)) {
	           while(querying)
	           {
	        	   
	               //Print the menu
	        	   System.out.println();
	        	   System.out.println("/-----------------------------/");
	              
	            
	               System.out.println("1. User Login and Booking");
	               System.out.println("2. User SignUp ");
	               System.out.println("3. Admin Login");
	               System.out.println("4. Exit");
	               
	               System.out.println("/----------------------------/");
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
	               if(answer == -1 || answer < 1 || answer > 4)
	               {
	                   //User entered incorrect input
	                   System.out.println("Oops!!! enter a valid one");
	                   System.out.println("Please enter a given options");
	               }
	               
	               else if (answer==1){
	            	   Login L = new Login();
	            	   L.log(scan);
	               }
	               
	               else if (answer==2){
	            	   Signup S= new Signup();
	            	   S.sign(scan);
	               }
	               
	               
	               else if (answer==3){
	            	   
	            	   System.out.println("Verfiy Yourself as Admin");
	            	   System.out.println("Enter UserId");
	            	   
	            	   String userId= scan.nextLine();
	            	   int val;
		               try{
		            	   val=Integer.valueOf(userId);
		               }
		               catch(Exception e)
		               {
		            	   val=-1;
		               }
	            	   System.out.println(" Enter Password");
	            	   String pass = scan.nextLine();
	            	   
	            	   System.out.println(pass);
	            	   OwnerVerification a= new OwnerVerification();
	            	   if (val==a.getUserId() && pass.equals(a.getPassword()))
	            	   {
	            		   OwnerViewPage o= new OwnerViewPage();
		            	   o.viewpage(scan);
		            	   
	            	   }
	            	   else{
	            		   System.out.println("Incorrect Username or Password");
	            	   }
	               }
	               else if (answer == 4)
	               {
	            	   querying = false;
	            	   
	               }
	               
	           }
	        
	      }
		catch (Exception e)
	      {
			System.out.println(e);
	      }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Purchasing Program!");
	    view();
	    System.out.println("Thanku for Visiting");
	    
	}
}
