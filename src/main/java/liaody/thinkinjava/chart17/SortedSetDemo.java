/**
 * 
 */
package liaody.thinkinjava.chart17;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * <p>
 * Title:SortedSetDemo
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
public class SortedSetDemo {

	public static void main(String[] args) {

		// 先创建一个空的容器再使用addAll方法进行
		SortedSet<String> sortedSet = new TreeSet<String>();
		Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
		System.out.println(sortedSet);
		
		String low = sortedSet.first();
		String hight = sortedSet.last();
		System.out.println(low);
		System.out.println(hight);
		
		// 所有的Collection类型都可以使用迭代器。
		Iterator<String> it = sortedSet.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
		
		 
	}
}
