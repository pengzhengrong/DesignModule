package poolUtil;

public class Connection {

	/*private Connection conn = new Connection(); 
	
//	private  Connection(){}
	
	public  Connection getConnection( String name , String password , String url ){
		if( name.length() > 3 && password.length() > 3 && url.length() > 5 ){
			return this.conn;
		}else{
			return null;
		}
	}*/
	
	public void query( String sql ){
		System.out.println( sql );
	}
	
}
