package com.coder.phase1;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		int n,m =0;
		BLOImpl bLOImpl =new BLOImpl();						//creating object for Business level operations Implementation class which is inside same package
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("************************************************************************** \n");
		System.out.println("*********** Application Name: LOCKED ME *********\n");
		System.out.println("*********** Developer Details: Developed By Shruthi Yaddanapalli ********* \n");
		System.out.println("************************************************************************** \n");
		System.out.println("Enter your choice among 1,2,3: \n");
		System.out.println("1. Retrieve current filenames in Ascending order \n");
		System.out.println("2. Navigate to bussiness level operation \n");
		System.out.println("3. Exit from the application \n");
		
		n=sc.nextInt();
		
		switch(n) {									//outer switch 
		
		case 1: 
			bLOImpl.getAllFiles();
			break;
		
		case 2:
			do {
			System.out.println("Enter your choice for Business level operation 1,2,3,4: \n");

			System.out.println("1. Add a file and its content to a directory: \n");
			System.out.println("2. Delete a selected file from a directory: \n");
			System.out.println("3. Search a file in directory: \n");
			System.out.println("4. Return to main menu \n");
			
			m=sc.nextInt();
				
		
			switch(m) {								// Inner switch 
			
			case 1:
				
			    bLOImpl.addFile();
			    break;
				
			case 2:
			    bLOImpl.deleteFile();
			    break;
				
			case 3:
			    bLOImpl.searchFile();
			    break;
			
			case 4:
			    System.out.println("Exited from Business level operations");
			    break;
				
			default:
			    System.out.println("You have entered Invalid Choice");
			    System.out.println("-----------------------------------");
			    break;
			    
			}
			
			}while(m!=4);
			break;
			
	
		case 3:
			System.out.println("Exited from the application");
			break;
		
		default:
			System.out.println("You have entered Invalid Choice");
			System.out.println("----------------------------------");
		    break;
			}
		}
	while(n!=3);
		
	
	
	}	
}


