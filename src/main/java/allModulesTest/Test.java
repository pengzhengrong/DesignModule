package allModulesTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	//日志
	static Logger Log = LoggerFactory.getLogger("STDOUT");
	
	//连接数据库
	
	//获取返回数据
	public List<Object> getList(){
		List<Object> list = new ArrayList<Object>(); 
		for( int i = 0 ; i< 100 ; i++ ){
			list.add(i);
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		
		List<Object> list = new ArrayList<Object>(); 
		for( int i = 0 ; i< 100 ; i++ ){
			list.add(i);
		}
		Log.debug("list size :"+ list.size() );
		//master处理列表
		//初始化工人和主人
//		Worker worker = new InsertWorker(); 
		Master master = new Master(  new InsertWorker() , 5 );
		//master添加事务
/*		for ( Iterator<Object> it = list.iterator() ; it.hasNext() ;){
			master.submit(it.next());
		} */
		master.submit( list );
		//master通知worker处理事件
		master.inform();
		//返回结果集
		Map<Object , Object > map = new ConcurrentHashMap<Object	, Object >();
		map = master.getResultMap();
		int sum = 0;
		while( !master.isCompeter() || map.size() > 0 ){
			Object key = null ;
			for( Map.Entry<Object, Object > e : map.entrySet()){
				key = e.getKey();
				break;
			}
			if( key != null ){
				sum += (Integer)map.get( key );
				map.remove(key);
			}
			
		}
		
		System.out.println( sum );
		
	}
	
	
}
