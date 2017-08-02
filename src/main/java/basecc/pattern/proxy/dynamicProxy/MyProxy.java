/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Title:MyProxy
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月2日
 */
public class MyProxy {

	// 定义接口
	public interface IHello {

		// 类里是可以有接口的
		void sayHello();

	}

	static class Hello implements IHello {

		@Override
		public void sayHello() {
			System.out.println("Hello world!");
		}

	}

	// 自定义处理器
	static class HWInvocationHandler implements InvocationHandler {

		// 处理器中也是含有目标类的引用的

		private Object target;

		public HWInvocationHandler(Object target) {
			this.target = target;

		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("客户端的前置通知");
			// rs是方法执行之后返回的结果，这里的返回结果应该是null
			Object rs = method.invoke(target, args);
			System.out.println("客户端的后置通知");
			return rs;
		}

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		client2();

	}
	
	public static void  client2() {
		
		// 直接使用内部静态类，内部类不能够加访问修饰符		
		HWInvocationHandler handler = new HWInvocationHandler(new Hello());
		IHello proxy = (IHello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IHello.class}, handler);
		// 在这里激活真实代理类
		 proxy.sayHello();
		 
		 IHello  ihello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),  //加载接口的类加载器
	               new Class[]{IHello.class},      //一组接口
	               new HWInvocationHandler(new Hello())); //自定义的InvocationHandler
		 
		 ihello.sayHello();
	}

	/**
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static void client1()
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		// 生成$Proxy0的class文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		 //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        //获得代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //通过构造函数来创建动态代理对象，将自定义的InvocationHandler实例传入
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //通过代理对象调用目标方法
        iHello.sayHello();
	}

}
