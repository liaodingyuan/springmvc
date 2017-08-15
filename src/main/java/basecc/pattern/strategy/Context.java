/**
 * 
 */
package basecc.pattern.strategy;

/**
 * <p>
 * Title:Context
 * </p>
 * <p>
 * Description: 环境角色，持有一个strategy的引用
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月11日
 */
public class Context {

	// 持有一个具体的策略
	private Strategy strategy;

	/**
	 * 构造方法传入一个具体的策略对象
	 * 
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// 策略方法
	public void contextInterface() {
		strategy.strategyInterface();
	}

}
