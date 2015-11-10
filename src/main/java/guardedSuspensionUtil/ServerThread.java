package guardedSuspensionUtil;

/**
 * 服务线程 维护了一个请求队列和处理的线程
 * @author pzr
 *
 */
public class ServerThread extends Thread{

	private RequestQueue requestQueue ;
	
	public ServerThread( String name , RequestQueue requestQueue) {
		// TODO Auto-generated constructor stub
		//线程名称初始化
		super( name );
		this.requestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while( true ){
			//获取请求，如果当前请求为空那么等待
			Request request = requestQueue.getRequest();
			//处理请求
			System.out.println( Thread.currentThread().getName() +" handle "+ request.getName());
		}
	}
	
}
