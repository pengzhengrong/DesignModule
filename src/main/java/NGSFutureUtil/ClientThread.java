package NGSFutureUtil;

import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread{

	private  RequestQueue requestQueue ;
	private List<Request> requestList = new ArrayList<Request>();
	
	public ClientThread( String threadName , RequestQueue requestQueue ) {
		// TODO Auto-generated constructor stub
		super( threadName );
		this.requestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		
		for( int i = 0 ;i < 10 ; i++ ){
			Request request = new Request( "Client"+i );
			//给客户端返回一个FutureData，快速构造。利用了future模式的优点
			request.setResponse(new FutureData() );
			requestQueue.addRequest(request);
			requestList.add(request);
		}
		
		for (Request request : requestList) {
			System.out.println( request.getResponse().getResponse() );
		}
		
	}
	
	
}
