package JDKDBQueryUtil;

public class Test {

	
	public static void main(String[] args) {
		
		IDBQuery query = JDKProxy.createJdkProxy();
		
		String response = query.request();
		System.out.println( response );
		
	}
}
