package cglibConnUtil;

import allModulesTest.IConnection;
import logUtil.LogUtil;

public class Test {

	public static void main(String[] args) {
		
		IConnection conn = CgLibConnProxy.createCglibProxy();
		//作为代理，只要在调用代理对象的实际方法的时候，才会去初始化conn对象
		conn.query();
		
	}
	
}
