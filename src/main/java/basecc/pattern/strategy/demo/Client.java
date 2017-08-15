/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:Client
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��11��
 */
public class Client {

	public static void main(String[] args) {
		// ѡ�񲢴�����Ҫʹ�õĲ��Զ���
		MemberStrategy strategy = new AdvancedMemberStrategy();
		// ��������
		Price price = new Price(strategy);
		// ����۸�
		double quote = price.quote(300);
		System.out.println("ͼ������ռ۸�Ϊ��" + quote);
	}

}
