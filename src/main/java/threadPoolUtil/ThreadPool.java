package threadPoolUtil;

import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

import logUtil.LogUtil;

public class ThreadPool {

	private static Thread instance = null;

	private static ThreadPool instancePool = new ThreadPool();

	private Queue<PThread> queue;

	private boolean isEmpty = true; // 池中是否存在对象

	private static int countThread;

	private ThreadPool() {
		queue = new ConcurrentLinkedQueue<PThread>();
		countThread = 0;
	}

	public static ThreadPool getInstanceThreadPool() {
		return instancePool;
	}

	private static class init {
		private static ThreadPool threadPool = new ThreadPool();
	}

	public static ThreadPool getInstance() {
		return init.threadPool;
	}

	// 获取线程
	public synchronized PThread getThread() {
		/*
		 * try{ while (getInstance().queue.size() == 0) { LogUtil.debug(
		 * " failed get thread , pool is empty  "); wait(); // 这里不能使用wait
		 * ，那么可以使用变量开关控制。 think：观察者模式 } }catch( Exception e ){
		 * e.printStackTrace(); } return getInstance().queue.poll();
		 */
		try {
			while( getInstance().queue.size() == 0){
				LogUtil.debug(" is empty of the pool , need to wait ");
				getInstance().wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getInstance().queue.poll();
	}

	// 归还线程
	public synchronized void returnThread(PThread t) {
		getInstance().queue.add(t);
		LogUtil.debug(" return thread :" + t.getName());
		// 通知获取对象的方法，可以获取对象了
		getInstance().notify();
	}

	// 线程工作
	public static  void start(Runnable task) {
		
		PThread t = getInstance().getThread();
		LogUtil.debug("  get " + t.getName() + " thread success ,pool remaining thread num  "
				+ getInstance().queue.size());
		t.addTask(task, getInstance());
		
		 /*PThread t = null;
		if (getInstance().queue.size() > 0) {
			t = getInstance().getThread();
			LogUtil.debug("  get " + t.getName() + " thread success ,pool remaining thread num  "
					+ getInstance().queue.size());
			t.addTask(task, getInstance());

		}else {
//			LogUtil.debug(" wait because is empty");
			try {
//				Thread.sleep(100); //加上睡眠就可以执行。
				getInstance().wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/

	}

	// 生产线程
	public static void addThread(int count) {
		for (int i = 0; i < count; i++) {
			PThread t = new PThread(i + "");

			getInstance().queue.add(t);
			LogUtil.debug(" add thread " + t.getName() + " success ");
			t.start();
			countThread++;
		}
	}

	// 显示线程池中的所有线程
	public static void showThread() {
		Iterator<PThread> iterator = getInstance().queue.iterator();
		while (iterator.hasNext()) {
			LogUtil.debug(" Thread : " + iterator.next().getName());
		}
	}

	public static int getThreadCount() {
		return countThread;
	}

}
