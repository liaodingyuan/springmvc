/**
 * 
 */
package liaody.thinkinjava.chart19;

import java.util.EnumMap;
import java.util.Map;

/**
 * <p>
 * Title:EnumMaps
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月12日
 */
public class EnumMaps {

	public static void main(String[] args) {
		// EnumMap的key必须来自Enum
		EnumMap<AlarmPoint, Command> em = new EnumMap<AlarmPoint, Command>(AlarmPoint.class);
		em.put(AlarmPoint.KITCHEN, new Command() {
			@Override
			public void action() {
				System.out.println("厨房着火啦！");
			}

		});
		em.put(AlarmPoint.OFFICE1, new Command() {
			@Override
			public void action() {
				System.out.println("Office1 fire!");
			}

		});

		for (Map.Entry<AlarmPoint, Command> e : em.entrySet()) {
			System.out.println(e.getKey());
			e.getValue().action();
		}
		try {
			// key来源于enum，所以总是有的，如果value没有值，就会抛出异常
			em.get(AlarmPoint.OFFICE3).action();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface Command {
	void action();
}

enum AlarmPoint {

	START1, START2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN
}
