package GSFutureUtil;

import java.util.concurrent.Callable;

public class RealData implements Callable<Request>{

	private Request request;
	
	public RealData( Request request ) {
		// TODO Auto-generated constructor stub
		this.request = request;
	}
	
	@Override
	public Request call() throws Exception {
		// TODO Auto-generated method stub
		return handle(request);
	}
	
	private Request handle( Request request ){
		String response = request.getName() + " test ";
		request.setResponse( response );
		return request;
	}
	
}
