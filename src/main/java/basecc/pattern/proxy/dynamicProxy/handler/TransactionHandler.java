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
 * @date 2018��1��21��
 */
public class TransactionHandler implements InvocationHandler {
	private Object target;

	/**
	 * Ĭ�Ϲ����������뱻����Ķ���
	 * 
	 * @param target
	 */
	public TransactionHandler(final Object target) {
		this.target = target;
	}

	/**
	 * proxy��ָ���������������ʵ���� method��ָ������������Ҫ������ʵ�����ĳ��������Method����
	 * 
	 * args��ָ�����ǵ�����ʵ����ĳ������ʱ���յĲ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("��������");
		Object obj = method.invoke(target);
		System.out.println("�ύ����");
		return obj;
	}

}
