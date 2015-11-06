package jvmUtil;

/**
 * 强引用,  软引用 ， 弱引用 ， 虚引用 
 * @author pzr
 *
 */
public class FinalReferenceUtil {

	public static void main(String[] args) {
		FinalReferenceUtil.StrongReference();
		
	}
	
	/**
	 * this is a Strong reference 
	 * like : stack  heep
	 * 		sb   ->	StringBuffer	
	 * 		sb1       ->
	 * sb 和 sb1指向同一个对象。 == 是强引用
	 * 1.强引用可以直接访问目标对象
	 * 2.jvm 的cg 不会回收强引用所指对象
	 * 3.强引用可能导致内存泄漏
	 */		 
	public static void StrongReference(){
		StringBuffer sb = new StringBuffer("this is a test");
		StringBuffer sb2 = sb;
		
		sb2.append( " sb2:this a test ");
		// 输出：this is a test sb2:this a test 。 原因：因为sb和sb2都是指向同一个对象
		System.out.println( sb.toString() );
		System.out.println( "sb == sb2 ?" + (sb==sb2 ));
	}
	
}
