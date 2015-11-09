package futureUtil;

/**
 * 客户端
 * @author pzr
 *
 */
public class Client {

	public Data request( final String query ){
		final FutureData future = new FutureData();
		new Thread(){
			public void run(){
				RealData realData = new RealData(query);
				future.setRealData(realData);
			}
		}.start();
		return future;
	}
}
