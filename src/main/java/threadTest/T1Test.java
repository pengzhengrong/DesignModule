package threadTest;

import java.util.Random;
import java.util.Vector;

import logUtil.LogUtil;

public class T1Test {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < 2; i++) {
			new T1(vector, i + "").start();
		}

		for (int i = 0; i < 2; i++) {
			new T2(vector, i + "d").start();
		}
/*		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println( vector.size() );
		
/*		for (Integer e : vector) {
			System.out.println( e );
		}
*/
		/*
		 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}
}

class T1 extends Thread {

	private Vector<Integer> vector;

	public T1(Vector<Integer> vector, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.vector = vector;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		int ra = new Random().nextInt(10);
		LogUtil.debug("random is " + ra);
		vector.add(ra);
		LogUtil.debug(" add " + ra + " success ");
	}
}

class T2 extends Thread {

	private Vector<Integer> vector;

	public T2(Vector<Integer> vector, String name) {
		// TODO Auto-generated constructor stub
		super(name);
		this.vector = vector;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// super.run();
		try {
//			Thread.sleep(300);
				while(vector.size() == 0) {
					LogUtil.debug("wait");
					wait();
				}
				int ra = vector.remove(vector.size() - 1);
				LogUtil.debug(" remove " + ra + " success ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


