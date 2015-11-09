package springJdbcUtil;

import java.util.List;

public interface UserDao {

	public <T> List<T> queryForList( String sql, Object[] args, int[] argTypes );
	
}
