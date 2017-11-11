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
 * Description:展示内部类
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月3日
 */
public class Parce6 {

	// 演示HashMap的初始化用法
	Map<String, Integer> map = new HashMap<String, Integer>() {
		{
			put("黄加益", 4);
			put("韦宁",8 );
		}
	};

private void printHashMap() {
	for(String key:map.keySet()) {
		System.out.println(key+"  "+map.get(key));
	}
}
	private String internalTracking(boolean b) {
		if (b) {
			// 创建一个内部类
			class TrackingSilp {
				private String id;

				// 内部类不允许有访问修饰符，也没有意义
				TrackingSilp(String s) {
					id = s;
				}

				// 可以有访问修饰符
				String getSlip() {
					return id;
				}
			}
			TrackingSilp slip = new TrackingSilp("黄加益");
			String s = slip.getSlip();
			return s;
		}
		// 这里已经不是局部内部类的作用域了。
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
