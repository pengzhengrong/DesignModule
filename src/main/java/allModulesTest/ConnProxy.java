package allModulesTest;

import java.lang.reflect.Proxy;


public class ConnProxy {

	public static IConnection createJdkProxy( ){
		IConnection jdkQuery = (IConnection) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()	, 
				new Class[]{ IConnection.class}, 
				new ConnProxyHandler());
		return jdkQuery;
	}
}
