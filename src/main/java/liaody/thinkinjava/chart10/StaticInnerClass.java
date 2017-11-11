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
 * Description:��ʾ��̬�ڲ���
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��4��
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
	* <p>Description:��̬�ڲ��ࣨǶ���ࣩ�ܹ�������̬Ԫ�أ���ͨ�����ڲ����ǲ��ܰ�������̬Ԫ�صġ��� </p>
	* <p>Company: </p>
	* @author liaody
	* @date 2017��11��4��
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
		 * ��̬�ڲ������ܹ�������̬Ԫ��
		 */
		public static void f() {
			
		}

	}

}
