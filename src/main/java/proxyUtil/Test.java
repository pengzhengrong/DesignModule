package proxyUtil;

public class Test {

	
	public static void main(String[] args) {
		//请求的时候，并不是直接请求真实的DBQuery，而是请求它的代理
		IDBQuery query = new DBQueryProxy();
		//在需要真实请求DBQuery中的方法时，才会去实例化真实对象
//		String response = query.request();
//		System.out.println( response );
	}
}
