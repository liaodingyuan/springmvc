/**
 * 
 */
package liaody.thinkinjava.chart10;

/**
 * <p>
 * Title:ClassInnerInterface
 * </p>
 * <p>
 * Description:��̬�ڲ���Ҳ����Ƕ���������Ϊ�ӿڵ�һ���֣���������½ӿڲ��ܹ���ֹ�κεĴ��롣 �����ڽӿڵ��κ��඼�Զ��ĳ�Ϊ public
 * static��
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��11��4��
 */
public interface ClassInnerInterface {

	void howdy();

	// �ӿ��е��κδ��붼���Զ���Ϊpublic static
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
