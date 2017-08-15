/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:Price
 * </p>
 * <p>
 * Description:
 * 
 * ����Ŀͻ����ࡣ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��11��
 */
public class Price {

	// �ͻ��˳���һ����������߽ӿڵ�����
	private MemberStrategy strategy;

	/**
	 * ���췽����������ʵ����
	 * 
	 * @param strategy
	 */
	public Price(MemberStrategy strategy) {
		this.strategy = strategy;
	}

	public double quote(double booksPrice) {
		return this.strategy.calPrice(booksPrice);
	}

}
