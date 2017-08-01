/**
 * 
 */
package basecc.pattern.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import basecc.pattern.proxy.dynamicProxy.StarHandler;
import basecc.pattern.proxy.staticproxy.IServer.ProxyStar;
import basecc.pattern.proxy.staticproxy.IServer.RealStar;
import basecc.pattern.proxy.staticproxy.IServer.Star;

/**
 * <p>
 * Title:ProxyTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class ProxyTest {

	/**
	 * ��̬����
	 */
	@Test
	public void testProxy1() {
		Star realStar = new RealStar();

		Star proxyStar = new ProxyStar(realStar);
		proxyStar.bookTicket();
		proxyStar.clloectMoney();
		proxyStar.confer();
		proxyStar.signConstract();
		proxyStar.sing();
	}

	/**
	 * ��̬����
	 */
	@Test
	public void testProxy2() {

		// ��ʵ��ɫ
		Star realStar = new RealStar();
		// ������
		StarHandler handler = new StarHandler(realStar);
		// ������
		// Star proxy
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },
				handler);

		proxy.sing();
	}
}
