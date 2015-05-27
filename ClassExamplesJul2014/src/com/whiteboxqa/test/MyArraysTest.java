package com.whiteboxqa.test;

import java.util.Arrays;

import com.whiteboxqa.main.MyArrays;


public class MyArraysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         MyArrays ex = new MyArrays();
         int[] score = new int [] {12, -100,78,67,1000}; // 67
         int[] score2 = new int[] {12, 12, 12, 0, -12}; // 0
         int[] score3 = new int[] {2,4,6,8,10}; // -1
  //       boolean ret = ex.linearSearch(score3, 5);
  //       System.out.println("Key Found : " + ret);
         
   //      int indx = ex.linearSearch1(score3, 10);
   //      System.out.println("Key found at :" + indx);
         
     //    int min = ex.findMin(score);
     //    System.out.println("Minimum Value :" +  min);
      //    int count = ex.countElements(score2, 12);
      //    System.out.println("No of times key is repeated : " + count);
      //   System.out.println(ex.binarySearch(score2, 12));
      //      int [] a = ex.reverseArray(score3);
      //      System.out.println(Arrays.toString(a));
            
       //     ex.swap(100, 200);
      //      ex.reverseArray2(score3);
       //     System.out.println(Arrays.toString(score3));
      //       int x = ex.findMin(new int[] {});
        //     int x1 = ex.findMin(null);
          //   System.out.println("Min Value :" + x1);
             
             //doSomething(min)
             
             int[][] gradesheet = new int[][] {
            		 {12,25,67}, // s1
            		 {26,67,12}, // s2
            		 {10,35}, // s3
            		 {45,24,67} // s4
             };
             
             System.out.println(Arrays.toString(gradesheet[0]));
             System.out.println(Arrays.toString(gradesheet[2]));
             System.out.println(gradesheet[2][0]);
	}

}
