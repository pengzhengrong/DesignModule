package NGSFutureUtil;

public class RealData implements Data{

	private Data result;
	private String param;
	
	public RealData( String param  ) {
		// TODO Auto-generated constructor stub
		//在构造函数中处理
		this.param = param;
	}
	
	@Override
	public String getResponse() {
		// TODO Auto-generated method stub
		return handle( param );
	}
	
	private String handle( String param ){
		StringBuffer sb = new StringBuffer( param );
		sb.append(" Test ");
		return sb.toString();
	}
	

	public Data getResult() {
		return result;
	}

	public void setResult(Data result) {
		this.result = result;
	}
	
	 

}
