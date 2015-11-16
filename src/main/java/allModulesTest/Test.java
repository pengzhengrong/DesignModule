package allModulesTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	//日志
	static Logger Log = LoggerFactory.getLogger("STDOUT");
	
	public static void main(String[] args) {
		
		/*
			//连接数据库  模拟连接池，可是却无法传参。该如何处理
			//池只有一个，按理说应该只有一个池，可是因为为了带参，所以实例化了2个池。但是2个池却能同时拥有同一个对象
			//也就是说，虽然池不一样，但是却共有同一个池的对象。可以理解为：
			// ConnPool1 -> connPool0  , connPool2 -> connPool0  
			//当然还有其他的实现方式。这个方式很奇怪。或许这个方式的缺陷是因为jdk动态代理的缺陷，
			 * 因为jdk的动态代理不能够传参。
		*/
		/*try {
			ConnPool connPool = new ConnPool("root","root","mysql");
			ConnPool connPool2 = new ConnPool("root","root","mysql");
			Connection conn =connPool.getConnection();
			connPool.returnConnection(conn);
			Connection conn2 =connPool2.getConnection();
			if( connPool == connPool2 ){
				Log.debug("connPool == connPool2 ");
			}
			
			if( conn != conn2){
				Log.debug("conn != conn2 ");
			}else{
				Log.debug( conn +" == " + conn2 );
			}
		} catch (NoSuchElementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		
		IConnection conn = ConnProxy.createJdkProxy();
		//conn query 如果没有调用，那么conn是不会实例化的，只有当调用conn的方法时候，才会去实例化conn对象。
		String str = conn.query();
//		Log.debug(str);
		
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
