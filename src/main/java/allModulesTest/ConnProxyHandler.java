package allModulesTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 动态代理类
 */
public class ConnProxyHandler implements InvocationHandler {

	private IConnection conn = null;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if( conn == null ){
			conn = new ConnPool("root","root","mysql").getConnection();
		}
		return conn.query();
	}

}
