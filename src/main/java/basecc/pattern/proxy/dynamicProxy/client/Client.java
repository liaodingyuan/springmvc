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
 * @date 2018��1��21��
 */
public class Client {

	public static void main(String[] args) {
		UserMgr usrMgr = new UserMgrImpl();

		// ͨ����̬�����������������Ӧ����Ҫ�����ǿ��ƶԶ���ķ��ʶ�������ӹ��ܣ��������ǿ����Ĺ���Ӧ��ʹ��װ��ģʽ��
		InvocationHandler handler = new TransactionHandler(usrMgr);
		// liaody:һ��ClassLoader����������ܵĽӿڣ�һ��ʵ����InvocationHandler��handler
		// loader��һ��ClassLoader���󣬶��������ĸ�ClassLoader���������ɵĴ��������м���
		// interfaces��һ��Interface��������飬��ʾ�����ҽ�Ҫ������Ҫ����Ķ����ṩһ��ӿڣ�������ṩ��һ��ӿڸ�������ô���������������ʵ���˸ýӿڣ���̬���������Ҿ��ܵ�������ӿ��еķ����ˡ�
		// ���Ǹ���������ṩʲô�ӿڣ���ô��������������ͻ�ʵ������ӿ�
		// h��һ��InvocationHandler���󣬱�ʾ���ǵ��������̬�����ڵ��÷�����ʱ�򣬻��������һ��InvocationHandler������
		// ʹ��Proxy.newProxyInstance()�����Ĵ����������JVM������ʱ��̬������һ��������������InvocationHandler���ͣ�Ҳ�������Ƕ��������ӿڵ����ͣ�����������ʱ��̬������һ�����󡣲���������ʽ����$��ͷ�ģ�proxy�����һ�����ֱ�ʾ����ı�š�
		// ������ͨ������������ʵ�ֵ����ֽӿ��еķ��������ʱ�����ͻ���ת���������������������handler�е�invoke����ȥִ��
		UserMgr userMgrProxy = (UserMgr) Proxy.newProxyInstance(usrMgr.getClass().getClassLoader(),
				usrMgr.getClass().getInterfaces(), handler);
		// �ڶ��δ���ͨ����̬�������ʱ�䴦��
		InvocationHandler handler2 = new TimeHandler(userMgrProxy);
		UserMgr userProxy2 = (UserMgr) Proxy.newProxyInstance(userMgrProxy.getClass().getClassLoader(),
				userMgrProxy.getClass().getInterfaces(), handler2);
		userProxy2.addUser();
		System.out.println("--------------------");
		userProxy2.delUser();

		// ������ջ������˳�����С��ܵ���˵����һ���ӿڣ�ʵ�ָýӿڵ�ʵ���ࣻһ��handler�࣬Ҳ�ж�̬�����ࣨʵ��InvocationHandler����һ������target���õ���public���������մ���Ľӿڵ�ʵ�����ʼ����ʵ��invoke��������
		// �ͻ��ˣ�Ҳ����ʹ��handler�ĵط����ͻ����Ǵ�������ĵط���ʹ��Proxy�ľ�̬���� Proxy.newProxyInstance��������Ĵ������

		//  ��̬��������ã���Ҫ��������������ǿ����������ڲ��޸�Դ�������£���ǿһЩ�������ڷ���ִ��ǰ�����κ������������飨����������ȥִ���������������Ϊ��InvocationHandler��invoke��������У������ֱ�ӻ�ȡ���ڵ��÷�����Ӧ��Method���󣬾���Ӧ�ã����磬�����־����������Ƶȡ�
	}

}
