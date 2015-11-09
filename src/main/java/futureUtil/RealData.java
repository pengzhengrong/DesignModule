package futureUtil;

public class RealData implements Data{

	protected String result;
	
	public RealData( String query ){
		StringBuffer sb = new StringBuffer(query);
		//真实数据的返回可能需要很长的时间等待
		for( int i = 0; i< 5 ; i++  ){
			sb.append(i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = sb.toString();
	}
	
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
