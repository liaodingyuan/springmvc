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
 * @date 2017��8��1��
 */
public class StarHandler implements InvocationHandler {

	/** ��ʵ�Ľ�ɫ�� */
	private Star realStar;

	public StarHandler(Star realStar) {
		super();// �ȽϺõ�ϰ��
		this.realStar = realStar;
	}

	/**
	 * ���е����̿��ƶ���invoke������ proxy�������� method�����ڵ��õķ��� args�������Ĳ���
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		Object object = null;
		System.out.println("��ʵ��ɫ����ǰ�Ĵ���");
		if ("sing".equals(method.getName())) {
			// �����Ｄ����ʵ������
			object = method.invoke(realStar, args);
		}
		System.out.println("��ʵ��ɫ����ǰ�Ĵ���");
		return object;
	}

}
