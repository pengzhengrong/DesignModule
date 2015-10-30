package master_worker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable{

	//任务队列，用于取得子任务
	protected Queue<Object> workQuene ;
	//子任务处理结果集
	protected Map<String, Object> resultMap;
	
	
	public void run() {
		// TODO Auto-generated method stub
		while ( true ){
			Object input = workQuene.poll();
			if( input == null ){
				break;
			}
			Object re = handle(input);
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
