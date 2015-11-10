package NGSFutureUtil;

public class ServiceThread extends Thread{

	private RequestQueue requestQueue;
	
	public ServiceThread( String threadName , RequestQueue requestQueue) {
		// TODO Auto-generated constructor stub
		super( threadName );
		this.requestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		while( true ){
			//获取请求
			Request request  = requestQueue.getRequest();
			//获取请求回应的对象
			FutureData future = (FutureData) request.getResponse();
			RealData realData = new RealData( request.getName() );
			future.setRealData(realData);
		}
	}
}
