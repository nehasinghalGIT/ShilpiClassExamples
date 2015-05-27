package com.whiteboxqa.test;

import java.util.Set;

import com.whiteboxqa.main.MySet;

public class TestMySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySet ex = new MySet();
	//	Set<Integer> s = ex.createListwithN(15);
	//	Set<Integer> s = ex.createNewTreeSet(15);
	//	ex.printSet(s);
		ex.removeDuplicates(new int[] {1,2,3,2,1,5,100});
				
	}

}
