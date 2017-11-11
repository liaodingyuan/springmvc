/**
 * 
 */
package liaody.thinkinjava.chart10.innerfactorymethod;

/**
 * <p>
 * Title:Implementation2
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017Äê11ÔÂ4ÈÕ
 */
public class Implementation2 implements Server {
	@Override
	public void method1() {
		System.out.println("Implementation2 method1");

	}

	@Override
	public void method2() {
		System.out.println("Implementation2 method1");

	}

	public static ServerFactory factory = new ServerFactory() {

		@Override
		public Server getServer() {
			return new Implementation2();
		}

	};

}
