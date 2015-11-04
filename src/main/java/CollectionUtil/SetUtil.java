package CollectionUtil;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * 不允许重复的值
 * @author pzr
 *
 */
public class SetUtil {

	public static void main(String[] args) {
		
		//乱序
		HashSet<Object> hashSet = new HashSet<Object>();
		
		//排序
		TreeSet<Object> treeSet   =  new TreeSet<Object>();
		
		//按照加入的顺序输出
		LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>();
		
		
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		
		System.out.println(hashSet);
		
		
		treeSet.add("y");
		treeSet.add("x");
		treeSet.add("b");
		System.out.println( treeSet );
		
		linkedHashSet.add("y");
		linkedHashSet.add("x");
		linkedHashSet.add("b");
		
		System.out.println(linkedHashSet);
		
		
	}
	
	
}

class HashSetUtil{
	
}

class TreeSetUril{
	
}

class LinkedHashSetUtil{
	
}
