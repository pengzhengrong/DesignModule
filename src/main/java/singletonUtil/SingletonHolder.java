package singletonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 类天生对多线程友好，但是如果通过反射也可以实例化多个对象。这属于比较极端的情况。
 * 在正常情况下，也会出现实例化多个对象。那就是在序列化和反序列化的时候。
 * @author pzr
 *
 */
@SuppressWarnings("serial")
public class SingletonHolder implements Serializable{

	private int i = 0;
	
	private SingletonHolder(){
		System.out.println(" singleton is created!");
		System.out.println(++i);
	}
	
	
	//内部类
	private static class singleton{
		private static SingletonHolder singleton = new SingletonHolder();
	}
	
	//利用内部类调用
	public static SingletonHolder getInstance(){
		return singleton.singleton;
	}
	
	public static void createString(){
		System.out.println(" this is createString!");
	}
	
	//这个方法很重要，在序列化对象和反序列化对象的时候，如果没有这句话那么反序列化的对象不是同一个对象
	private Object readResolve(){
		return singleton.singleton;
	}
	
	public static void main(String[] args) {
//		SingletonHolder.createString();
		SingletonHolder singletonHolder = SingletonHolder.getInstance();
		//序列化对象
		String pathname = "/home/save/singleton.txt";
		File file = new File(pathname);
		//性能：对于try catch 也是比较占用性能的
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(singletonHolder);
			oos.flush();
			oos.close();
			fos.close();
			
			//反序列化
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				SingletonHolder singleton = (SingletonHolder) ois.readObject();
//				singleton.createString();
				if(singleton == singletonHolder){
					System.out.println("true");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
