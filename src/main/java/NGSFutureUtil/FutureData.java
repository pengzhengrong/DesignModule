package NGSFutureUtil;

public class FutureData implements Data {

	private boolean isReady = false;
	private RealData realData = null;

	public synchronized void setRealData(RealData realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}

	@Override
	public synchronized String getResponse() {
		// TODO Auto-generated method stub
		// RealData realData = new real

		try {
			while ( !isReady ) {
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return realData.getResponse();
	}

}
