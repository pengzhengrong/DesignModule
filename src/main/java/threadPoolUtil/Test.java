package threadPoolUtil;

import logUtil.LogUtil;

public class Test {

	
	public static void main(String[] args) {
/*		double start = System.currentTimeMillis();
		System.out.println( start  );*/
		double start = System.currentTimeMillis();
		System.out.println("start:"+ start );
//		ThreadPool.showThread();
		
		ThreadPool.addThread(5);
//		ThreadPool.showThread();
		LogUtil.debug( "threadPool has "+ThreadPool.getThreadCount()+" thread" );
		for( int i = 0 ; i< 100 ; i++ ){
			ThreadPool.start( new Target( i+"'" ) );
		}
		
		
//		ThreadPool.showThread();
		System.out.println("spend time::"+( System.currentTimeMillis() - start) +"ms" );
	}
	
}

class Target implements Runnable{

	private String name ;
	
	public Target( String name ) {
		// TODO Auto-generated constructor stub
		this.name = name ;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(300);
		}catch( Exception e){
			e.printStackTrace();
		}
		LogUtil.debug(" target " + name);
	}
	
}
