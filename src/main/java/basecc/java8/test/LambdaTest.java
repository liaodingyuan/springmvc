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
 * Description:10�����ʽ����ϰ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��5��6��
 */
public class LambdaTest {

	/**
	 * ��lambda���ʽʵ��Runnable
	 */
	public static void test001() {
		new Thread(() -> System.out.println("run method")).start();
		;
	}

	/**
	 * ʹ��lambda�Լ��Ͻ�������
	 */
	public static void test002() {
		List<Integer> numbers = Arrays.asList(2, 4, 2, 87, 4, 45, 98);
		
		// ѭ��
		numbers.stream().distinct().forEach(n -> System.out.println(n));

		// ���ַ�ʽҲ�ǶԵġ�
		// numbers.sort(Comparator.comparing(i->Integer.valueOf(i)));

		// ʹ��Collections
		// ʹ��lambda���ʽ���������
		Collections.sort(numbers, (a, b) -> b.compareTo(a));
//		numbers.forEach(n -> System.out.println(n));
		// ʹ��lambda���ʽ���������
		Collections.sort(numbers, (a, b) -> a.compareTo(b));

		// ֱ��ʹ��List��sort
		numbers.sort((a,b)->a.compareTo(b));
//		numbers.sort(Comparator.reversed());
	}

	/**
	 * ʹ��lambda���ʽ�ͺ���ʽ�ӿ�Predicate
	 */
	public static void test004() {
		 List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		// ��j��ͷ������
		 List<String> startWithJ = languages.stream().filter(str->str.startsWith("J")).collect(Collectors.toList());
		 startWithJ.forEach(n->System.out.println(n));
		// ��a����������
		languages.stream().filter(str->str.endsWith("a")).forEach(n->System.out.println(n));
		//���е�����.
		languages.stream().filter(str->true).forEach(n->System.out.println(n));
		//���ȴ���4������
		languages.stream().filter(str->str.length()>4).forEach(n->System.out.println(n));
		
	}
	/**
	 * ���������� Predicate �ϳ�һ��.���ṩ�������߼�������AND��OR�ķ��������ֽ���and()��or()��xor()
	 */
	public static void test005() {
		Predicate<String> startWithJ = str->str.startsWith("J");
		Predicate<String> fourLetterLong = str->str.length()==4;
		// ����Ҫ�ҵ�������J��ʼ������Ϊ�ĸ���ĸ������
		 List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		String result= languages.stream().filter(startWithJ.and(fourLetterLong)).findFirst().orElse("No Such Element");
		System.out.println(result);
		
	}
	
	/**
	 * Java 8��ʹ��lambda���ʽ��Map��Reduceʾ��
	 * lambda���ʽΪÿ����������12%��˰
	 */
	public static void test006() {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map(cost->cost*1.12).forEach(System.out::println);
		double result = costBeforeTax.stream().reduce((sum,cost)->sum+=sum+cost).get();
		System.out.println(result);
	}
	
	/**
	 * ���㼯��Ԫ�ص����ֵ����Сֵ���ܺ��Լ�ƽ��ֵ
	 */
	public static void test007() {
		//��ȡ���ֵĸ�������Сֵ�����ֵ���ܺ��Լ�ƽ��ֵ
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
