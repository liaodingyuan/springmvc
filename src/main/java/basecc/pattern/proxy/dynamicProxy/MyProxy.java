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
 * @date 2017��8��2��
 */
public class MyProxy {

	// ����ӿ�
	public interface IHello {

		// �����ǿ����нӿڵ�
		void sayHello();

	}

	static class Hello implements IHello {

		@Override
		public void sayHello() {
			System.out.println("Hello world!");
		}

	}

	// �Զ��崦����
	static class HWInvocationHandler implements InvocationHandler {

		// ��������Ҳ�Ǻ���Ŀ��������õ�

		private Object target;

		public HWInvocationHandler(Object target) {
			this.target = target;

		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("�ͻ��˵�ǰ��֪ͨ");
			// rs�Ƿ���ִ��֮�󷵻صĽ��������ķ��ؽ��Ӧ����null
			Object rs = method.invoke(target, args);
			System.out.println("�ͻ��˵ĺ���֪ͨ");
			return rs;
		}

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		client2();

	}
	
	public static void  client2() {
		
		// ֱ��ʹ���ڲ���̬�࣬�ڲ��಻�ܹ��ӷ������η�		
		HWInvocationHandler handler = new HWInvocationHandler(new Hello());
		IHello proxy = (IHello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IHello.class}, handler);
		// �����Ｄ����ʵ������
		 proxy.sayHello();
		 
		 IHello  ihello = (IHello) Proxy.newProxyInstance(IHello.class.getClassLoader(),  //���ؽӿڵ��������
	               new Class[]{IHello.class},      //һ��ӿ�
	               new HWInvocationHandler(new Hello())); //�Զ����InvocationHandler
		 
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
		// ����$Proxy0��class�ļ�
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		 //����$Proxy0��class�ļ�
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //��ȡ��̬������
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        //��ô�����Ĺ��캯�����������������InvocationHandler.class
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //ͨ�����캯����������̬������󣬽��Զ����InvocationHandlerʵ������
        IHello iHello = (IHello) constructor.newInstance(new HWInvocationHandler(new Hello()));
        //ͨ������������Ŀ�귽��
        iHello.sayHello();
	}

}
