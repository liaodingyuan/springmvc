/**
 * 
 */
package liaody.java.chart7;

/**
 * <p>
 * Title:NotInitialization
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月12日
 */
public class NotInitialization {

	public static void main(String[] args) {

		// 并没有实际分配空间，所以不会触发谷类的初始化过程。
		SuperClass[] superC = new SuperClass[10];
		// 被动引用例子1，通过子类来引用父类的静态成员，不会触发子类的初始化
		System.out.println(SubClass.value);
	}
}
