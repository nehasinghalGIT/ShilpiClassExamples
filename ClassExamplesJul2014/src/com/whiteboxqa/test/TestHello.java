package com.whiteboxqa.test;

import com.whiteboxqa.main.BadUrlException;
import com.whiteboxqa.main.Hello;

public class TestHello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h = new Hello();
	//	System.out.println(h.z2);
		
		String url = "http://www.google.co.in";
		try {
		if (!url.endsWith(".com"))
			throw new BadUrlException(url);
		}
		catch (BadUrlException e){
			e.printStackTrace();
			System.out.println("Use .com instead");
			url = "http://www.google.com";
		}
		
		System.out.println("Do something with : " + url);
	}

}
