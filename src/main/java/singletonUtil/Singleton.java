package singletonUtil;

/**
 * 单例模式：不好的原因是因为调用单例中其他的方法时。单例也会被创建
 * 
 */
public class Singleton {

	private Singleton(){
		System.out.println("singleton is created!");
	}
	private static Singleton singleton = new Singleton();
	private static Singleton initSingleton(){
		return singleton;
	}
	
	
	public static Singleton getInstance(  ){
		return initSingleton();
	}
	
	public static void createString(){
		System.out.println(" this is a String!");
	}
	
	public static void main(String[] args) {
		Singleton.createString();
	}
	
}

