package com.whiteboxqa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFileIO {
	
	// read from a file, and return the number of bytes
	public int readAFile(String filepath){
		
		int count = 0;
		FileInputStream in = null;
	    String str = null;
		try {
			System.out.println(str.length()); // NullpointerException
			System.out.println("Reading from the file..");
			in = new FileInputStream(filepath); 	// opening the file stream
			int c ;
			while ( (c= in.read()) != -1){
				count++;
			}
		    System.exit(0);
		//	in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		
			System.out.println("File not available. Please put the file there!!");
			count = -1;
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		catch(Throwable e) {
			System.out.println("String is null");
		}
		finally{
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("This will always be executed");
		
		}
		
		
		return count;
	}

	public void writeAFile(String filepath) throws IOException,Exception{
		
		FileWriter  fw = new FileWriter(filepath);
		
		fw.write("Innovapath is consulting company!!");
		
		fw.close();
		
		
	}
	
   public void writeObjectFile(String path){
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
			Student s = new Student(100,"Sam");
			out.writeObject(s);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
   
   public void readObjectFile(String path){
	   
	   try{
		   ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		   Student s ;
		   s =  (Student)in.readObject();
		    if (s!=null)  {
		                 s.printStudentDetails();
		    //	System.out.println("Id :" + s.studentId);
		    	//System.out.println("Name :" + s.name);
		    }
		   in.close();
	   }
	   catch(FileNotFoundException e){
		   
	   } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
}
