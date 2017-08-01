/**
 * 
 */
package basecc.pattern.proxy.staticproxy.IServer;

/**
* <p>Title:RealStar </p>
* <p>Description: 真实类角色</p>
* <p>Company: </p>
* @author liaody
* @date 2017年8月1日
*/
public class RealStar implements Star{

	// 真实类对象只要与代理类对象实现同一个接口就可以了
	
	@Override
	public void bookTicket() {
	
		System.out.println("RealStar.bookTicket()");
		
	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#confer()
	 */
	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
		
	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#sing()
	 */
	@Override
	public void sing() {
		System.out.println("RealStar的唱歌方法");
		
	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#clloectMoney()
	 */
	@Override
	public void clloectMoney() {
		// TODO Auto-generated method stub

		System.out.println("RealStar.collectMoney方法");

	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#signConstract()
	 */
	@Override
	public void signConstract() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.signConstract方法");

	}

}
