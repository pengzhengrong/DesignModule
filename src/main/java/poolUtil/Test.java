package poolUtil;

import java.util.NoSuchElementException;

public class Test {

	
	public static void main(String[] args) {
		try {
			Connection conn = ConnPool.getConnection();
//			conn.getConnection("pengzr", "zy520", "jdbv:mysql:3306");
			conn.query("select * from db ");
//			ConnPool.close(conn);
			Connection conn2 = ConnPool.getConnection();
			conn2.query("select * from db ");
			ConnPool.close(conn2);
			ConnPool.close(conn);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
