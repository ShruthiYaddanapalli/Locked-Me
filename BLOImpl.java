package com.coder.phase1;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BLOImpl {


	public void getAllFiles() {
		System.out.println("****** Retrieved files are ********");
		List<String> list=new ArrayList<String>();
		//Replace the file path with path of the directory
		File files[]=new File("/Users/yaddanapalli/Documents/LockedMe/LockedMe").listFiles(); 
		Arrays.sort(files);
		for(File file : files) {
			if(file.isFile()) {
				list.add(file.getName());
				System.out.println(file.getName());
		}
		}
	}

	
	public void addFile() {
		System.out.println("******* Selected to add the File in directory ********");
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
		System.out.println("********** Selected to delete the File from directory **********");
		System.out.println("Enter the filename which you want to delete (note that name is case sensitive): ");	
		Scanner sc=new Scanner(System.in);
		String fname=sc.nextLine();
		File f=new File(fname);
		boolean flag=false;
		//Replace the file path with path of the directory
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
		System.out.println("Enter the file name which you want to search in the current directory:");
		Scanner sc= new Scanner(System.in);
		String file=sc.nextLine();
		File f= new File(file);
		int flag=0;
	
		//Replace the file path with path of the directory
		File dir = new File("/Users/yaddanapalli/Documents/LockedMe/LockedMe");
		String[] list = dir.list(); 
		if(list.length<1) {
			System.out.println("There is no Files inside the directory");
		}
		else {
			for(int i=0;i< list.length;i++) {
				String filename=list[i];
				if(filename.equalsIgnoreCase(file)) {
					try {
						System.out.println("Location of searched file is "+ f.getCanonicalPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
					flag=1;
				}				
			}
			if(flag==1) {
				System.out.println(" ");
			}
			else {
				System.out.println("File doesn't exist");
			}
			}
	}
}

	


