package GSFutureUtil;

import java.util.List;
import java.util.concurrent.FutureTask;

public class ClientThread extends Thread {

	private RequestQueue requestQueue ;
	public ClientThread( String threadName , RequestQueue requestQueue ) {
		// TODO Auto-generated constructor stub
		super(threadName);
		this.requestQueue = requestQueue;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			for( int i = 0 ; i < 10 ; i ++ ){
				//客户端负责发送请求
				Request request = new Request("Request"+i);
				requestQueue.addRequest(request);
			}
			
			
		}
		
		
}
