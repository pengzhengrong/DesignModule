package threadTest;

import logUtil.LogUtil;

/**
 * 1 个主线程 控制4个次线程。
 * 虽然能够实现2个加2个减，但是线程的执行顺序却总是一样的。
 * @author pzr
 *
 */
public class ThreadTest3 implements Runnable{

	
	int i = 0;
	
	public static void main(String[] args) {
		ThreadTest3 t = new ThreadTest3();
		t.run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
/*		for( int k = 0 ; k < 2 ; k++){
			new Add().run();
		}
		
		for( int k = 0 ; k<2 ;k++ ){
			new Sub().run();
		}*/
		
		new Add().run();
		new Add().run();
		new Sub().run();
		new Sub().run();
		
		
		
	}
	
	
	public void add() throws InterruptedException{
		i++;
		LogUtil.debug(""+i);
	}
	
	public void sub(){
		i--;
		LogUtil.debug(i+"");
		
	}
	
	class Add implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				add();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	class Sub implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			sub();
		}
		
	}
	
	
}
