package CollectionUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapUtil {

	
	public static void main(String[] args) {
		
		new T1().run();
		// 验证单例模式为同一个hashMap， true
//		new T11().run();
		
		new T2().run(); 
		new T3().run();
		new T4().run();
		
		
		
	}
}



class T1 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Map<Object , Object> hashMap = CollectionFactory.getFactory( "hashMap");
		for (int i = 0; i < 10; i++) {
			hashMap.put("key"+i, "value"+i);
		}
		
		for( Map.Entry<Object, Object> map : hashMap.entrySet()){
			String temp = (String) map.getValue();
			System.out.print(temp + " ");
		}
		System.out.println("\n-----------------------------------------------------------");
	}
}

class T11 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Map<Object , Object> hashMap = CollectionFactory.getFactory( "hashMap");
		for (int i = 10; i < 20; i++) {
			hashMap.put("key"+i, "value"+i);
		}
		for( Map.Entry<Object, Object> map : hashMap.entrySet()){
			String temp = (String) map.getValue();
			System.out.print(temp + " ");
		}
		System.out.println("\n-----------------------------------------------------------");
	}
}


class T2 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Map<Object, Object> hashTable = CollectionFactory.getFactory("hashTable");
		
		for (int i = 0; i < 10; i++) {
			hashTable.put("key"+i, "value"+i);
		}
		
		for( Map.Entry<Object, Object> map : hashTable.entrySet()){
			String temp = (String) map.getValue();
			System.out.print( temp + " ");
		}
		
		System.out.println("\n-----------------------------------------------------------");
		
	}
	
}

class T3 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		Map<Object, Object> treeMap  = CollectionFactory.getFactory("treeMap");
		/*for (int i = 0; i < 10; i++) {
			treeMap.put("key"+i, "value"+i);
		}
		
		for( Map.Entry<Object, Object> map : treeMap.entrySet()){
			String temp = (String) map.getValue();
			System.out.print(temp + " ");
		}
		System.out.println("\n-----------------------------------------------------------");*/
		
		Student s1 = new Student("zs", 60);
		Student s2 = new Student("ls", 50);
		Student s3 = new Student("ww", 70);
		Student s4 = new Student("mz", 80);
		Student s5 = new Student("zy", 90);
		
		treeMap.put(s1, s1.toString());
		treeMap.put(s2, s2.toString());
		treeMap.put(s3, s3.toString());
		treeMap.put(s4, s4.toString());
		treeMap.put(s5, s5.toString());
		
		Map<Object , Object> map1 = ((TreeMap)treeMap).headMap(s1);
		map1 = ((TreeMap)treeMap).subMap(s1, s5);
		map1 = ((TreeMap)treeMap).tailMap(s1);
		
		for( Map.Entry map : map1.entrySet() ){
			String student = (String) map.getValue();
			System.out.println(student);
		}
		
		
	}
	
}

class T4 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub

		Map<Object, Object> linkedHashMap  = CollectionFactory.getFactory("LinkedHashMap");
		for (int i = 0; i < 10; i++) {
			linkedHashMap.put("key"+i, "value"+i);
		}
		for( Map.Entry<Object, Object> map : linkedHashMap.entrySet()){
			String temp = (String) map.getValue();
			System.out.print(temp + " ");
		}
		System.out.println("\n-----------------------------------------------------------");

		//LinkedHashMap 按照 查找的时间排序
		Map<Object , Object > map = new LinkedHashMap<Object, Object>(16,0.75f,true);
		for (int i = 0; i < 10; i++) {
			map.put("key"+i, "value"+i);
		}
		for( Map.Entry<Object, Object> e : map.entrySet()){
			String temp = (String) e.getValue();
			System.out.print(temp + " ");
		}
		
		System.out.println("\n-----------------------------------------------------------");
		
		// 报错 ，原因在遍历集合的时候修改集合的结构
	/*	
		for( Iterator it = map.keySet().iterator() ; it.hasNext() ; ){
			String name = (String) it.next();
			System.out.println(map.get(name));
		}*/
		
		//获取key3,那么key3是否会在第一个位置出现: 出现在链尾
		System.out.println(map.get("key3"));
		for( Map.Entry<Object, Object> e : map.entrySet()){
			String temp = (String) e.getValue();
			System.out.print(temp + " ");
		}
		
		
		System.out.println("\n-----------------------------------------------------------");
		
		
		
	}
	
}


class HashMapUtil{
	
	private HashMapUtil( ){
		
	}
	
	private  int size = 0;
	
	private static class init{
		private static Map<Object, Object> hashMap = new HashMap<Object, Object>();
		private static Map<Object ,Object> hashMap2 = new HashMap<Object, Object>(100);
	}
	
	public static Map<Object , Object > getMap(){
		return init.hashMap;
	}
	
	public static Map<Object , Object > getMap( int size ){
		return init.hashMap2;
	}
	
	
}

class LinkedHashMapUtil{
	private static class init{
		private static Map<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
	}
	
	public static Map<Object , Object > getMap(){
		return init.linkedHashMap;
	}
}

class HashTableUtil{
	private static class init{
		private static Map<Object, Object> hashTable = new Hashtable<Object, Object>();
	}
	
	public static Map<Object , Object > getMap(){
		return init.hashTable;
	}
}

class TreeMapUtil{
	private static class init{
		private static Map<Object, Object> treeMap = new TreeMap<Object, Object>();
	}
	
	public static Map<Object , Object > getMap(){
		return init.treeMap;
	}
}


class CollectionFactory{
	
	public static Map<Object, Object > getFactory( String type ){
		if( type.toLowerCase().equals("hashmap") ){
			return HashMapUtil.getMap();
		}
		
		if( type.toLowerCase().equals("hashtable") ){
			return HashTableUtil.getMap();
		}
		
		if( type.toLowerCase().equals("treemap") ){
			return TreeMapUtil.getMap();
		}
		
		if( type.toLowerCase().equals("linkedhashmap") ){
			return LinkedHashMapUtil.getMap();
		}
		
		
		
		return null;
	}
	
}



class Student implements Comparable<Student>{

	public Student( String name , int score ){
		this.name = name;
		this.score = score;
	}
	
	private String name ;
	private int score;
	
	
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if( o.score < this.score ){
			return 1;
		}else if( o.score > this.score ){
			return -1;
		}
		return 0;
	}
	
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:"+name+" score:"+score;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
} 
