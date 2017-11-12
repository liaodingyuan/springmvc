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
 * @date 2017��11��12��
 */
public class EnumMaps {

	public static void main(String[] args) {
		// EnumMap��key��������Enum
		EnumMap<AlarmPoint, Command> em = new EnumMap<AlarmPoint, Command>(AlarmPoint.class);
		em.put(AlarmPoint.KITCHEN, new Command() {
			@Override
			public void action() {
				System.out.println("�����Ż�����");
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
			// key��Դ��enum�����������еģ����valueû��ֵ���ͻ��׳��쳣
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
