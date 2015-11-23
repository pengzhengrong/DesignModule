package threadPoolUtil;

import logUtil.LogUtil;

public class PThread extends Thread {

	private Runnable target;

	private ThreadPool threadPool;

	public synchronized void addTask(Runnable target, ThreadPool threadPool) {
		this.target = target;
		this.threadPool = threadPool;
//		notify();
		notifyAll();
		// this.start();
		// new Thread( target ).start();

	}

	public PThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {

		while (true) {
			if (target != null) {
				target.run();
				this.threadPool.returnThread(this);
			}
			try {
				synchronized (this) {
					LogUtil.debug(" wait :" + this.getName());
					wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
