/**
 * 
 */
package basecc.pattern.strategy;

/**
 * <p>
 * Title:ConcreteStrategyB
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
public class ConcreteStrategyB implements Strategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see basecc.pattern.strategy.Strategy#strategyInterface()
	 */
	@Override
	public void strategyInterface() {
		System.out.println("这里是具体的策略执行方法B");

	}

}
