package productCustomerUtil;

/**
 * 把类修饰为final，很好的利用了不变模式。作为共享的数据
 * @author pzr
 *
 */
public final class PCData {

	private final int intData;
	
	public PCData( int data ) {
		// TODO Auto-generated constructor stub
		this.intData = data;
	}
	
	
	public int getData(){
		return intData;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "data:"+intData;
	}
	
	
	
	
}
