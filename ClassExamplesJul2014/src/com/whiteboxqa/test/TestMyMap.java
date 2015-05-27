package com.whiteboxqa.test;

import java.util.Map;

import com.whiteboxqa.main.MyMap;

public class TestMyMap {

	public static void main(String[] args) {
		
		MyMap ex = new MyMap();
		
	//	Map<Integer,String> map = ex.createMap();
		
	  //  ex.printAllKeys(map);
	//	Map<String,String> map = ex.createNewHashTable();
	//	ex.printHashTable(map);
		//ex.printKeyValuePairs(map);
		
		ex.readConfig("C:\\Users\\Shilpi\\SkyDrive\\training\\address.properties", "city", "TX");
	}

}
