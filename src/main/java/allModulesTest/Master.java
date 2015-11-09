package allModulesTest;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author pzr
 *
 */
public class Master {

	//员工列表
	protected Map<String , Thread> workers = new ConcurrentHashMap<String, Thread>();
	//事件队列
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();
	//结果集
	protected Map<Object , Object > resultMap = new ConcurrentHashMap<Object	, Object>();
	
	//构造员工,构造员工的时候，也是告诉员工该干什么和把工作结果放置何处
	public Master( Worker worker , int workCount ){
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for( int i = 0 ; i < workCount ; i++ ){
			workers.put( Integer.toString(i), new Thread( worker , Integer.toString(i)));
		}
	}
	
	
	//通知员工去干活
	public void inform(){
		for( Map.Entry<String, Thread> work : workers.entrySet() ){
			work.getValue().start();
		}
	}
	//判断员工是否工作完成
	public boolean isCompeter(){
		for( Map.Entry<String, Thread> work : workers.entrySet() ){
			if( work.getValue().getState() != Thread.State.TERMINATED ){
				return false;
			}
		}
		return true;
	}
	//接收业务
	public void submit( Object work){
		workQueue.add( work );
	}
	//接收业务2
	public void submit( List<Object> workList ){
		workQueue.addAll(workList);
	}



	public Map<String, Thread> getWorkers() {
		return workers;
	}


	public Queue<Object> getWorkQueue() {
		return workQueue;
	}


	public Map<Object, Object> getResultMap() {
		return resultMap;
	}
	
	
	
	
}
