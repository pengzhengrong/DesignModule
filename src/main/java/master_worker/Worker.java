package master_worker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable{

	//任务队列，用于取得子任务
	protected Queue<Object> workQuene ;
	//子任务处理结果集
	protected Map<String, Object> resultMap;
	
	/**
	 * worker：工人在任务没有完成的情况下，就得不停的去工作。
	 * 在workQueue 工作任务没有完成的情况下，就得干完一个任务在继续干另外一个任务。
	 * 如果是多个工人，那么这么多的工人共享所有的工作任务，直到所有的任务完成才都可以去休息。
	 */
	public void run() {
		// TODO Auto-generated method stub
		while ( true ){
			Object input = workQuene.poll();
			if( input == null ){
				break;
			}
			Object re = handle( input ) ;
			resultMap.put( Integer.toString(input.hashCode() ), re );
		}
	}
	
	//子任务处理的逻辑，在子类中实现具体的逻辑。
	public Object handle( Object input ){
		return input ;
	}


	public void setWorkQuene(Queue<Object> workQuene) {
		this.workQuene = workQuene;
	}


	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
	
	
	
	
	
}
