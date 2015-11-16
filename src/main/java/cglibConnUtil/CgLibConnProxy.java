package cglibConnUtil;

import allModulesTest.IConnection;
import net.sf.cglib.proxy.Enhancer;

public class CgLibConnProxy {
	/**
	 * enhancer 增强者
	 * @return
	 */
	public static IConnection createCglibProxy(){
		
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback( new CglibConnInterceptor()  );
		enhancer.setInterfaces(new  Class[] { IConnection.class });
		IConnection cglibProxy = (IConnection) enhancer.create();
		return cglibProxy;
	}
	
}
