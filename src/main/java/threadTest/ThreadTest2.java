package threadTest;

import logUtil.LogUtil;

/**
 * 多个线程间共享同一个变量 i
 * @author pzr
 *
 */
public class ThreadTest2 {

	static  int i  = 1;
	public static void main(String[] args) {
		
		new add(i , "test").start();
		new sub(i , "test").start();
		
	}
}

class add extends Thread{
	
	private int i ;
	
	public add( int i , String name ) {
		// TODO Auto-generated constructor stub
		super(name);
		this.i= i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i++;
		LogUtil.debug(""+i);
//		super.run();
	}
}

class sub extends Thread{
	
	private int i ;
	
	public sub( int i ,String name ) {
		// TODO Auto-generated constructor stub
//		LogUtil.debug( i+"");
		super( name );
		this.i= i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i--;
		LogUtil.debug(""+i);
//		super.run();
	}
}




