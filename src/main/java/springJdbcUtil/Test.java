package springJdbcUtil;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;

public class Test {

	
	public static void main(String[] args1) {
		UserDao sj = (UserDao) SpringUtil.getBean("userDao");
		List list = sj.findAll();
//		Iterator it = list.iterator();
		String sql = " select age from user ";
		User u = new User();
		Object[] args = { u.getAge() };
		int[] argTypes = { Types.INTEGER };
		
		List<User> list2 = sj.queryForList(sql, User.class);
		
		for (User object : list2) {
			System.out.println( object.getAge());
		}
		
	
			
//		sj.
		
		
	}
}
