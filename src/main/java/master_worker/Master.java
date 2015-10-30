package master_worker;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	//任务队列
	protected Queue<Object> workQuene = new ConcurrentLinkedQueue<Object>();
	//worker进程队列
	protected Map<String, Thread> threadMap = new ConcurrentHashMap<String, Thread>();
	//子结果集队列
	protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
	
	
	//初始化Master进程
	public Master( Worker worker , int countWorker ){
		
		//通知worker，有活要干了。
		worker.setWorkQuene(workQuene);
		//通知worker，结果放在哪里
		worker.setResultMap(resultMap);
		
		for (int i = 0; i < countWorker; i++) {
			threadMap.put( Integer.toString( i ) , new Thread( worker, Integer.toString( i ) ) );
		}
	}
	
	//判断worker进程是否都已经结束
	public boolean isComplete(){
		
		for( Map.Entry<String, Thread> e : threadMap.entrySet() ){
			if( e.getValue().getState() != Thread.State.TERMINATED ){
				return false;
			}
		}
		return true;
	}
	
	//执行worker中主要的处理逻辑
	public void execute(){
		for( Map.Entry<String, Thread> e : threadMap.entrySet() ){
			e.getValue().start();
		}
	}
	
	//接任务，给worker去做
	public void submit( Object job ){
		workQuene.add( job );
	}
	
	
	//获取最后的结果
	public Map<String, Object> getResultMap(){
		return resultMap;
	}
	
	
	
	
	
	
	
}
