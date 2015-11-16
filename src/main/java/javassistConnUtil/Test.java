package javassistConnUtil;

import allModulesTest.IConnection;
import logUtil.LogUtil;

public class Test {

	public static void main(String[] args) {
		
		try {
			IConnection conn = JavassistConnProxy.createJavassistProxy();
			LogUtil.debug( conn.getClass().getName() );
			LogUtil.debug( conn.getClass().getSuperclass().getName() );
			conn.query();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
