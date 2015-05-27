package com.whiteboxqa.test;

import com.whiteboxqa.main.MyStrings;
import com.whiteboxqa.main.Student;

public class TestMyString {

	public static void main(String[] args) {
		
		String str1 = "Hello World";
	/*	str1 = "Innovapath" ;
     
		String str2 = "Innovapath";
		
		System.out.println("str1 hashcode :" + str1.hashCode());
		System.out.println("str2 hashcode :" + str2.hashCode());
		
		if (str1.equals(str2))
			System.out.println("The strings content are same");
		else
			System.out.println("The strings are different.");
		
		if (str1==str2)
			System.out.println("Same string reference");
		else
			System.out.println("Different String reference");
		
		Student s1 = new Student(101,"Sam");
		Student s2 = new Student(101,"Sam");
		
		if ( s1 == s2) // reference equality
			System.out.println("Same objects");
		else
			System.out.println("Different objects");
		
		
		if (s1.equals(s2)) // content equality
			System.out.println("Same Content");
		else
			System.out.println("Different content");
		
		String hello = "Hello World!!";
		System.out.println("n th character in string :" + hello.charAt(2));
		System.out.println("Lexical Comparison :" +hello.compareTo("Hhllo"));
		System.out.println("Concat :" +hello.concat(" Its a beutiful day!!"));
		System.out.println(hello);
		System.out.println("Contains: " +hello.contains("World"));
		System.out.println("Ends With :" +hello.endsWith("!!"));
		System.out.println("Starts with :" +hello.startsWith("hell"));
		System.out.println("Index of Wor" +hello.indexOf("Wor"));
		System.out.println("Substring : "+ hello.substring(2, 8));
		System.out.println(hello.replaceAll("!!", "**"));
	
	*/
		MyStrings ex = new MyStrings();
	/*	System.out.println(ex.reverse(str1));
		System.out.println(ex.createNum(15));
		
		StringBuffer buff = new StringBuffer("Hello Shilpi");
		System.out.println(ex.createNum1(15));
		buff.reverse();
		System.out.println(buff);
		*/
	//	System.out.println("Number of words :" + ex.countWords("The fox jumps the rail."));
		System.out.println(ex.reverseEachWord("The fox jumps the rail."));
		
		
	}

}
