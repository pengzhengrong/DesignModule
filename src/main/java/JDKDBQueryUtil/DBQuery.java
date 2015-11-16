package JDKDBQueryUtil;

import java.lang.reflect.Proxy;

public class DBQuery implements IDBQuery{

	public DBQuery() {
		// TODO Auto-generated constructor stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "I am real Handler ";
	}
	
/*	public static DBQuery createJdkProxy( ){
		DBQuery jdkQuery = (DBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()	, 
				new Class[]{ DBQuery.class}, 
				new JdkDBQueryHandler());
		return jdkQuery;
	}*/

}
