package threadTest;

import logUtil.LogUtil;
/**
 * failed 处理的不是同一个对象
 * @author pzr
 *
 */
public class ThreadTest {
	static int i =  0;
	public static void main(String[] args) {
		
		/*AddThread a1 = new AddThread(i);
		AddThread a2 = new AddThread(i);
		subThread s1 = new subThread(i);
		subThread s2 = new subThread(i);*/
/*		a1.run();
		a2.run();
		s1.run();
		s2.run();*/
		
		new AddThread(i).run();
		new AddThread(i).run();
		new subThread(i).run();
		new subThread(i).run();
		
		
	}
	
}

class AddThread implements Runnable{

	private int i ;
	
	public AddThread( int i ) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i++;
		LogUtil.debug( i +"" );
	}
	
}

class subThread implements Runnable {

	private int i ;
	
	public subThread( int i ) {
		// TODO Auto-generated constructor stub
		this.i = i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i--;
		LogUtil.debug(i+"");
	}
	
}
