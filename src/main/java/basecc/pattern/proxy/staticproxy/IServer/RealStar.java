/**
 * 
 */
package basecc.pattern.proxy.staticproxy.IServer;

/**
* <p>Title:RealStar </p>
* <p>Description: ��ʵ���ɫ</p>
* <p>Company: </p>
* @author liaody
* @date 2017��8��1��
*/
public class RealStar implements Star{

	// ��ʵ�����ֻҪ����������ʵ��ͬһ���ӿھͿ�����
	
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
		System.out.println("RealStar�ĳ��跽��");
		
	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#clloectMoney()
	 */
	@Override
	public void clloectMoney() {
		// TODO Auto-generated method stub

		System.out.println("RealStar.collectMoney����");

	}

	/* (non-Javadoc)
	 * @see basecc.pattern.proxy.staticproxy.IServer.Star#signConstract()
	 */
	@Override
	public void signConstract() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.signConstract����");

	}

}
