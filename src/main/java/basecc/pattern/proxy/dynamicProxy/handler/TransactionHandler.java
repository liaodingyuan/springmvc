/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * Title:TransactionHandler
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年1月21日
 */
public class TransactionHandler implements InvocationHandler {
	private Object target;

	/**
	 * 默认构造器。传入被代理的对象。
	 * 
	 * @param target
	 */
	public TransactionHandler(final Object target) {
		this.target = target;
	}

	/**
	 * proxy：指代我们所代理的真实对象 method：指代的是我们所要调用真实对象的某个方法的Method对象
	 * 
	 * args：指代的是调用真实对象某个方法时接收的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("开启事务");
		Object obj = method.invoke(target);
		System.out.println("提交事务");
		return obj;
	}

}
