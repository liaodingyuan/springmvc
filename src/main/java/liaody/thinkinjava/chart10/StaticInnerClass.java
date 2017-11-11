/**
 * 
 */
package liaody.thinkinjava.chart10;

import liaody.thinkinjava.chart10.innerfactorymethod.Server;

/**
 * <p>
 * Title:StaticInnerClass
 * </p>
 * <p>
 * Description:演示静态内部类
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年11月4日
 */
public class StaticInnerClass {

	private static class ParceServer implements Server {

		@Override
		public void method1() {
			System.out.print("ParceServer method1");
		}

		@Override
		public void method2() {
			System.out.print("ParceServer method2");
		}

	}

	/**
	 * 
	* <p>Title:ParceSelector </p>
	* <p>Description:静态内部类（嵌套类）能够包含静态元素（普通匿名内部类是不能包含不静态元素的。） </p>
	* <p>Company: </p>
	* @author liaody
	* @date 2017年11月4日
	 */
	protected static class ParceSelector implements Selector {

		private String label;

		private ParceSelector(String label) {
			this.label = label;
		}

		@Override
		public boolean end() {

			return false;
		}

		@Override
		public Object current() {

			return label;
		}

		@Override
		public void next() {
			System.out.println(label + " next");
		}
		/**
		 * 静态内部类中能够包含静态元素
		 */
		public static void f() {
			
		}

	}

}
