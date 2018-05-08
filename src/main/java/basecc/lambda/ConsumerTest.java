/**
 * 
 */
package basecc.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
* <p>Title:ConsumerTest </p>
* <p>Description: java.util.function.Consumer<T>定义了一个名叫accept的抽象方法，它接受泛型T
的对象，没有返回（void） 。你如果需要访问类型T的对象，并对其执行某些操作，就可以使用
这个接口。比如，你可以用它来创建一个forEach方法，接受一个Integers的列表，并对其中
每个元素执行操作。</p>
* <p>Company: </p>
* @author liaody
* @date 2018年5月5日
*/
public class ConsumerTest {
	/**
	public interface Consumer<T>{
void accept(T t);
}

	 *
	 */
	public static void main(String[] args) {
	
		forEach(
				Arrays.asList(1,2,3,4,5),
				(Integer i) -> System.out.println(i)
				);
	}
	
	public static <T> void forEach(List<T> list,Consumer<T> c) {
		for(T i:list) {
			// (Integer i) -> System.out.println(i)是accept的实现
			// 客户端函数要调用函数接口中的抽象方法，最终客户端调用的时候，传入函数接口中抽象方法的实现。
			c.accept(i);
		}
	}

}
