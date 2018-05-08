/**
 * 
 */
package basecc.java8.stram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * <p>
 * Title:FilterFlatMap
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月8日
 */
public class FilterFlatMap {
	/*
	 * Stream<String[]> -> flatMap -> Stream<String> Stream<Set<String>> -> flatMap
	 * -> Stream<String> Stream<List<String>> -> flatMap -> Stream<String>
	 * Stream<List<Object>> -> flatMap -> Stream<Object> How flatMap() works : {
	 * {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6} { {'a','b'}, {'c','d'},
	 * {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
	 */
	/**
	 * Stream + String[] + flatMap
	 */
	@Test
	public void test001() {
		// The below example will print an empty result, because filter() has no idea
		// how to filter a stream of String[].
		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		Stream<String[]> tmp = Arrays.stream(data);
		tmp.filter(x -> "a".equals(x.toString())).forEach(System.out::println);
		// flatMap(x->Arrays.stream(x)) x是一个数组，把每一个数组扁平化。
		tmp.flatMap(x -> Arrays.stream(x)).filter(x -> "a".equals(x.toString())).forEach(System.out::println);
	}

	/**
	 * flatMap() and Set example.
	 */
	@Test
	public void test002() {
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		// x->x.getBook() Set<String> ------>flatMap(x->x.stream()) String
		list.stream().map(x -> x.getBook()).flatMap(x -> x.stream()).distinct().forEach(System.out::println);

		// Try comments the flatMap(x -> x.stream()) the Collectors.toList() will
		// prompts a compiler error, because it has no idea how to collect a stream of
		// Set object.
	}

	/**
	 * Stream + Primitive + flatMapToInt For primitive type, you can use
	 * flatMapToInt.
	 */
	@Test
	public void test003() {
		// 补充创建Stream的方式：
		// 1.Stream的静态方法 of 可以将数组转换为Stream
		
		// 2.Arrays的静态方法 stream可以将数组【的一部分】转换为stream（Stream<String> stream2 =
		// Arrays.stream(strings, 0, 3);//java,js,angular ，不包括下标3的元素）
		
		// 3.Stream的静态方法 empty 可以创建空的stream
		// Stream<String> stream = Stream.empty();
		// System.out.println(stream.count());
		
		// 4.Stream的的静态方法generate 可以产生一个特定的值的stream
		// Stream<String> stream = Stream.generate(() -> "java");
		// stream .forEach(e -> System.out.println(e));//java

		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		Stream<int[]> steamArray = Stream.of(intArray);// 创建stream的三种方式之一
		// x is { 1, 2, 3, 4, 5, 6 }
		steamArray.flatMapToInt(x->Arrays.stream(x)).forEach(System.out::println);;
	}
}
