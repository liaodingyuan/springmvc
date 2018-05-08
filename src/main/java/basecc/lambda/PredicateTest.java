/**
 * 
 */
package basecc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.itextpdf.text.log.SysoCounter;

/**
 * <p>
 * Title:PredicateTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��5��5��
 */
public class PredicateTest {

	public static void main(String[] args) {

		List<String> testList = new ArrayList<String>();
		for (int i = 0; i <10; i++) {
			if (i % 2 == 0) {
				testList.add("");
				continue;
			}
			testList.add(String.valueOf(i));
		}
		System.out.println("testList'size:"+testList.size());
		// ��ʽһ��ֱ�ӽ�lambda���뷽��
		List<String> result2 =filter(testList,(String s)->!s.isEmpty());
		// ʹ��lambdaֱ�����
		result2.forEach(n->System.out.println(n));
		
		// ��ʽ2��ʹ�ñ����ȴ洢lambda
		Predicate<String> nonEmptyList = (String s)->!s.isEmpty();
		List<String> result3 = filter(testList,nonEmptyList);
		result3.forEach((n)->System.out.println(n));
		
	}

	/**
	 * ����Predicate<T> �����ӿڣ�Predicate<T>�����ӿ�ֻ��һ��test����������Boolean
	 * 
	 * @param list
	 * @param p
	 *            Prediacate
	 * @return
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<T>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

}
