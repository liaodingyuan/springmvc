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
* @date 2018年5月5日
*/
public class IntPredicateTest {

	public static void main(String[] args) {
	
		// 这种情况下是不会进行装箱操作的。
		// 需要注意的是，只有IntPredicate,LongPredicate, DoublePredicate，没有byte short char
		IntPredicate evenNumbers = (int i) -> i%2==0;
		System.out.println(evenNumbers.test(1000));
		// 使用Predicate<T>是会自动进行拆箱与装箱 的
		Predicate<Integer> oldNumbers = (Integer i) -> i % 2 == 1;
		System.out.println(oldNumbers.test(1000));
	}
	
}
