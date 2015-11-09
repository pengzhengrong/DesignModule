package springJdbcUtil;

import java.sql.Types;
import java.util.List;

public class Test {

	
	public static void main(String[] args1) {
		UserDao sj = (UserDao) SpringUtil.getBean("userDao");
		System.out.println( sj==null );
		User u = new User();
//		SpringJdbcUtil s = new SpringJdbcUtil();
		String sql = "select name,loginname,createtime,age from user";
		Object[] args = {u.getName() , u.getLoginName() , u.getCreateTime() , u.getAge()};
		int[] argTypes = { Types.VARCHAR , Types.VARCHAR , Types.DATE , Types.INTEGER };
		List<User> list = sj.queryForList(sql, args, argTypes);
		System.out.println( list.size() );
	}
}
