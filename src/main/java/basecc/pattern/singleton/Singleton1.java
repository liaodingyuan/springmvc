/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton1
 * </p>
 * <p>
 * Description:�����ǵ���ģʽ��
 * ȱ�㣺�����ʼ�����̡�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class Singleton1 {

	// ��ν�Ķ���ʽ�������û���û�е��õ���ʱ�������ʱ�ھ��Ѿ����������
	private static Singleton1 instance;

	// һ����ʼ���Ĺ���Ҫ�ǵ�
	static {
		instance = new Singleton1();
	}

	// ��ֹ�û����������ʵ����ע�����ʹ�÷�����ƵĻ����ֻ��ƻ�ʧЧ�����Դ����û���ʵ��
	private Singleton1() {

	}
	
	/**
	 * �������ʵ��
	 * 
	 * @return
	 */
	public static Singleton1 getInstance() {
		return instance;
	}

}
