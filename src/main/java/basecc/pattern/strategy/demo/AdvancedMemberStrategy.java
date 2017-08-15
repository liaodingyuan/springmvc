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
 * @date 2017年8月11日
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see basecc.pattern.strategy.demo.MemberStrategy#calPrice(double)
	 */
	@Override
	public double calPrice(double booksPrice) {
		System.out.println("对于高级会员的折扣为20%");
		return booksPrice * 0.8;
	}

}
