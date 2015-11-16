package proxyUtil;

public class DBQUery implements IDBQuery{

	public DBQUery() {
		// TODO Auto-generated constructor stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String request() {
		// TODO Auto-generated method stub
		return "I am true Request handle ";
	}

}
