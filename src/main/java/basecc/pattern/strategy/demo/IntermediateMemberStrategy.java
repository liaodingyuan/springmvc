/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:IntermediateMemberStrategy
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
public class IntermediateMemberStrategy implements MemberStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see basecc.pattern.strategy.demo.MemberStrategy#calPrice(double)
	 */
	@Override
	public double calPrice(double booksPrice) {
		System.out.println("对于中级会员的折扣为10%");
		return booksPrice * 0.9;
	}

}
