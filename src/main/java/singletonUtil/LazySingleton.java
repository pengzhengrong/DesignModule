package singletonUtil;

/**
 * 不足之处：当多线程调用的时候，会出现问题
 * 用户1正在初始化，而用户2也调用，导致多个实例被创建。所以在实例化对象的时候需要同步关键字
 * @author pzr
 *
 */
public class LazySingleton {

	private LazySingleton(){
		System.out.println(" LazySingleton is created!");
	}
	
	private static LazySingleton singleton = null;
	
	public static LazySingleton getInstance(){
		if( singleton == null ){
			singleton = new LazySingleton();
		}
		
		return singleton;
	}
	
	public static void createString(){
		System.out.println(" create String");
	}
	
	
	public static void main(String[] args) {
		LazySingleton.createString();
		LazySingleton.getInstance();
	}
	
}
