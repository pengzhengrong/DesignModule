package jvmUtil;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 木有实现
 * @author pzr
 *
 */
public class SoftReferenceUtil {

	public static void main(String[] args) {
		MyObject obj = new MyObject();
		ReferenceQueue<MyObject> softQueue = new ReferenceQueue<MyObject>();
		SoftReference<MyObject> softReference = new SoftReference<MyObject>(obj, softQueue);
		new CheckRefQueue().start(); 
		obj = null ; //删除强引用
		System.gc();
		System.out.println(" after gc : " + softReference.get() );
		System.out.println("分配大块内存，强迫GC注销软引用");
		byte[] bs = new byte[1024];
		System.out.println( " after new gc soft get :" + softReference.get() );
	}

}

class MyObject {

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		// 对象被回收时调用
		System.out.println(" MyObject is finalize called !");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();
		return "Im a MyObject";
	}

}

class CheckRefQueue{

	public static void start(){
		try {
			ReferenceQueue<MyObject> softQueue = new ReferenceQueue<MyObject>();
			Reference<MyObject> reference = (Reference<MyObject>) softQueue.remove();
			if (reference != null) {
				System.out.println(" Object for softreference is " + reference.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
