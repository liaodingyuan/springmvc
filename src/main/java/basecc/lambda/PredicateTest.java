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
 * @date 2018年5月5日
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
		// 方式一：直接将lambda传入方法
		List<String> result2 =filter(testList,(String s)->!s.isEmpty());
		// 使用lambda直接输出
		result2.forEach(n->System.out.println(n));
		
		// 方式2：使用变量先存储lambda
		Predicate<String> nonEmptyList = (String s)->!s.isEmpty();
		List<String> result3 = filter(testList,nonEmptyList);
		result3.forEach((n)->System.out.println(n));
		
	}

	/**
	 * 测试Predicate<T> 函数接口，Predicate<T>函数接口只有一个test方法，返回Boolean
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
