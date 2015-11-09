package futureUtil;

/**
 * 虚拟数据，但是需要实现RealData的真是数据
 * @author pzr
 *
 */
public class FutureData implements Data{

	protected RealData realData = null ;
	protected boolean isReady = false;
	
	public synchronized void setRealData( RealData realData ){
		if( isReady ){
			return ;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();//唤醒
	}
	
	
	
	@Override
	public synchronized String getResult() {
		// TODO Auto-generated method stub
		while( !isReady ){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

}
