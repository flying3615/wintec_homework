package assigment4;

import java.util.HashMap;
import java.util.Map;

public class TestCollisions {

	static final int MAX_SIZE = 10_000;

	public static void main(String[] args) {
		try {
			System.out.print("Bean with better hashcode = ");
			checkPerformance(BetterBean.class);
			System.out.print("Bean with worse hashcode = ");
			checkPerformance(WorseBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void checkPerformance(Class<? extends Bean> clazz) throws Exception{
		Map<Bean,Integer> map = new HashMap<>();
		long start = System.currentTimeMillis();
		Bean bean  = null;
		for(int i=0;i<MAX_SIZE;i++){
			bean = (Bean) clazz.getDeclaredConstructor(Integer.class).newInstance(i);
			map.put(bean, 1);
		}
		//get the last one
		map.get(bean);
		long elapse = System.currentTimeMillis()-start;
		System.out.println(elapse);
	}

}
