package poolUtil;

import java.util.NoSuchElementException;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

public class PoolableObjectFactoryImpl implements PoolableObjectFactory<Connection>{

	//调用对象激活
	@Override
	public void activateObject(Connection arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" 调用对象" + arg0 );
	}

	//销毁对象激活
	@Override
	public void destroyObject(Connection arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" 销毁对象" + arg0 );
	}

	//创建对象
	@Override
	public Connection makeObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" 创建对象"  );
		return new Connection();
	}

	//返回对象激活
	@Override
	public void passivateObject(Connection arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" 返回对象" + arg0 );
	}

	//验证对象是否可用
	@Override
	public boolean validateObject(Connection arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}


class ConnPool{
	
	private ConnPool(){
		
	}
	
	private static  class init{
		private static PoolableObjectFactory<Connection> factory = new PoolableObjectFactoryImpl();
		//当然，在实例化对象池的时候，可以使用其他的构造方法以实现配置对象池
		private static  ObjectPool<Connection> connPool = new GenericObjectPool<Connection>(factory);
	} 
	
	public static Connection getConnection() throws NoSuchElementException, IllegalStateException, Exception{
		return init.connPool.borrowObject();
	}
	
	public static void close( Connection conn ) throws Exception{
		init.connPool.returnObject( conn );
	}
	
}
