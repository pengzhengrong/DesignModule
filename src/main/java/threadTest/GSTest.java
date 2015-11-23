package threadTest;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import logUtil.LogUtil;

public class GSTest {

	public static void main(String[] args) {
		
		RequestQueue requestQueue = new RequestQueue();
		for( int i = 0 ; i < 10 ; i++ ){
			new Service(requestQueue, "service"+i).start();;
		}
		
		for( int i = 0 ; i< 10 ; i++ ){
			new Client(requestQueue, "client"+i).start();
		}
		
		try{
			Thread.sleep(1000);
		}catch( Exception e ){
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------------------");
		
		
		for( int i = 10 ; i< 15 ; i++ ){
			new Client(requestQueue, "client"+i).start();
		}
		
	}
}

class Client extends Thread{
	
	private RequestQueue requestQueue;
	
	public Client( RequestQueue requestQueue , String threadName ) {
		// TODO Auto-generated constructor stub
		super(threadName);
		this.requestQueue = requestQueue;
	}
	
	@Override
	public void run() {
		Request request = new Request() ;
		request.setRequest( this.getName() );
		requestQueue.add( request );
		LogUtil.debug( this.getName() +" client add " + request.getRequest() );
	}
	
}

class Service extends Thread{
	
	private RequestQueue requestQueue ;
	
	public Service( RequestQueue requestQueue , String threadName ) {
		super( threadName );
		this.requestQueue = requestQueue ;
	}
	
	@Override
	public void run() {
		
		while( true ){
			Request request = requestQueue.get();
			LogUtil.debug(this.getName() + " handle question "+request.getRequest() );
		}
		
	}
	
	
}

class RequestQueue{
	
	private Queue<Request> requestQueue = new ConcurrentLinkedQueue<Request>();
	
	public synchronized void add( Request request ){
		requestQueue.add( request );
		notifyAll();
	}
	
	public synchronized Request get(){
		try{
			while( requestQueue.size() == 0){
				wait();
			}
		}catch( Exception e ){
			e.printStackTrace();
		}
		Request request = requestQueue.poll();
		return request;
	}
	
	
	
}

class Request{
	private String request;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
