/**
 * 
 */
package basecc.pattern.proxy.staticproxy.IServer;

/**
 * <p>
 * Title:ProxyStar
 * </p>
 * <p>
 * Description: 代理类
 * 
 * 将统一的流程控制都放到代理角色中处理！
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public class ProxyStar implements Star {
	// 0.实现与真实类实现的同一个接口
	/** 1. 真实对象的引用。代理类中要含有真实对象的引用，不然怎么代理 */
	private Star star;
	// 2.通过构造器给真实的角色赋值
	public ProxyStar(Star star) {

		this.star = star;
	}

	@Override
	public void bookTicket() {
		System.out.println("这里是代理类的订票方法");

	}

	@Override
	public void confer() {
		System.out.println("这里是代理类的confer方法");

	}

	@Override
	public void sing() {
		// 真实类只负责唱歌，其他的都交给了代理类
		star.sing();

	}

	@Override
	public void clloectMoney() {
		System.out.println("这里是代理类的collectMoney方法");

	}

	@Override
	public void signConstract() {
		System.out.println("这里是代理类的signConstract方法");

	}

}
