package threadTest;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

import logUtil.LogUtil;

public class T2Test {

	public static void main(String[] args) {
		Queue<Integer> vector = new ConcurrentLinkedQueue<Integer>();
		for (int i = 0; i < 2; i++) {
			new T11(vector, i + "").start();
		}

		for (int i = 0; i < 2; i++) {
			new T22(vector, i + "d").start();
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

class T11 extends Thread {

	private Queue<Integer> vector;

	public T11(Queue<Integer> vector, String name) {
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

class T22 extends Thread {

	private Queue<Integer> vector;

	public T22(Queue<Integer> vector, String name) {
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
				int ra = vector.poll();
				LogUtil.debug(" remove " + ra + " success ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


