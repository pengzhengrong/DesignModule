package springJdbcUtil;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcUtil {
	
	private JdbcTemplate jt ;


	
	public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes,
			Class<T> objClass) {
		
		try {
			if(jt == null ){
				System.out.println( " null ");
			}
			List<T> list= jt.query(sql,args,argTypes,new BeanPropertyRowMapper<T>(objClass) );
			return list;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	
	public <T> List queryForList( String sql, Object[] args, int[] argTypes ){
		return jt.queryForList(sql, args, argTypes);
	}
	
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
}
