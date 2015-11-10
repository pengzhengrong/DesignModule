package NGSFutureUtil;

public class Request {

	private String name;
	
	private Data response ;
	
	public Request( String name ) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Data getResponse() {
		return response;
	}

	public void setResponse(Data response) {
		this.response = response;
	}

	
	
}
