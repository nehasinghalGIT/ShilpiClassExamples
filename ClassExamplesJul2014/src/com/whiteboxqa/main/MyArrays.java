package com.whiteboxqa.main;

import java.util.Arrays;

public class MyArrays {
	
	public static void main(String [] args){
		
		int [] ids = new int[5];
		ids[0] = 10;
		ids[1] = 20;
		ids[2] = 10;
		System.out.println(ids[4]);
		System.out.println(Arrays.toString(ids));
		
		MyArrays ex = new MyArrays();
		ex.printArray(ids);
		
	}
	
	public void printArray(int [] arr){
		
		int n = arr.length;
		for (int i = 0 ; i < n ; i ++)
			System.out.println(arr[i]);
		
		for (int x : arr){  // for each
			System.out.println(x);
		}
	}
	
	// Linear search - to find a key element in a group of elements
	// unsorted arrays
	// a = {100, -45, 23, 67}  
	// input = array, key = 15
	// output = 
	public boolean linearSearch(int[] arr, int key){
		boolean found = false;
	    for (int x : arr ){
	    	if (x==key) {
	    		found = true;
	    		break;
	    	}
	    }
		return found;
	}

	// Search for a key in an arrays, and find its location
	public int linearSearch1(int[] arr, int key){
		int index = -1;
	  
		for (int i = 0 ; i <= arr.length-1 ; i++) {
			if (arr[i] == key) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	// Find the minimum value of the element in the array
	// a = {12, -10, 23, 42 , 76, -5}
	// min = -5
	public int findMin(int[] arr){
		int min = -1;
		
		if (arr == null || arr.length <1) 
			throw new ArrayIndexOutOfBoundsException();
	    min = arr[0];
		for (int i = 1 ; i < arr.length ; i++) {
			if (arr[i] < min) min = arr[i];
		}
		
		return min;
	}
	// Find the number of times an element is repeated in the array
	// a = {1,2,3,1,1}
	// 3
	public int countElements(int[] arr, int key){
		int count = 0;
		for (int x : arr ){
	    	if (x==key) count ++;
	    }
		
		return count;
		
	}
	
	// Find the sum of all the even numbers in the array
	// Find whether the elements in two arrays are same or not
	// a1 = {1,2,3,4} a2 = {1,2,3,4}
	// a3 = {2,1,3,4}
	
	
	// To do binary search in an array
	public int binarySearch(int[] arr, int key){
	
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int ret = Arrays.binarySearch(arr, key);
		return ret;
		
		
	}
	
	// Find the maximum value of the element in the array
	// return the index of the maximum value in the array
	
	// To reverse the elements of an array
	// a = {1,2,3,4,5}
	// a1 = {5,4,3,2,1}
	public int[] reverseArray(int[] arr){
		int [] revArr = new int[arr.length];
		for (int i = arr.length - 1, j = 0 ; i >= 0 ; i-- , j++)
			revArr[j] = arr[i];
		return revArr;
	}
	// Least Effecient - storage space is used
	// 5 
	// a = {1,2,3,4,5}
	
	//temp = 1
	// arr[0] = 5
	// arr[4] = 1
	
	// a = {5,4,3,2,1}
	public void reverseArray1(int[] arr){
		int n = arr.length;
		for (int i = 0 ; i <n/2 ; i++){
			int temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
		
	}
	// More efficient - 1 temporary storage
	
	public void reverseArray2(int[] arr){
		int n = arr.length; // a= arr[i] , b = arr[n-1-i]
		for (int i = 0 ; i <n/2 ; i++){
		   arr[i] = arr[i] + arr[n-1-i];
		   arr[n-1-i] = arr[i] - arr[n-1-i];
		   arr[i] = arr[i] - arr[n-1-i];
		}
	}
	// Most efficient
	
	public void swap(int a, int b){
		System.out.println("a=" + a + " b =" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a=" + a + " b =" + b);
	}
	
	
}
