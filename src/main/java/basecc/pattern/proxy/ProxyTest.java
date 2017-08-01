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
 * @date 2017年8月1日
 */
public class ProxyTest {

	/**
	 * 静态代理
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
	 * 动态代理
	 */
	@Test
	public void testProxy2() {

		// 真实角色
		Star realStar = new RealStar();
		// 处理器
		StarHandler handler = new StarHandler(realStar);
		// 代理类
		// Star proxy
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] { Star.class },
				handler);

		proxy.sing();
	}
}
