package CollectionUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ListUtil {

	public static void main(String[] args) {
		
		// 和 arraylist 差不多，但是多了线程安全
		Vector<Object> vector = VectorUtil.getVector();
		vector.add(1);
		
		
		/*ArrayList<Object> list = ArrayListUtil.getArrayList();
		
		for( int i = 0 ; i < 10 ;i ++ ){
			list.add (i);
		}
		int i = (Integer) list.get(0);
		System.out.println(i);
		for( Iterator<Object> it = list.iterator() ; it.hasNext() ;){
			int i = (Integer) it.next();
			System.out.print(i + " ");
		}*/
		
		
		LinkedList<Object> linkedList = LinkedListUtil.getLinkedList();
		linkedList.add(1);
		int i = (Integer) linkedList.get(0);
		System.out.println(i);
		
		LinkedList<Object> linkedList2 = LinkedListUtil.getLinkedList();
		int i2 = (Integer) linkedList2.get(0);
		System.out.println( i2 );
		
		int e = (Integer) linkedList.element();
		System.out.println(e + " :e");
		
		
		Queue queue = QueueUtil.getQueue();
		for( int k = 0 ; k < 10 ; k++ ){
			queue.add(k);
		}
		
		int temp = (Integer) queue.poll();
		System.out.println( temp );
		
		
		
		int peekTemp = (Integer) queue.peek();
		System.out.println( peekTemp );
		
		System.out.println( queue.size() );
		
		
		
		
	}
	
	
}

//单例实现ArrayList
class ArrayListUtil{
	
	private ArrayListUtil(){
		System.out.println("ArrayList is created!");
	}
	
	private static class init{
		private static ArrayList<Object> arrayList = new ArrayList<Object>();
	}
	
	public static ArrayList<Object> getArrayList( ){
		return init.arrayList;
	}
	
}

class QueueUtil{
	
	private QueueUtil(){
		System.out.println("Queue is created!");
	}
	
	private static class init{
		private static Queue<Object> queue = new ConcurrentLinkedQueue<Object>();
	}
	
	public static Queue<Object> getQueue( ){
		return init.queue;
	}
	
}

class VectorUtil{
	
	private VectorUtil(){
		
	}
	
	private static class init{
		private static Vector<Object> vector = new Vector<Object>();
	}
	
	public static Vector<Object> getVector(){
		return init.vector;
	}
	
}

class LinkedListUtil extends LinkedList<Object>{
	private LinkedListUtil(){
		System.out.println("LinkedList is created!");
	}
	
	private static class init{
		private static LinkedList<Object> linkedLsit= new LinkedList<Object>();
	}
	
	public static LinkedList<Object> getLinkedList( ){
		return init.linkedLsit;
	}
}




