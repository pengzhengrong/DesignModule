package Test;

import java.util.Iterator;
import java.util.List;

public class test {
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
