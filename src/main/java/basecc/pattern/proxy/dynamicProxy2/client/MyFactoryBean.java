/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy2.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import basecc.pattern.proxy.dynamicProxy2.aspect.MyAspect;
import basecc.pattern.proxy.dynamicProxy2.service.UserService;
import basecc.pattern.proxy.dynamicProxy2.service.impl.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * <p>
 * Title:MyFactoryBean
 * </p>
 * <p>
 * Description:工厂类，相当于客户端类
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年1月21日
 */
public class MyFactoryBean {

	/**
	 * 利用jdk实现动态代理。使用jdk实现动态代理，必须保证目标类由接口，否则无法实现动态代理。
	 * 
	 * @return
	 */
	public Object getBeanByJdk() {
		// 目标类，即被增强的类
		UserService service = new UserServiceImpl();
		// 切面类，即增强代码类
		MyAspect aspect = new MyAspect();
		// jdk动态代理实现类
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), service.getClass().getInterfaces(),
				new InvocationHandler() {

					// 匿名内部类
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 增强:前置通知
						aspect.before();
						// 目标方法的调用
						Object obj = method.invoke(service, args);
						aspect.after();
						// 增强：后置通知
						return obj;
					}

				});

	}
	/**
	 * @return
	 * 通过cglib实现动态代理,不需要目标类有接口,代理之后返回的是目标类的子类,所以目标类不是final的,
	 * 
	 */
	public Object getBeanByCglib(){
		//目标类,即被增强类
		UserService service=new UserServiceImpl();
		//切面类,即增强代码类
		MyAspect aspect=new MyAspect();
		Enhancer enhancer=new Enhancer();
		//设置父类,即被代理类,cglib的代理对象通过子类实现的
		//因为我们的切入点是方法,所以使用MethodInterceptor
		enhancer.setSuperclass(service.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				//前置通知
				aspect.before();
				//执行目标类的方法有两种方式
				//Object obj=method.invoke(service, args);
				/*执行的是代理对象的父类,在此代理对象是proxy,proxy的父类就是目标类即UserService
				 * 这是cglib的工作机制,即生成目标的的子类,作为代理对象
				 */
				Object obj=methodProxy.invokeSuper(proxy, args);
				//后置通知
				aspect.after();
				return obj;
			}
		});
		//创建代理类:
		Object obj=enhancer.create();
		return obj;
		
		
	}

}
