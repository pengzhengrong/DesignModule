package allModulesTest;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertWorker extends Worker{

	Logger Log = LoggerFactory.getLogger("WORKER");
	public Object handle( Queue<Object> workQueue ) {
		
		return 1;
	}
	
	@Override
	public Object handle(Object object) {
		// TODO Auto-generated method stub
//		System.out.println(1);
		return object;
	}
	
}
