package com.whiteboxqa.main;

public class MyStrings {
	
	// this method reverses a string
	public String reverse(String str){
		String rev = null;
		char[] strarray = str.toCharArray();
		int n = strarray.length;
		// swap arr[i] with arr[n-1-i]
		// a,b
		// a = a+ b
		// b = a-b
		// a = a - b
		for (int i = 0 ; i <n/2 ; i++){
			strarray[i] = (char) (strarray[i] + strarray[n-1-i]);
			strarray[n-1-i] = (char) (strarray[i] - strarray[n-1-i]);
			strarray[i]  = (char) (strarray[i] - strarray[n-1-i]);
				
		}
		rev = String.valueOf(strarray);
		
		return rev;
		
	}
	
	// str = "1234567891011....30"
	public String createNum(int n){
		String s = null;
		for (int i = 1 ; i <=n ; i++)
			s += i;
		return s;
	}
   // 
	public StringBuffer createNum1(int n){
		StringBuffer buff = new StringBuffer("");
		for (int i = 1 ; i <=n ; i++)
			buff.append(i);
		return buff;
	}
	// sen = 'The old fox jumps.'
	// find the number of words in the sentence
	public int countWords(String sen){
		int count = 0;
		String [] words = sen.split(" ");
		count = words.length;
		return count;
	}
	// reverse each word in the sentence
	// sen = 'ehT dlo ...'
	public String reverseEachWord(String sen){
		String rev = "";
		String [] words = sen.split(" ");
		for (int i = 0 ; i < words.length ; i++) {
		
		     rev += reverse(words[i]);
		     rev += " ";
	    }
		return rev;
	}
	
	
	// change the sen to = 'The1 old2 fox3 jumps.4'
	
}
