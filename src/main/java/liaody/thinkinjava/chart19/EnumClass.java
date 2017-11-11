/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
 * <p>
 * Title:EnumClass
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月11日
 */
public class EnumClass {

	public static void main(String[] args) {
		// .values()方法严格按照enum实例在enum中声明的人顺序遍历所有的实例。
		for (Shrubbery s : Shrubbery.values()) {
			System.out.println("ordinal方法返回senum实例在enum中声明的顺序：" + s.ordinal());
			System.out.println("Enum实现了Comparable接口和Serailizable接口，所有可以使用comparaTo方法");
			System.out.println(s.compareTo(Shrubbery.CRAWLING));
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
		}
		
		for(String s:"GROUND,CRAWLING,HANGING".split(",")) {
			Shrubbery shru = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shru.name());
		}
	}
}

/**
 * <p>
 * Title:Shrubbery
 * </p>
 * <p>
 * Description:创建枚举类型
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月11日
 */
enum Shrubbery {
	GROUND, CRAWLING, HANGING;
	public static void main(String[] args) {
		System.out.println("Here is Enum!");
	}
}

class InnerClass{
	public static void main(String[] args) {

		System.out.println("This's Inner Class！");
	}
}
