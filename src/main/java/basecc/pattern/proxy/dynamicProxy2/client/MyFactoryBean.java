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
 * Description:�����࣬�൱�ڿͻ�����
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��1��21��
 */
public class MyFactoryBean {

	/**
	 * ����jdkʵ�ֶ�̬����ʹ��jdkʵ�ֶ�̬�������뱣֤Ŀ�����ɽӿڣ������޷�ʵ�ֶ�̬����
	 * 
	 * @return
	 */
	public Object getBeanByJdk() {
		// Ŀ���࣬������ǿ����
		UserService service = new UserServiceImpl();
		// �����࣬����ǿ������
		MyAspect aspect = new MyAspect();
		// jdk��̬����ʵ����
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), service.getClass().getInterfaces(),
				new InvocationHandler() {

					// �����ڲ���
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// ��ǿ:ǰ��֪ͨ
						aspect.before();
						// Ŀ�귽���ĵ���
						Object obj = method.invoke(service, args);
						aspect.after();
						// ��ǿ������֪ͨ
						return obj;
					}

				});

	}
	/**
	 * @return
	 * ͨ��cglibʵ�ֶ�̬����,����ҪĿ�����нӿ�,����֮�󷵻ص���Ŀ���������,����Ŀ���಻��final��,
	 * 
	 */
	public Object getBeanByCglib(){
		//Ŀ����,������ǿ��
		UserService service=new UserServiceImpl();
		//������,����ǿ������
		MyAspect aspect=new MyAspect();
		Enhancer enhancer=new Enhancer();
		//���ø���,����������,cglib�Ĵ������ͨ������ʵ�ֵ�
		//��Ϊ���ǵ�������Ƿ���,����ʹ��MethodInterceptor
		enhancer.setSuperclass(service.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				//ǰ��֪ͨ
				aspect.before();
				//ִ��Ŀ����ķ��������ַ�ʽ
				//Object obj=method.invoke(service, args);
				/*ִ�е��Ǵ������ĸ���,�ڴ˴��������proxy,proxy�ĸ������Ŀ���༴UserService
				 * ����cglib�Ĺ�������,������Ŀ��ĵ�����,��Ϊ�������
				 */
				Object obj=methodProxy.invokeSuper(proxy, args);
				//����֪ͨ
				aspect.after();
				return obj;
			}
		});
		//����������:
		Object obj=enhancer.create();
		return obj;
		
		
	}

}
