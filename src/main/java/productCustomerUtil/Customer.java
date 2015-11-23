package productCustomerUtil;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

import logUtil.LogUtil;

public class Customer implements Runnable{

	private BlockingQueue<PCData> queue ;
	
	private volatile boolean isRunning = true;
	
	private int SLEEP = 1000;
	
	public Customer( BlockingQueue<PCData>  queue ) {
		// TODO Auto-generated constructor stub
		this.queue = queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(isRunning){
				PCData data = queue.take();
				if( null != data ){
					int re = data.getData() * data.getData() ;
					System.out.println( MessageFormat.format("{0} * {1} = {2}", data.getData() , data.getData() , re ));
				}
				Thread.sleep( new Random().nextInt( SLEEP ));
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
