/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import basecc.pattern.proxy.dynamicProxy.UserMgr;
import basecc.pattern.proxy.dynamicProxy.handler.TimeHandler;
import basecc.pattern.proxy.dynamicProxy.handler.TransactionHandler;
import basecc.pattern.proxy.dynamicProxy.impl.UserMgrImpl;

/**
 * <p>
 * Title:Client
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
public class Client {

	public static void main(String[] args) {
		UserMgr usrMgr = new UserMgrImpl();

		// 通过动态代理，添加事务处理（代理应该主要任务是控制对对象的访问而不是添加功能，如果是增强对象的功能应该使用装饰模式）
		InvocationHandler handler = new TransactionHandler(usrMgr);
		// liaody:一个ClassLoader类加载器，总的接口，一个实现了InvocationHandler的handler
		// loader：一个ClassLoader对象，定义了由哪个ClassLoader对象来生成的代理对象进行加载
		// interfaces：一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口（多态），这样我就能调用这组接口中的方法了。
		// 我们给代理对象提供什么接口，那么我们这个代理对象就会实现这个接口
		// h：一个InvocationHandler对象，表示的是当我这个动态代理在调用方法的时候，会关联到哪一个InvocationHandler对象上
		// 使用Proxy.newProxyInstance()创建的代理对象是在JVM上运行时动态产生的一个对象，它并不是InvocationHandler类型，也不是我们定义的那组接口的类型，而是在运行时动态产生的一个对象。并且命名方式是以$开头的，proxy中最后一个数字表示对象的标号。
		// 这里是通过对象来调用实现的那种接口中的方法，这个时候程序就会跳转到由这个代理对象关联到的handler中的invoke方法去执行
		UserMgr userMgrProxy = (UserMgr) Proxy.newProxyInstance(usrMgr.getClass().getClassLoader(),
				usrMgr.getClass().getInterfaces(), handler);
		// 第二次代理，通过动态代理，添加时间处理
		InvocationHandler handler2 = new TimeHandler(userMgrProxy);
		UserMgr userProxy2 = (UserMgr) Proxy.newProxyInstance(userMgrProxy.getClass().getClassLoader(),
				userMgrProxy.getClass().getInterfaces(), handler2);
		userProxy2.addUser();
		System.out.println("--------------------");
		userProxy2.delUser();

		// 代理以栈的运行顺序运行。总的来说就是一个接口，实现该接口的实现类；一个handler类，也叫动态代理类（实现InvocationHandler，有一个属性target，用单参public构造器接收传入的接口的实现类初始化，实现invoke方法）；
		// 客户端，也就是使用handler的地方。客户端是创建代理的地方，使用Proxy的静态方法 Proxy.newProxyInstance创建对象的代理对象。

		//  动态代理的作用：主要用来做方法的增强，让你可以在不修改源码的情况下，增强一些方法，在方法执行前后做任何你想做的事情（甚至根本不去执行这个方法），因为在InvocationHandler的invoke这个方法中，你可以直接获取正在调用方法对应的Method对象，具体应用，比如，添加日志，做事物控制等。
	}

}
