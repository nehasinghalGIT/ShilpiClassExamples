package com.whiteboxqa.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MySet {

	public Set<Integer> createNewSet(){
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(100);
		s.add(200);
		s.add(100); // return a false
		s.add(500);
		s.add(-100);
		
		return s;
		
	}
	
	public Set<Integer> createNewTreeSet(int n){
		
		Set<Integer> set = new TreeSet<Integer>();
		for (int i = 1,j= 1 ; j <= n ; i+=100, j++)
			set.add(i);
		
		return set;
	}
	public void printSet(Set<Integer> s){
		
		System.out.println(s);
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
	}
	
	// This method will create an hashset of n integers
		public Set<Integer> createListwithN(int n){
			Set<Integer> set = new HashSet<Integer>(n);
			for (int i = 1,j= 1 ; j <= n ; i+=100, j++)
				set.add(i);
			
			return set;
		}
   // Write a method that will remove the duplicates from an array
	// a = [1,2,1,3,2,4]
    // a = [1,2,3,4]
	public void removeDuplicates(int [] arr){
		
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0 ; i < arr.length ; i++){
			if (s.add(arr[i]) == false)
				System.out.println(arr[i]);
		}
		
		System.out.println("The new Array :" + s);
	}
}
