package allModulesTest;

import java.util.NoSuchElementException;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import logUtil.LogUtil;

public class ConnPool {
	
	private static  String user ;
	private static  String pwd;
	private static  String url;
	
	//利用单例模式获取ObjectPool
	
	public ConnPool( String user , String pwd , String url){
		this.user = user;
		this.pwd = pwd;
		this.url   =  url;
	}
	
	private static class init{
		private static PoolableObjectFactory<Connection> factroy = new ConnPoolFactroy(  user ,  pwd ,  url  );
		private static ObjectPool<Connection> objectPool = new GenericObjectPool<Connection>( factroy );
	} 
	
	public static Connection getConnection() throws NoSuchElementException, IllegalStateException, Exception{
		return init.objectPool.borrowObject();
	}
	
	public static boolean returnConnection( Connection conn ){
		try {
			init.objectPool.returnObject(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}
