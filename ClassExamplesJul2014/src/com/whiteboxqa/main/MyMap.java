package com.whiteboxqa.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class MyMap {
	
	// StudentId:Password
	// Integer:String
	public Map<Integer,String> createMap(){
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(100,"wbqa");
		map.put(101, "wbl");
		map.put(987, "test");
		map.put(1999,null);
		map.put(null,"100");
		
		return map;
	}
	
	public void printAllKeys(Map<Integer,String> m){
		
		Set<Integer> allKeys = m.keySet();
		
		System.out.println(allKeys);
		
	}
	
	public void printKeyValuePairs(Map<Integer,String> m){
		
		Set<Integer> allKeys = m.keySet();
		Iterator<Integer> it = allKeys.iterator();
		while (it.hasNext()){
			Integer key = it.next();
			String value = m.get(key);
			
			System.out.println(key + "=" + value);
		}
	}
	// dbuser=hr
	//dbpswd = wbqa
	public Map<String,String> createNewHashTable(){
		
		Map<String,String> map = new Hashtable<String,String>();
		
		map.put("dbuser","hr");
		map.put("dbpaswd", "wbqa");
		map.put("dbpaswd", "whteboxqa");
	//	map.put("dburl", null);
	//	map.put(null, "test");
		
		return map;
	}
	
	public void printHashTable(Map<String,String> m){
		
		Set<String> allKeys = m.keySet();
		Iterator<String> it = allKeys.iterator();
		while (it.hasNext()){
			String key = it.next();
			String value = m.get(key);
			
			System.out.println(key + "=" + value);
		}
		
	}

	// wbqasys.properties file
	// user=hr , pswd=wbqa, url=http://whiteboxqa.com
	// Find the value of user in wbqasys.proprties. If found replace the value by admin
	// else create the new value
	public void readConfig(String filepath, String key, String newvalue){
		
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(filepath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		boolean ret = p.containsKey(key);
		if (ret == false ) {
			System.out.println("Key not found. Creating one..");
		}
		else 
			System.out.println("Key found. replaing with new value");
		
		p.put(key, newvalue);
		
		Set<Entry<Object, Object>>pairs = p.entrySet();
		Iterator<Entry<Object, Object>> it = pairs.iterator();
		while (it.hasNext()){
			
			Object keyvalue = it.next();
			System.out.println(keyvalue);
		}
		
		
		
	}
	
}
