package allModulesTest;

import logUtil.LogUtil;

public class Connection implements IConnection{

//	private Connection(){}
	private final String user;
	private final String pwd;
	private final String url;
	
	
	private Connection( String user, String pwd , String url ) {
		// TODO Auto-generated constructor stub
		this.user = user ;
		this.pwd = pwd;
		this.url = url;
	}
	
	
	public static  Connection getConnection( String user , String pwd , String url){
		if( handle(user, pwd, url) ){
			LogUtil.debug( "init connection : user = "+user+"  pwd = "+pwd +" url = "+ url );
			return new Connection(user, pwd, url);
		}
		return null;
	}
	
	private static boolean handle( String user , String pwd , String url ){
		if( user.equals("root") && pwd.equals("root") && url.equals("mysql")){
			return true;
		}
		
		return false;
	}
	
	
	public String query(){
		LogUtil.debug(" conn query ");
		return " conn query ";
	}
	
	
}
