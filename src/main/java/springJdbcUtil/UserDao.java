package springJdbcUtil;

import java.util.List;

public interface UserDao {

	public <T> List<T> queryForList( String sql, Object[] args, int[] argTypes );

	public List<User> findAll();
	
	public List queryForList2( String sql, Object[] args, int[] argTypes );
	
	public List queryForList2( String sql, Object[] args, int[] argTypes ,Class obj );
	
	public <T> List<T> queryForList(String sql, Class<T> poClass);
	
}
