package JDKDBQueryUtil;

import java.lang.reflect.Proxy;

public class JDKProxy {
	public static IDBQuery createJdkProxy( ){
		IDBQuery jdkQuery = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()	, 
				new Class[]{ IDBQuery.class}, 
				new JdkDBQueryHandler());
		return jdkQuery;
	}
}
