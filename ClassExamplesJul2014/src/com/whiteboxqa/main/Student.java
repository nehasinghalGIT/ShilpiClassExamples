package com.whiteboxqa.main;

public class Student implements java.io.Serializable {
	
	protected int studentId;
	String name;
	String enrollmentDate;
	double score;
	transient String ssn ;
	char grade;
	static int prop;
	
	public Student(){
		studentId = 101;
		name = "Sam";
	}
	
	public Student(int sId, String name){
		this.studentId = sId;
		this.name = name;
		this.ssn = "672678237";
	    prop = 100;
	}
	
	public void getStudentName(){
		System.out.println(name);
	}
	
	public int hashcode(){
		int hash = -1;
		hash = this.studentId * 1111;
		return hash;
	}
	
	public boolean equals(Student s){
		boolean ret = false;
		if    (this.hashcode() == s.hashcode()) return true;
		return ret;
	}
	
	public void printStudentDetails(){
		System.out.println("Id :" + this.studentId);
		System.out.println("Name :" + this.name);
		System.out.println("Date :" + this.enrollmentDate);
		System.out.println("Grade :" + this.grade);
		System.out.println("Score" + this.score);
		System.out.println("SSN :" + this.ssn);
		System.out.println("Prop :" + prop);
	}
	public static void main(String args[]){
		Student s;
		s = new Student(); 
		s.studentId = 100;
		s.name = "Swati";
		
		Hello h1 = new Hello();
		System.out.println(h1.y);
		System.out.println(h1.course);
		
		
		h1.course = "J2EE";
		h1.z2 = 1000;
		h1.z1 = 100000;
		System.out.println(Hello.course);
		
		System.out.println(h1.getstrZ());
		h1.setstrZ("New Value");
		System.out.println(h1.getstrZ());
	//	System.out.println(grade);
	//	getStudentName();
	//	s.getStudentName();
	}

}
