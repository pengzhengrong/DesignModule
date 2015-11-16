package javassistConnUtil;

import allModulesTest.IConnection;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class JavassistConnProxy {

	
	public static IConnection createJavassistProxy() throws InstantiationException, IllegalAccessException{
		ProxyFactory proxyFactory = new ProxyFactory();
		 proxyFactory.setInterfaces( new Class[]{ IConnection.class });
		 Class proxyClass = proxyFactory.createClass();
		 IConnection javassistProxy = (IConnection) proxyClass.newInstance();
		 ((ProxyObject)javassistProxy).setHandler( new JavassistConnProxyHandler() );
		 return javassistProxy;
	}
}
