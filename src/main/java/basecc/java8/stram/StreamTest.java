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
 * @date 2018年5月5日
 */
public class StreamTest {

	
	// 如果不使用jdk8，是怎么进行处理的
	private static void jkd7(List<Dish> list) {
		// 存储所有低热量的食物
		List<Dish> lowC = new ArrayList<>();
		for (Dish d : list) {
			if (d.getCalories() < 400) {
				lowC.add(d);
			}
		}
		// 使用外部比较器进行排序。按照食物热量进行排序
		Collections.sort(lowC, new Comparator<Dish>() {

			@Override
			public int compare(Dish d1, Dish d2) {
				// Integer.compare 比较数字的时候使用
				return Integer.compare(d1.getCalories(), d2.getCalories());
			}
		});
		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish d : lowC) {
			lowCaloricDishesName.add(d.getName());
		}

	}
	// 使用支持filter和collect操作的Stream API（内部迭代）管理对集合数据的迭代。
//	你只需要将筛选行为作为参数传递给filter方法就行了
	/**
	 * 使用distinct中间流操作去除重复（它会返回一个元素各异（根据流所生成元素的hashCode和equals方法实现））
	 */
	public static void testDistinct() {
		List<Integer> intList = Arrays.asList(1,2,3,4,2,2,6,19,10,20,10);
		// 一句话可以搞定所有的
		 intList.stream().filter(n->n%2==0).distinct().forEach(System.out::println);
	}
	/**
	 * 使用截断流（流支持limit(n)方法，该方法会返回一个不超过给定长度的流。）
	 */
	public static void testLimit() {
		List<Integer> intList = Arrays.asList(1,2,3,4,2,2,6,19,10,20,10);
		// 一句话可以搞定所有的
		 intList.stream().filter(n->n%2==0).distinct().limit(3).forEach(System.out::println);
	}
	/**
	 * 接受一个函数作为参数，这个函数将会被作用到每一个元素上。
	 */
	public static void  testMap() {
		List<String> words = Arrays.asList("jdk8","lambda","In","Action");
		 words.stream().map(String::length).forEach(n->System.out.println(n));
	}

	/**
	 * 测试流的扁平化，flatmap。
	 * 流支持map方法，它会接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映
射成一个新的元素（使用映射一词，是因为它和转换类似，但其中的细微差别在于它是“创建一
个新版本”而不是去“修改”）。
注意：map方法输出的流的类型就是Stream<String>。
	 *  flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接
起来成为一个流。
	 */
	public static void testFlatMap() {
		
	}
	
	// 以下是练习题：
	/**
	 *  给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？例如，给定[1, 2, 3, 4,
5]，应该返回[1, 4, 9, 16, 25]。
	 */
	public static void test001() {
		// java8一句话搞定
		Arrays.asList(1,2,3,4).stream().map(n->n*n).forEach(n->System.out.println(n));
	}
	public static void test002() {
		List<Integer> intList1 = Arrays.asList(1,2,3);
		List<Integer> intList2 = Arrays.asList(3,4);
		List<int[]> result =intList1.stream().flatMap(i->intList2.stream().map(j->new int[] {i,j})).collect(toList());
		result.forEach(n->System.out.println(n));
	}
/**
 * 下面的代码能找出第一个平方
能被3整除的数：
 */
	public static void test003() {
		List<Integer> iList = Arrays.asList(1,2,3,4,5);
		iList.stream().map(n->n*n)
		.filter(m->m%3==0)
		.findFirst()
		.ifPresent(d -> System.out.println(d));
	}
	
	/**
	 * 计算集合中所有元素的总和
	 */
	public static void test004() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		// 列表求和
		int sum = numbers.stream().reduce(0, (a, b) -> a+b);
		System.out.println(sum);
		// 列表求积
		int product = numbers.stream().reduce(1, (a, b) -> a*b);
		System.out.println(product);
		// 求数字列表的最大值
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println(max);
		//求数字列表的最小值
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		System.out.println(min);
		
	}
	/**
	 * 由文件生成流，计算文本中有多少个单词（无重复）
	 */
	public static void countWord() {
		
		long uniqueWords =0;
		// 流会自动关闭
		try(Stream<String> lines = Files.lines(Paths.get("d:\\a.txt"),Charset.defaultCharset())){
			uniqueWords=lines.flatMap(line->Arrays.stream(line.split(" "))).distinct().count();
		}catch(IOException e) {
		// donothing
		}
		System.out.println(uniqueWords);
	}
	/**
	 * 斐波纳契数列是著名的经典编程练习
	 * 数列中开始的两个数字是0和1，后续的每个数字都是前两个数字之和。
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
		// 使用lambda打印
//		jkd7(menu);
//		threeHightCaloriacDishNames.forEach((n) -> System.out.println(n));
		
		// 筛选出所有的素材
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
