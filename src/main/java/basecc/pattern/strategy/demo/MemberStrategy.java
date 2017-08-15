/**
 * 
 */
package basecc.pattern.strategy.demo;

/**
 * <p>
 * Title:MemberStrategy
 * </p>
 * <p>
 * Description: 计算不同会员对应的折扣率。
 * 
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月11日
 */
public interface MemberStrategy {

	/**
	 * 计算图书的价格
	 * 
	 * @param booksPrice
	 * @return
	 */
	double calPrice(double booksPrice);
}
