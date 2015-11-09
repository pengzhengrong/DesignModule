package poolUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private Logger LOG = LoggerFactory.getLogger( "system");
	
	public void query( String sql ){
		LOG.info(sql + "log");
		System.out.println( sql );
	}
	
}
