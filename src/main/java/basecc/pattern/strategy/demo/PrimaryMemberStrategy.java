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
 * 计算初级会员的折扣率
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月11日
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calPrice(double booksPrice) {
		System.out.println("对于初级会员的没有折扣");
		return booksPrice;

	}

}
