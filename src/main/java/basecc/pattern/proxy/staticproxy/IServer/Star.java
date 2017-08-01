/**
 * 
 */
package basecc.pattern.proxy.staticproxy.IServer;

/**
 * <p>
 * Title:Start
 * </p>
 * <p>
 * Description: 定义一个抽象角色接口。 为代理角色和真实角色提供一致对外的方法。 也就是说代理类和真实类都会实现同一个接口
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public interface Star {
	// 订票
	void bookTicket();

	// 面谈
	void confer();

	// 唱歌
	void sing();

	// 收钱
	void clloectMoney();

	// 谈合同
	void signConstract();

}
