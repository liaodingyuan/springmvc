/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:PrimaryMemberStrategy
 * </p>
 * <p>
 * Description:
 * 
 * ���������Ա���ۿ���
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��11��
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calPrice(double booksPrice) {
		System.out.println("���ڳ�����Ա��û���ۿ�");
		return booksPrice;

	}

}
