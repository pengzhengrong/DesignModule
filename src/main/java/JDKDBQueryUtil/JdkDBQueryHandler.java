package JDKDBQueryUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * Invocation 祈祷
 * @author pzr
 *
 */
public class JdkDBQueryHandler implements InvocationHandler {

	IDBQuery real = null;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if( real == null ){
			real = new DBQuery();
		}
		return real.request();
	}
	

}
