package cglibConnUtil;


import java.lang.reflect.Method;

import allModulesTest.ConnPool;
import allModulesTest.Connection;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibConnInterceptor implements MethodInterceptor{

	private Connection conn = null;

	/**
	 * interceptor 拦截，侦听
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		if( conn == null ){
			conn = new ConnPool("root", "root", "mysql").getConnection();
		}
		return conn.query();
	}
	


}
