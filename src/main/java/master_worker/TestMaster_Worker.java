package master_worker;

import java.util.Map;
import java.util.Set;

public class TestMaster_Worker {

	public static void main(String[] args) {

		// 初始化一个Master:指定工人类型，工人个数
		Master master = new Master(new PlusWorker(), 5);

		// Master 接任务
		for (int i = 0; i < 5; i++) {
			master.submit(i);
		}
		// Master 下达通知，并且Worker去执行工作
		master.execute();
		int rs = 0;
		Map<String, Object> resultMap = master.getResultMap();
		
		if( master.isComplete() ){
			for( Map.Entry<String, Object> map : resultMap.entrySet() ){
				System.out.print( map.getValue() +" ");
			}
			
		}
		
		/*while (resultMap.size() > 0 || !master.isComplete()) {
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String e : keys) {
				key = e;
				break;
			}

			if (key != null) {
				int i = (Integer) resultMap.get(key);
				rs += i;
				resultMap.remove(key);
			}

		}*/

		System.out.println(rs);

	}
}
