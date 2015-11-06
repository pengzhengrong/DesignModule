package observerUtil;

import java.util.Vector;


public class ObserverUtil {

	public static void main(String[] args) {
		
		//实例化观察者
		IObserver observer = new ConcreteObserver( "zs");
		IObserver observer2 = new ConcreteObserver("ls");
		
		ISubject subject = new ConcrereSubject();
		subject.attach(observer);
		subject.attach(observer2);
		subject.inform("change");
		
	}
}

/**
 * 主题接口
 * @author pzr
 *
 */
interface ISubject{
		//添加观察者
		public void attach( IObserver observer);
		//删除观察者
		public void deattach( IObserver observer );
		//通知观察者
		public void inform( String form );
		
}

/**
 * 具体主题
 * @author pzr
 *
 */
class ConcrereSubject implements ISubject{
	
	//被观察者维护了一个观察者列表
	//vector 和arraylist的功能一样，只是vector是线程安全的。
	Vector<IObserver> vector = new Vector<IObserver>();
	
	//添加观察者
	public void attach( IObserver observer){
		vector.add(observer);
	}
	
	
	//删除观察者
	@Override
	public void deattach(IObserver observer) {
		// TODO Auto-generated method stub
		vector.remove(observer);
		
	}

	//通知观察者
	@Override
	public void inform( String form) {
		// TODO Auto-generated method stub
		for (IObserver observer : vector) {
			observer.update(form);
		}
	}
	

	
}

/**
 * 观察者接口
 * @author pzr
 *
 */
interface IObserver{
	public void update( String form ) ; 
}

/**
 * 具体观察者
 * @author pzr
 *
 */
class ConcreteObserver implements IObserver{

	public ConcreteObserver( String name ) {
		// TODO Auto-generated constructor stub
		System.out.println( name +" is ready !");
	}
	
	@Override
	public void update( String form ) {
		// TODO Auto-generated method stub
		System.out.println("I have save this information !" + form);
	}
	
}





