package Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;


public class DeptDao {
    
    private JdbcTemplate jdbcT;
    
    public void setJdbcT(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }

    public  List findALL() {
        String sql = "select * from dept";
        return jdbcT.queryForList(sql);
    }
    
    public List<Dept> findALLDepts() {
        List<Dept> depts = new ArrayList<Dept>();;
        String sql = "select * from dept";
        List list = jdbcT.queryForList(sql); 
        Iterator iterator = list.iterator();
        Dept dept = null;
        while (iterator.hasNext()) {
            Map map4dept = (Map) iterator.next();
            dept = new Dept();       
            dept.setDeptNo( Integer.parseInt( map4dept.get("DEPTNO").toString() ) );
            dept.setDname((String)map4dept.get("DNAME"));
            dept.setLoc((String)map4dept.get("LOC"));        
            depts.add(dept);
        }
        return depts;
    }    
    public int delete(int bid){
        String sql = "delete from DeptInfo where bid =?";
        return jdbcT.update(sql, new Object[]{bid});
    }     
    
    public static void main(String[] args) {      
        DeptDao dao = (DeptDao) SpringUtil.getBean("deptDao");
        List<Dept> depts = dao.findALLDepts();;
        for(Dept dept:depts){
            System.out.println(dept.getDeptNo()+","+dept.getDname()+","+dept.getLoc());
        }
        System.out.println("---------------------------------");
        
        List list = dao.findALL();
        for(Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}