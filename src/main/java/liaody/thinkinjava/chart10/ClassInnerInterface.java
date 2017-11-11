/**
 * 
 */
package liaody.thinkinjava.chart10;

/**
 * <p>
 * Title:ClassInnerInterface
 * </p>
 * <p>
 * Description:静态内部类也就是嵌套类可以作为接口的一部分，正常情况下接口不能够防止任何的代码。 放在在接口的任何类都自动的成为 public
 * static。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月4日
 */
public interface ClassInnerInterface {

	void howdy();

	// 接口中的任何代码都会自动成为public static
	class Test implements ClassInnerInterface {
		@Override
		public void howdy() {
			System.out.println("Howdy");
		}

		public static void main(String[] args) {
			new Test().howdy();
		}
	}
}
