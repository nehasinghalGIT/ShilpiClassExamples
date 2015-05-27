package com.whiteboxqa.main;

public class Hello {

	static int x  =10;
	static String course = "QA";
	int y ;
	private int z;
	private String strz = "Sam";
	protected int z1;
	public int z2;
	
	public void printY(){
		System.out.println(y);
		System.out.println(z);
		System.out.println(z2);
		System.out.println(z1);
	}
	
	public String getstrZ(){
		return strz;
	}
	
	public void setstrZ(String newstrz){
		strz = newstrz;
	}
	
	public static void main(String[] args) {
		
		    System.out.println(x);
	        int a = 10;  // value
	        int b = 20;
	  //      a = a + 5;
	  //      a += 5;
	     //   a = a + 1; // binary operator
	      //  a++; // post increment operator // unary
	        int z =  100 + a++;
	        int z1 = 100 + ++b; // pre - increment operator
	        System.out.println("Value of a =" + a); // 11
	        System.out.println("Value of z =" + z); // 110
	        System.out.println("Value of z1 =" + z1); // 121
	        // conditional operator- ternary
	        int z2 = a > 5 ? 30 : 50;
	        System.out.println("z2="+ z2);
	/*        
	        int c = a+b;
	        String name = "Sam"; // reference type
	        double z = Math.sqrt(-123);
	        System.out.println(z);
			System.out.println("Value of addition of a and b = "+ c);
			// to find the cube of b
			System.out.println("Cube of b " + b * b);
			
		
			int x ; // declaration
			x = 10; // initialisation
			// declaration of reference variables
			String str = null ; // Initialisation - first value of the variable
			str = "Sam"; // assigning some value at point of time to the variable
			str = "Shilpi";
			
			String str1 = "Innovapath";
			str1 = "Hello Ip";
			*/
	        int x1 = 10;
	        int x2 = 10;
	        System.out.println(x1 ^ x2);
			
	        int x3 = Integer.MAX_VALUE  + 1;
	        long xz = 2147483647l + 1;
	        System.out.println(x3);
	        System.out.println(xz);
	        System.out.println(Long.MAX_VALUE - 2000);
	        
	        Hello h1 = new Hello(); // h1 is object of the class
	        System.out.println("Value of y for Object h1" +h1.y); 
	        Hello h2 = new Hello(); // h2 is another object of the class
	        System.out.println(course);
	        System.out.println(h1.z2);
	        System.out.println(h1.z);
	        System.out.println(h1.z1);
	}

}
