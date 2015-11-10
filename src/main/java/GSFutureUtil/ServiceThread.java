package GSFutureUtil;

import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ServiceThread extends Thread {

	private RequestQueue requestQueue;

	public ServiceThread(String threadName, RequestQueue requestQueue ) {
		// TODO Auto-generated constructor stub
		super(threadName);
		this.requestQueue = requestQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(2);
//		ExecutorService service = ExecutorServiceUtil.getService(2);
		FutureTask<Request> future = null;
		while (true) {
			//获取请求，如果此时的请求队列为空，那么wait
			Request request = requestQueue.getRequest();
			//处理请求
			RealData data = new RealData(request);
			future  = new FutureTask<Request>(data);
			service.submit(future);
		
try {
				System.out.println(future.get().getResponse());
//				FutureListUtil.getFutures().add(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	
	
	

}
