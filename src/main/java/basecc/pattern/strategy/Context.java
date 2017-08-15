/**
 * 
 */
package basecc.pattern.strategy;

/**
 * <p>
 * Title:Context
 * </p>
 * <p>
 * Description: ������ɫ������һ��strategy������
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��11��
 */
public class Context {

	// ����һ������Ĳ���
	private Strategy strategy;

	/**
	 * ���췽������һ������Ĳ��Զ���
	 * 
	 * @param strategy
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	// ���Է���
	public void contextInterface() {
		strategy.strategyInterface();
	}

}
