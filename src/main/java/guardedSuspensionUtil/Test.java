package guardedSuspensionUtil;

public class Test {

	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();

		// 服务进程开启,开启了10个线程，10个线程处理请求队列中的请求
		for (int i = 0; i < 10; i++) {
			new ServerThread("ServerThread" + i, requestQueue).start();
		}
		// 客户端请求进程开启，一个用户发送的请求
		new ClientThread("ClientThread", requestQueue).start();
		//模拟10个用户发送请求，那么每个用户发送10个，则是一共100个请求。
//		for( int i = 0 ; i< 10 ; i++ ){
//			new ClientThread("ClientThread"+i, requestQueue).start();
//		}

	}
}
