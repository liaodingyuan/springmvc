/**
 * 
 */
package liaody.thinkinjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
* <p>Title:Chart11 </p>
* <p>Description: ������ʹ��</p>
* <p>Company: </p>
* @author liaody
* @date 2017��11��4��
*/
public class Chart11 {

	/**
	 * ���һ��Ԫ��
	 */
	private void addElements() {
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] moreInts = {6,7,8,9,10};
		// ʹ��addAll������ʹ��������ʼ��������Ч�ʸ��ߡ�
		collection.addAll(Arrays.asList(moreInts));
		System.out.println(collection);
		
	}
	public static void main(String[] args) {
		Chart11 chart = new Chart11();
		chart.addElements();
	}
}
