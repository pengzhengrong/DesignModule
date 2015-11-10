package GSFutureUtil;

import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.FutureTask;

public class Test {
	
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		//启动服务器
		new ServiceThread("ServiceThread1", requestQueue ).start();
		
		
		//启动客户端请求
		new ClientThread("ClientThread", requestQueue).start();
		
		
		
		
		
	}

}
