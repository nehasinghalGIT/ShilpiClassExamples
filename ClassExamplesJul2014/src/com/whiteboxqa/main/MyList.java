package com.whiteboxqa.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList ex = new MyList();
	/*    List<Integer> l3 =	ex.createAnArrayList(); // 1,1,2,2
		List<Integer> l1 = ex.createListwithN(10); // 1,2,3..10
		List<Integer> l2 = ex.createListwithN(45);
		ex.compareLists(l1, l3);
		
		List<String> names = new ArrayList<String>();
		names.add("Sam");
		names.add("Shilpi");
		names.add("Reena");
		names.add("Sam");
		names.add("Ruchi");
		names.add("Venky");
		System.out.println("Index of :" + names.lastIndexOf("Sam"));
		names.remove(3);
		names.set(4, "Venkatesh");
		System.out.println("Repetition : " + ex.countElementsinList(names, "Sam"));
		
		List<String> instructors = new ArrayList<String>();
		instructors.add("Sam");
		instructors.add("Shilpi");
		instructors.add("Reena");
		
	//	ex.findMissingElements(names, instructors);// A-B removeALL
		
		System.out.println("Names : " + names);
		System.out.println("Instructors" + instructors);
		names.retainAll(instructors); // A intersect B common names
		System.out.println(names); 
	*///	ex.printList1(l);
	//	ex.printList2(l);
	//	ex.printList3(l);
	
		List<Integer> ll = ex.createLListwithN(10);
		ex.printList3(ll);
	}
	
	// This method will create an arraylist of n integers
	public List<Integer> createListwithN(int n){
		List<Integer> list = new ArrayList<Integer>(n);
		for (int i = 1 ; i <= n ;i++)
			list.add(i);
		
		return list;
	}
	public List<Integer> createAnArrayList(){
		
		  List<Integer> list = new ArrayList<Integer>(1000);
		  list.add(1); // Integer
	//	  list.add(2.35);
	//	  list.add("Sam");
		  list.add(1); // Integer
	//	  list.add(2.35);
	//	  list.add("Sam");
		  list.add(2); // Integer
	//	  list.add(2.35);
	//	  list.add("Sam");
		  list.add(2); // Integer
	//	  list.add(2.35);
	//	  list.add("Sam");
		  
		  // add 100 to Integer values
		  for (Object x : list){
			 int sum = (Integer)x + 100;
		 }
		  
		  int x = 12;
		  Integer x1 = 120; // autoboxing
		  x1 = x;
		  x= x1 ; // unboxing
		  
		  System.out.println(list);
		  // Singeleton Pattern
		  Calendar cal = Calendar.getInstance();
		  Date date = cal.getTime();
		  SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy hh:mm");
		  System.out.println(format.format(date));
		  
		  return list;
		  
	}
	// printing the list elements
	public void printList1(List<Integer> l){
		System.out.println("Inside print1");
		for (Integer x : l)
		{
			System.out.println("Element :" + x);
		}
		
		System.out.println(l);
		
		
	}
	
	public void printList2(List<Integer> l){
		//  1,2 ,3 
		System.out.println("Inside print2");
		Iterator<Integer> it = l.iterator();
		while (it.hasNext()) {
			Integer x  = it.next(); // gives the object value
			System.out.println(x);
		}
	}
	// print the elements in reverse order
	public void printList3(List<Integer> l){
		
		System.out.println("Inside print3");
		int n = l.size();
		ListIterator<Integer> it = l.listIterator(n); // nth element in the lisr
		while (it.hasPrevious()) {
			Integer x  = it.previous();
			System.out.println(x);
		}
		
	}
	// list 1 = {1,2,3,4}
	// list 2 = {2,1,2,3}
	// This method compares two lists
	public void compareLists(List<Integer> l1, List<Integer> l2){
		
		System.out.println(l1.containsAll(l2));
	}
	// count the number of times an element is repeated in the list
	public int countElementsinList(List<String> names, String searchname){
		int count = 0;
		for (String name : names){
			if (name.equalsIgnoreCase(searchname))
				count++;
		}
		
		return count;
		
	}
	// This method compares two list with all the repeated items
	// for each item , log the count, and then compare with the list
	// l1 = {1,1,2,3,3}
	// l2 = {1,1,2}
	// 1 :2 , 2 : 1
	
	// find all the elements in list1  which are not there in list 2
	public void findMissingElements(List<String> actual , List<String> expected){
		
		actual.removeAll(expected);
		System.out.println(actual);
	}
	// Creating a list using linkedList // uses doubly linked list
	public List<Integer> createLListwithN(int n){
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1 ; i <= n ;i++)
			list.add(i);
		
		return list;
	}
	
}
