package guardedSuspensionUtil;

public class Request {

	private String name ;

	public Request( String name ) {
		// TODO Auto-generated constructor stub
		this.name = name ;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return super.toString();
		return "request："+name ;
	}
	
}
