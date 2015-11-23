package threadTest;


import logUtil.LogUtil;

/**
 * ok . 主函数 里面有两个内部类，内部类实现加减1. 
 * 主函数不需要是线程，但是要使多个子线程能够共享1个变量i，所以用内部类实现。
 * 内部类不能够直接被调用，但是在主函数中可以通过主函数的方法调用。
 * 在线程当中实例化2个线程，那么线程的执行过程是有前后顺序的。但是如果在一个普通的方法当中执行，那么是没有
 * 优先权的。
 * @author pzr
 *
 */
public class ThreadTest4  extends Thread{

	private int i = 0 ;
	
	public static void main(String[] args) {
		new ThreadTest4().test();
//		new ThreadTest4().start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		new T1().start();
		new T1().start();
		new T2().start();
		new T2().start();
	}
	
	public void test(){
		new T1().start();
		new T1().start();
		new T2().start();
		new T2().start();
	}
	
	class T1 extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			super.run();
			add();
		}
	}
	
	class T2 extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			super.run();
			sub();
		}
	}
	
	public synchronized void add(){
		i++;
		LogUtil.debug(""+i);
	}
	
	public synchronized void sub(){
		i--;
		LogUtil.debug(""+i);
	}
	
	
}
