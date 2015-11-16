package proxyUtil;

/**
 * 代理类
 * @author pzr
 *
 */
public class DBQueryProxy implements IDBQuery{

	private DBQUery real ;
	
	@Override
	public String request() {
		// TODO Auto-generated method stub
		if( real == null  ){
			real = new DBQUery();
		}
		return real.request();
	}

	
	
}
