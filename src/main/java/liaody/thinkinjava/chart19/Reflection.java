/**
 * 
 */
package liaody.thinkinjava.chart19;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 * Title:Reflection
 * </p>
 * <p>
 * Description: 使用反射分析Enum
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月12日
 */
public class Reflection {

	public static Set<String> analyze(Class<?> enumClass) {

		System.out.println("interfaces:");
		for (Type t : enumClass.getGenericInterfaces()) {
			System.out.println(t);
		}
		// enum实现的接口
		System.out.println("Base:" + enumClass.getSuperclass());
		System.out.println("Methods:");
		// Set<String> methods = enumClass.getMethods().
		Set<String> methods = new TreeSet<String>();
		for (Method method : enumClass.getMethods()) {
			methods.add(method.getName());
		}
		System.out.println(methods);
		return methods;
	}

	public static void main(String[] args) {

	}

}

enum Explore {
	HERE, THERE
}