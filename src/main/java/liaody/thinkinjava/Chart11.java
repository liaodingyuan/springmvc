/**
 * 
 */
package liaody.thinkinjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
* <p>Title:Chart11 </p>
* <p>Description: 容器的使用</p>
* <p>Company: </p>
* @author liaody
* @date 2017年11月4日
*/
public class Chart11 {

	/**
	 * 添加一组元素
	 */
	private void addElements() {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		// 使用addAll方法比使用容器初始化容器的效率更高。
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		
	}
	public static void main(String[] args) {
		Chart11 chart = new Chart11();
		chart.addElements();
	}
}
