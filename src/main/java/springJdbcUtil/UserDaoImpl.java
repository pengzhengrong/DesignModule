package springJdbcUtil;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao{

	private JdbcTemplate jt ;
	
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
	
	

}
