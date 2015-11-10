package NGSFutureUtil;

public class Test {

	
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		
		//启动服务器
		new ServiceThread("service1", requestQueue).start();
		
		//启动客户端
		new ClientThread("client1", requestQueue).start();
		
	}
}
