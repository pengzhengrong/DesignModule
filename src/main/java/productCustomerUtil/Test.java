package productCustomerUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import logUtil.LogUtil;

public class Test {

	public static void main(String[] args) {
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>();
		
		Productor p1 = new Productor(queue);
		Productor p2 = new Productor(queue);
		Productor p3 = new Productor(queue);
		
		Customer c1 = new Customer(queue);
		Customer c2 = new Customer(queue);
		Customer c3 = new Customer(queue);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);
		try {
			Thread.sleep(5000);
			p1.stop();
			p2.stop();
			p3.stop();
			Thread.sleep( 3000 );
			/*c1.stop();
			c2.stop();
			c3.stop();*/
			service.shutdown();
			LogUtil.debug(" over ... ");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
	}
	
}
