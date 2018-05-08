/**
 * 
 */
package basecc.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * <p>
 * Title:FunctionTest
 * </p>
 * <p>
 * Description: Function<T, R>接口定义了一个叫作apply的方法，它接受一个
 * 泛型T的对象，并返回一个泛型R的对象。如果你需要定义一个Lambda，将输入对象的信息映射 到输出，就可以使用这个接口
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月5日
 */
public class FunctionTest {
	/**
	 * @FunctionalInterface public interface Function<T, R>{ R apply(T t); }
	 */
	public static void main(String[] args) {

		// (String s)->s.length() 是apply的实现
		List<Integer> l = localmap(Arrays.asList("str","12345","hhhhhhhh"),(String s)->s.length());
		l.forEach((Integer i)->System.out.println(i.toString()));
	}
	//传入一个list。计算每一个元素的长度
	public static <T,R> List<R> localmap(List<T> list,Function<T,R> f){
		List<R> result = new ArrayList<R>();
		for(T i:list) {
			// 客户端去调用，怎么实现是由
			result.add(f.apply(i));
		}		
		return result;
	}

}
