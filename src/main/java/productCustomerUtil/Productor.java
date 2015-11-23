package productCustomerUtil;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import logUtil.LogUtil;

/**
 * 生产者，负责往缓冲区放东西，如果缓冲区满了则阻塞
 * 
 * @author pzr
 *
 */
public class Productor implements Runnable {

	private BlockingQueue<PCData> queue;

	private volatile boolean isRunning = true;

	private static AtomicInteger count = new AtomicInteger();
	
	private int SLEEP = 1000;

	public Productor(BlockingQueue<PCData> queue) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		PCData data = null;

		try {
			while (isRunning) {
				Thread.sleep( new Random().nextInt(SLEEP));
				data = new PCData(count.incrementAndGet());
				LogUtil.debug(" data is put into queue ");
				/*
				 * 将数据插入queue中，但是限制了timeout为2,TimeUnit 告知如何运行TimeOut
				 */
				if( queue.offer(data, 2, TimeUnit.SECONDS )){
					System.err.println( " failed put into queue");
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void stop(){
		isRunning = false;
	}

}
