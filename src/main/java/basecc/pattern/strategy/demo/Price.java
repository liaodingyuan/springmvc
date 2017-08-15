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
 * 具体的客户端类。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月11日
 */
public class Price {

	// 客户端持有一个抽象类或者接口的引用
	private MemberStrategy strategy;

	/**
	 * 构造方法传入具体的实现类
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
