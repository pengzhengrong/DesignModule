package javassistConnUtil;

import java.lang.reflect.Method;

import allModulesTest.ConnPool;
import allModulesTest.IConnection;
import javassist.util.proxy.MethodHandler;

public class JavassistConnProxyHandler implements MethodHandler{

	private IConnection conn = null;
	
	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if( conn == null ){
			conn = new ConnPool("root", "root", "mysql").getConnection();
		}
		return conn.query();
	}

}
