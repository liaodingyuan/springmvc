/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import basecc.pattern.proxy.staticproxy.IServer.Star;

/**
 * <p>
 * Title:StarHandler
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
public class StarHandler implements InvocationHandler {

	/** 真实的角色类 */
	private Star realStar;

	public StarHandler(Star realStar) {
		super();// 比较好的习惯
		this.realStar = realStar;
	}

	/**
	 * 所有的流程控制都在invoke方法中 proxy：代理类 method：正在调用的方法 args：方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object object = null;
		System.out.println("真实角色调用前的处理");
		if ("sing".equals(method.getName())) {
			// 在这里激活真实代理类
			object = method.invoke(realStar, args);
		}
		System.out.println("真实角色调用前的处理");
		return object;
	}

}
