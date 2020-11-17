package com.coder.phase1;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BLOImpl {


	public void getAllFiles() {
		List<String> list=new ArrayList<String>();
		File files[]=new File("/Users/yaddanapalli/Documents/LockedMe/LockedMe").listFiles(); 
		for(File file : files) {
			if(file.isFile()) {
				list.add(file.getName());
				System.out.println(file.getName());
			}
		}
	}

	
	public void addFile() {
		System.out.println("Enter the file name which you want to add: ");
		Scanner sc=new Scanner(System.in);
		String fname=sc.nextLine();
		File f=new File(fname);
		try {
			if(f.createNewFile()) {
				System.out.println("File "+ fname +" is added to directory");
				//logic to write into the file here
				DataInputStream dis =new DataInputStream(System.in);
				FileOutputStream fout=new FileOutputStream(f);
				BufferedOutputStream bout=new BufferedOutputStream(fout,1024);
				System.out.println("Enter text and | at the end");
				
				char c;
				while((c=(char) dis.read())!='|')
				{
					bout.write(c);
				}
				System.out.println("Text added to file successfully");
				bout.close();
			}
			else {
				System.out.println(" File already exist ");
			}
		}
		catch(IOException ioe) {
			System.out.println(ioe);	
		}
	
		}

	
	public void deleteFile() {
		
		System.out.println("Enter the filename which you want to delete (note that name is case sensitive): ");	
		Scanner sc=new Scanner(System.in);
		String fname=sc.nextLine();
		File f=new File(fname);
		boolean flag=false;
		File files[]=new File("/Users/yaddanapalli/Documents/LockedMe/LockedMe").listFiles();
			for(File fs: files) {
			if(f.getName().equals(fs.getName()))     //to check the case sensitivity of the entered filename
			{
				if(f.delete()) {
					flag=true;
				}
			}
			}
			if(flag==true) {
			System.out.println("File " + fname +" is deleted sucessfully");
			}
			else {
				System.out.println("File Not Found " );	
			}
	}
		
	
	
	public void searchFile() {
		//todo
		
	}

	

}
