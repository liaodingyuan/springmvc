/**
 * 
 */
package liaody.thinkinjava.chart10.innerfactorymethod;

/**
 * <p>
 * Title:Implementation1
 * </p>
 * <p>
 * Description:ʹ�������ڲ��๹�������������������
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��4��
 */
public class Implementation1 implements Server {

	@Override
	public void method1() {
		System.out.print("Implemntation1 method1");
	}

	@Override
	public void method2() {
		System.out.print("Implemntation1 method2");
	}

	public static ServerFactory factory = new ServerFactory() {

		@Override
		public Server getServer() {

			return new Implementation1();
		}

	};

}
