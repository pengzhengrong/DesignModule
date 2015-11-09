package jdkFutureUtil;

import java.util.concurrent.Callable;

public class RealData implements Callable<String>{

	protected String result ;
	
	public String query;
	
	public RealData( String query ){
		this.query = query ;
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(query);
		for( int i = 0; i< 5 ; i++ ){
			sb.append(i);
		}
		return sb.toString();
	}

}
