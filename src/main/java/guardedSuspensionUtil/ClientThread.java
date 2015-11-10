package guardedSuspensionUtil;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 客户端线程
 * @author pzr
 *
 */
public class ClientThread extends Thread{

	private RequestQueue requestQueue;
	
	public ClientThread( String name , RequestQueue requestQueue ) {
		// TODO Auto-generated constructor stub
		super( name );
		this.requestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		//构造了10个请求，模拟一个用户发出10个请求
		for( int i = 0; i< 10 ; i++ ){
			//构造请求，参数为线程名称和字符拼接而成
			Request request = new Request(Thread.currentThread().getName() + " request"+i );
			//提交请求
			requestQueue.addRequest(request);
		}
		
		
		
	}

	
	
}
