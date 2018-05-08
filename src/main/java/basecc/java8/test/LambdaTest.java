/**
 * 
 */
package basecc.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.itextpdf.text.log.SysoCounter;

/**
 * <p>
 * Title:LambdaTest
 * </p>
 * <p>
 * Description:10个表达式的练习
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月6日
 */
public class LambdaTest {

	/**
	 * 用lambda表达式实现Runnable
	 */
	public static void test001() {
		new Thread(() -> System.out.println("run method")).start();
		;
	}

	/**
	 * 使用lambda对集合进行排序
	 */
	public static void test002() {
		List<Integer> numbers = Arrays.asList(2, 4, 2, 87, 4, 45, 98);
		
		// 循环
		numbers.stream().distinct().forEach(n -> System.out.println(n));

		// 这种方式也是对的。
		// numbers.sort(Comparator.comparing(i->Integer.valueOf(i)));

		// 使用Collections
		// 使用lambda表达式降序排序后
		Collections.sort(numbers, (a, b) -> b.compareTo(a));
//		numbers.forEach(n -> System.out.println(n));
		// 使用lambda表达式升序排序后
		Collections.sort(numbers, (a, b) -> a.compareTo(b));

		// 直接使用List的sort
		numbers.sort((a,b)->a.compareTo(b));
//		numbers.sort(Comparator.reversed());
	}

	/**
	 * 使用lambda表达式和函数式接口Predicate
	 */
	public static void test004() {
		 List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		// 以j开头的语言
		 List<String> startWithJ = languages.stream().filter(str->str.startsWith("J")).collect(Collectors.toList());
		 startWithJ.forEach(n->System.out.println(n));
		// 以a结束的语言
		languages.stream().filter(str->str.endsWith("a")).forEach(n->System.out.println(n));
		//所有的语言.
		languages.stream().filter(str->true).forEach(n->System.out.println(n));
		//长度大于4的语言
		languages.stream().filter(str->str.length()>4).forEach(n->System.out.println(n));
		
	}
	/**
	 * 两个或更多的 Predicate 合成一个.它提供类似于逻辑操作符AND和OR的方法，名字叫做and()、or()和xor()
	 */
	public static void test005() {
		Predicate<String> startWithJ = str->str.startsWith("J");
		Predicate<String> fourLetterLong = str->str.length()==4;
		// 例如要找到所有以J开始，长度为四个字母的名字
		 List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		String result= languages.stream().filter(startWithJ.and(fourLetterLong)).findFirst().orElse("No Such Element");
		System.out.println(result);
		
	}
	
	/**
	 * Java 8中使用lambda表达式的Map和Reduce示例
	 * lambda表达式为每个订单加上12%的税
	 */
	public static void test006() {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map(cost->cost*1.12).forEach(System.out::println);
		double result = costBeforeTax.stream().reduce((sum,cost)->sum+=sum+cost).get();
		System.out.println(result);
	}
	
	/**
	 * 计算集合元素的最大值、最小值、总和以及平均值
	 */
	public static void test007() {
		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
	public static void main(String[] args) {

		// test001();
		System.out.println("**************");
		test007();

		// System.exit(0);

	}
}
