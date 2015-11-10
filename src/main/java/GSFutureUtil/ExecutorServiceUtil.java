package GSFutureUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ExecutorServiceUtil {

	
	private ExecutorServiceUtil(){}
	private static  int nThread ;
	private static class init{
		private static ExecutorService service = Executors.newFixedThreadPool(nThread);
	}
	
	public static ExecutorService getService( int nThread ){
		ExecutorServiceUtil.nThread = nThread;
		return init.service;
	}
	
	public static void shutDown(){
		init.service.shutdown();
	}
	
	public static void submit( FutureTask<Request> future ){
		init.service.submit(future);
	}
	
	private Object readResolve(){
		return init.service;
	}
	
	
	
	
}
