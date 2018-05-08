/**
 * 
 */
package basecc.java8.stram;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * <p>
 * Title:StreamTest
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
public class StreamTest {

	
	// �����ʹ��jdk8������ô���д����
	private static void jkd7(List<Dish> list) {
		// �洢���е�������ʳ��
		List<Dish> lowC = new ArrayList<>();
		for (Dish d : list) {
			if (d.getCalories() < 400) {
				lowC.add(d);
			}
		}
		// ʹ���ⲿ�Ƚ����������򡣰���ʳ��������������
		Collections.sort(lowC, new Comparator<Dish>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				// Integer.compare �Ƚ����ֵ�ʱ��ʹ��
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowC) {
			lowCaloricDishesName.add(d.getName());
		}

	}
	// ʹ��֧��filter��collect������Stream API���ڲ�����������Լ������ݵĵ�����
//	��ֻ��Ҫ��ɸѡ��Ϊ��Ϊ�������ݸ�filter����������
	/**
	 * ʹ��distinct�м�������ȥ���ظ������᷵��һ��Ԫ�ظ��죨������������Ԫ�ص�hashCode��equals����ʵ�֣���
	 */
	public static void testDistinct() {
		List<Integer> intList = Arrays.asList(1,2,3,4,2,2,6,19,10,20,10);
		// һ�仰���Ը㶨���е�
		 intList.stream().filter(n->n%2==0).distinct().forEach(System.out::println);
	}
	/**
	 * ʹ�ýض�������֧��limit(n)�������÷����᷵��һ���������������ȵ�������
	 */
	public static void testLimit() {
		List<Integer> intList = Arrays.asList(1,2,3,4,2,2,6,19,10,20,10);
		// һ�仰���Ը㶨���е�
		 intList.stream().filter(n->n%2==0).distinct().limit(3).forEach(System.out::println);
	}
	/**
	 * ����һ��������Ϊ����������������ᱻ���õ�ÿһ��Ԫ���ϡ�
	 */
	public static void  testMap() {
		List<String> words = Arrays.asList("jdk8","lambda","In","Action");
		 words.stream().map(String::length).forEach(n->System.out.println(n));
	}

	/**
	 * �������ı�ƽ����flatmap��
	 * ��֧��map�������������һ��������Ϊ��������������ᱻӦ�õ�ÿ��Ԫ���ϣ�������ӳ
���һ���µ�Ԫ�أ�ʹ��ӳ��һ�ʣ�����Ϊ����ת�����ƣ������е�ϸ΢����������ǡ�����һ
���°汾��������ȥ���޸ġ�����
ע�⣺map����������������;���Stream<String>��
	 *  flatmap���������һ�����е�ÿ��ֵ��������һ������Ȼ������е�������
������Ϊһ������
	 */
	public static void testFlatMap() {
		
	}
	
	// ��������ϰ�⣺
	/**
	 *  ����һ�������б���η���һ����ÿ������ƽ�����ɵ��б��أ����磬����[1, 2, 3, 4,
5]��Ӧ�÷���[1, 4, 9, 16, 25]��
	 */
	public static void test001() {
		// java8һ�仰�㶨
		Arrays.asList(1,2,3,4).stream().map(n->n*n).forEach(n->System.out.println(n));
	}
	public static void test002() {
		List<Integer> intList1 = Arrays.asList(1,2,3);
		List<Integer> intList2 = Arrays.asList(3,4);
		List<int[]> result =intList1.stream().flatMap(i->intList2.stream().map(j->new int[] {i,j})).collect(toList());
		result.forEach(n->System.out.println(n));
	}
/**
 * ����Ĵ������ҳ���һ��ƽ��
�ܱ�3����������
 */
	public static void test003() {
		List<Integer> iList = Arrays.asList(1,2,3,4,5);
		iList.stream().map(n->n*n)
		.filter(m->m%3==0)
		.findFirst()
		.ifPresent(d -> System.out.println(d));
	}
	
	/**
	 * ���㼯��������Ԫ�ص��ܺ�
	 */
	public static void test004() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		// �б����
		int sum = numbers.stream().reduce(0, (a, b) -> a+b);
		System.out.println(sum);
		// �б����
		int product = numbers.stream().reduce(1, (a, b) -> a*b);
		System.out.println(product);
		// �������б�����ֵ
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println(max);
		//�������б����Сֵ
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println(min);
		
	}
	/**
	 * ���ļ��������������ı����ж��ٸ����ʣ����ظ���
	 */
	public static void countWord() {
		
		long uniqueWords =0;
		// �����Զ��ر�
		try(Stream<String> lines = Files.lines(Paths.get("d:\\a.txt"),Charset.defaultCharset())){
			uniqueWords=lines.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
		}catch(IOException e) {
		// donothing
		}
		System.out.println(uniqueWords);
	}
	/**
	 * 쳲����������������ľ�������ϰ
	 * �����п�ʼ������������0��1��������ÿ�����ֶ���ǰ��������֮�͡�
	 */
	public static void test005() {
		Stream.iterate(new int[]{0, 1},
				t -> new int[]{t[1], t[0]+t[1]})
				.limit(20)
				.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	}
	public static void main(String[] args) {

		test005();
//		countWord();
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		System.exit(0);
//		Optional<Dish> dish =
//				menu.stream()
//				.filter(Dish::isVegetarian)
//				.findAny()
//				.ifPresent(d -> System.out.println(d.getName()));
////		dish.
//		System.out.println(dish.isPresent());
//		List<String> threeHightCaloriacDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
//				.limit(3).collect(toList());
//		System.out.println(threeHightCaloriacDishNames);
		// ʹ��lambda��ӡ
//		jkd7(menu);
//		threeHightCaloriacDishNames.forEach((n) -> System.out.println(n));
		
		// ɸѡ�����е��ز�
//		List<String> veget = menu.stream().filter(Dish::isVegetarian).map(Dish::getName).collect(toList());
//		veget.forEach(n->System.out.println(n+"jj"));
//		System.out.println();
//		testDistinct();
//		testMap();
//		 menu.stream()
//				.map(Dish::getName)
//				.map(String::length)
//				.forEach(n->System.out.println(n));
	}

}
