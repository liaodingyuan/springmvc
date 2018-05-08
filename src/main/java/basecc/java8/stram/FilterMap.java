/**
 * 
 */
package basecc.java8.stram;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * <p>
 * Title:FilterMap
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
public class FilterMap {

	/**
	 * With Java 8, you can convert a Map.entrySet() into a stream, follow by a
	 * filter() and collect() it.
	 */
	@Test
	public void test001() {

		Map<Integer, String> map = new HashMap<>();
		map.put(2, "number1");
		map.put(1, "number2");
		map.put(3, "number3");
		// Map->Stream->Filter->String
		String result = map.entrySet().stream().filter(entry -> "number1".equals(entry.getValue()))
				.map(x -> x.getValue()).collect(Collectors.joining());
		System.out.println(result);
		// Map->Stream->Filter->String
		Map<Integer, String> result2 = map.entrySet().stream().filter(entry -> entry.getKey() > 0)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		result2.entrySet().stream().map(mapper -> mapper.getKey() + ":" + mapper.getValue())
				.forEach(System.out::println);

		// Map -> Stream -> Filter -> MAP
		Map<Integer, String> collect = map.entrySet().stream().filter(x -> x.getKey() == 2)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		// or like this
		Map<Integer, String> result3 = map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	/**
	 * A full example to filter a Map by values and return a String.
	 */
	@Test
	public void test002() {
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		// Before Java 8
		String result = "";
		for (Map.Entry<Integer, String> entry : HOSTING.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}
		System.out.println("Before Java 8 : " + result);

		// Map -> Stream -> Filter -> String
		HOSTING.entrySet().stream().filter(x -> "aws.amazon.com".equals(x.getValue())).map(x -> x.getValue())
				.forEach(System.out::println);

		// filter more values
		String result1 = HOSTING.entrySet().stream().filter(x -> {
			if (x.getValue().contains("amazon") || x.getValue().contains("digital")) {
				return true;
			}
			return false;
		}).map(x -> x.getValue()).collect(Collectors.joining(","));
		System.out.println("filter more values:" + result1);
	}

	/**
	 * Yet another example to filter a Map by key, but this time will return a Map
	 */
	@Test
	public void test003() {
		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");

		// Map -> Stream -> Filter -> Map
		Map<Integer, String> result = HOSTING.entrySet().stream().filter(x -> x.getKey() == 2)
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		Map<Integer, String> result2 = HOSTING.entrySet().stream().filter(x -> x.getKey() == 2)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(result);
		System.out.println(result2);
	}

	/**
	 * This time, try the new Java 8 Predicate
	 */
	@Test
	public void test004() {

		Map<Integer, String> HOSTING = new HashMap<>();
		HOSTING.put(1, "linode.com");
		HOSTING.put(2, "heroku.com");
		HOSTING.put(3, "digitalocean.com");
		HOSTING.put(4, "aws.amazon.com");
		HOSTING.put(5, "aws2.amazon.com");
		// {1=linode.com}
		Map<Integer, String> filteredMap = filterByValue(HOSTING, x -> x.contains("linode"));
		System.out.println(filteredMap);

		// {1=linode.com, 4=aws.amazon.com, 5=aws2.amazon.com}
		Map<Integer, String> filteredMap2 = filterByValue(HOSTING, x -> (x.contains("aws") || x.contains("linode")));
		System.out.println(filteredMap2);

		// {4=aws.amazon.com}
		Map<Integer, String> filteredMap3 = filterByValue(HOSTING, x -> (x.contains("aws") && !x.contains("aws2")));
		System.out.println(filteredMap3);

		// {1=linode.com, 2=heroku.com}
		Map<Integer, String> filteredMap4 = filterByValue(HOSTING, x -> (x.length() <= 10));
		System.out.println(filteredMap4);

	}

	@Test
	public void test005() {
		// List<Integer> transactionsIds =
		// transactions.stream()
		// .filter(t -> t.getType() == Transaction.GROCERY)
		// .sorted(comparing(Transaction::getValue).reversed()) // 倒序
		// .map(Transaction::getId)
		// .collect(toList());
	}

	@Test
	public void test006() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = numbers.stream().filter(n -> {
			// System.out.println("filtering " + n);
			return n % 2 == 0;
		}).map(n -> {
			// System.out.println("mapping " + n);
			return n * n;
		}).sorted(Comparator.reverseOrder()).limit(4) // 取出头两条
				.collect(Collectors.toList());
		// 对集合排序 sorted(Integer::compare) 顺序
		// sorted(Comparator.reverseOrder()) 逆序
		// Comparator.naturalOrder() 按照自然序排序(其实就是默认顺序) 
		// sorted() 按照默认顺序排序
		// Comparator.comparing(Transaction::getValue).reversed()
		
		
		
		twoEvenSquares.forEach(System.out::println);
	}

	private <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> p) {
		return map.entrySet().stream().filter(x -> p.test(x.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
}
