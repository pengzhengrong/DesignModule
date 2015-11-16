package allModulesTest;

import org.apache.commons.pool.PoolableObjectFactory;

import logUtil.LogUtil;

public class ConnPoolFactroy implements PoolableObjectFactory<Connection>{
	
	private String user;
	private String pwd;
	private String url;
	
	public ConnPoolFactroy( String user , String pwd , String url ) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.pwd = pwd;
		this.url   =  url;
	}
	
	//创建对象
	@Override
	public Connection makeObject() throws Exception {
		// TODO Auto-generated method stub
		return Connection.getConnection(user, pwd, url);
	}

	//销毁对象时调用
	@Override
	public void destroyObject(Connection obj) throws Exception {
		// TODO Auto-generated method stub
		LogUtil.debug(" destroy conn " + obj);
	}

	//检查对象是否可用
	@Override
	public boolean validateObject(Connection obj) {
		// TODO Auto-generated method stub
		if( obj == null ){
			LogUtil.debug(" validate conn is null " + obj);
			return false;
		}
		LogUtil.debug(" validate conn is useable " + obj);
		return true;
	}

	//激活对象前调用
	@Override
	public void activateObject(Connection obj) throws Exception {
		// TODO Auto-generated method stub
		LogUtil.debug(" init conn" + obj);
	}

	//返回对象激活
	@Override
	public void passivateObject(Connection obj) throws Exception {
		// TODO Auto-generated method stub
		LogUtil.debug(" return conn " + obj);
	}
	
	public static void main(String[] args) {
		
	}
	

}
