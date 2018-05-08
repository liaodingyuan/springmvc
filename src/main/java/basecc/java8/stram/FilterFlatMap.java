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
 * @date 2018��5��8��
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
		// flatMap(x->Arrays.stream(x)) x��һ�����飬��ÿһ�������ƽ����
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
		// ���䴴��Stream�ķ�ʽ��
		// 1.Stream�ľ�̬���� of ���Խ�����ת��ΪStream
		
		// 2.Arrays�ľ�̬���� stream���Խ����顾��һ���֡�ת��Ϊstream��Stream<String> stream2 =
		// Arrays.stream(strings, 0, 3);//java,js,angular ���������±�3��Ԫ�أ�
		
		// 3.Stream�ľ�̬���� empty ���Դ����յ�stream
		// Stream<String> stream = Stream.empty();
		// System.out.println(stream.count());
		
		// 4.Stream�ĵľ�̬����generate ���Բ���һ���ض���ֵ��stream
		// Stream<String> stream = Stream.generate(() -> "java");
		// stream .forEach(e -> System.out.println(e));//java

		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		Stream<int[]> steamArray = Stream.of(intArray);// ����stream�����ַ�ʽ֮һ
		// x is { 1, 2, 3, 4, 5, 6 }
		steamArray.flatMapToInt(x->Arrays.stream(x)).forEach(System.out::println);;
	}
}
