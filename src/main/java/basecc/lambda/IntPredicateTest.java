/**
 * 
 */
package basecc.lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
* <p>Title:IntPredicateTest </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018��5��5��
*/
public class IntPredicateTest {

	public static void main(String[] args) {
	
		// ����������ǲ������װ������ġ�
		// ��Ҫע����ǣ�ֻ��IntPredicate,LongPredicate, DoublePredicate��û��byte short char
		IntPredicate evenNumbers = (int i) -> i%2==0;
		System.out.println(evenNumbers.test(1000));
		// ʹ��Predicate<T>�ǻ��Զ����в�����װ�� ��
		Predicate<Integer> oldNumbers = (Integer i) -> i % 2 == 1;
		System.out.println(oldNumbers.test(1000));
	}
	
}
