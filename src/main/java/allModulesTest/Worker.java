package allModulesTest;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author pzr
 *
 */
public class Worker implements Runnable{

	Logger Log = LoggerFactory.getLogger("WORKER");
	//干什么
	//什么事
	protected Map<Object , Object > resultMap;
	protected Queue<Object> workQueue;
	//怎么干
	public Object handle( Object object ){
		
		return object;
	}

	
	//去干
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while ( true ){
			Object input = workQueue.poll();
			if( input==null ){
				System.out.println(" break ");
				break ; 
			}
			Object res = handle(input);
			resultMap.put(input.hashCode() , res ) ;
		} 
	}


	public void setResultMap(Map<Object, Object> resultMap) {
		this.resultMap = resultMap;
	}


	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}


	
}
