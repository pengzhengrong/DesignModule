package jdkFutureUtil;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {

	//类似Client中的request
	public static void main(String[] args) {
		FutureTask<String> future = new FutureTask<String>(new RealData("this is my question "));
		//返回 线程池 
		ExecutorService executor = Executors.newFixedThreadPool(1);
		//执行RealData中的call方法
		executor.submit(future);
		//请求完毕
		
		//处理逻辑
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			//相当于FutureData中的getResult，在RealData返回数据之前，future.get()都会处于等待状态
			System.out.println("返回数据=" + future.get() );
//			executor.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
