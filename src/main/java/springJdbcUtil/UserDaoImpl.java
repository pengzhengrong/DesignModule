package springJdbcUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao{

	private JdbcTemplate jt ;
	
	public List<User> findAll(){
		
		String sql = " select * from user ";
		Map map = new HashMap<String, Object>();
//		map.put("", value)
		List list = jt.queryForList(sql);
		return list;
		
	}
	
	@Override
	public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes) {
		// TODO Auto-generated method stub
		if( jt == null ){
			System.out.println( " jt is null ");
		}
		return (List<T>) jt.queryForList(sql, args, argTypes);
	}

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List queryForList2(String sql, Object[] args, int[] argTypes) {
		// TODO Auto-generated method stub
		return jt.queryForList(sql, args, argTypes);
	}

	@Override
	public List queryForList2(String sql, Object[] args, int[] argTypes, Class obj) {
		// TODO Auto-generated method stub
		return jt.queryForList(sql, args, argTypes, obj);
	}

	@Override
	public <T> List<T> queryForList(String sql, Class<T> poClass) {
		// TODO Auto-generated method stub
		try {
			List<T> list = jt.query(sql, new BeanPropertyRowMapper<T>(poClass));

			return list;
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	

}
