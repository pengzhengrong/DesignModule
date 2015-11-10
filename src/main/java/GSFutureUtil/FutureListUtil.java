package GSFutureUtil;

import java.util.List;
import java.util.Vector;

public class FutureListUtil {

	private static List<Request> futureList  ;
	
	private FutureListUtil(){}
	
	public static List<Request> getFutures(){
		if( futureList == null ){
			futureList  = new Vector<Request>();
		}
		
		return futureList;
	}
	
	
}
