/**
 * 
 */
package liaody.thinkinjava.chart10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title:Parce6
 * </p>
 * <p>
 * Description:չʾ�ڲ���
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��3��
 */
public class Parce6 {

	// ��ʾHashMap�ĳ�ʼ���÷�
	Map<String, Integer> map = new HashMap<String, Integer>() {
		{
			put("�Ƽ���", 4);
			put("Τ��",8 );
		}
	};

private void printHashMap() {
	for(String key:map.keySet()) {
		System.out.println(key+"  "+map.get(key));
	}
}
	private String internalTracking(boolean b) {
		if (b) {
			// ����һ���ڲ���
			class TrackingSilp {
				private String id;

				// �ڲ��಻�����з������η���Ҳû������
				TrackingSilp(String s) {
					id = s;
				}

				// �����з������η�
				String getSlip() {
					return id;
				}
			}
			TrackingSilp slip = new TrackingSilp("�Ƽ���");
			String s = slip.getSlip();
			return s;
		}
		// �����Ѿ����Ǿֲ��ڲ�����������ˡ�
		return "";
	}

	private String trace() {
		return internalTracking(true);
	}

	public static void main(String[] args) {
		Parce6 p = new Parce6();
		System.out.println(p.trace());
		p.printHashMap();
	}

}
