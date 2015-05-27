package com.whiteboxqa.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.whiteboxqa.main.MyFileIO;
import com.whiteboxqa.main.Student;

public class TestFileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFileIO ex = new MyFileIO();
	/*	int c = ex.readAFile("C:\\Users\\Shilpi\\SkyDrive\\training\\filethatdoesnotexist.txt");
		System.out.println("Number of bytes = " + c);
		
		try {
		     ex.writeAFile("C:\\Users\\Shilpi\\SkyDrive\\training\\filethatdoesnotexist.txt");
		}
		
		catch(IOException e){
			
		}
		catch (Exception e){
			
		}
		System.out.println("Do some other tasks!!");
		*/
		ex.writeObjectFile("C:\\Users\\Shilpi\\SkyDrive\\training\\student.ser");
		ex.readObjectFile("C:\\Users\\Shilpi\\SkyDrive\\training\\student.ser");
	}
	
	

}
