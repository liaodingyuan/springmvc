/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:AdvancedMemberStrategy
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
public class AdvancedMemberStrategy implements MemberStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see basecc.pattern.strategy.demo.MemberStrategy#calPrice(double)
	 */
	@Override
	public double calPrice(double booksPrice) {
		System.out.println("���ڸ߼���Ա���ۿ�Ϊ20%");
		return booksPrice * 0.8;
	}

}
