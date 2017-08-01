/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton2
 * </p>
 * <p>
 * Description:����ʽ����ģʽ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class Singleton2 {

	// �������г�ʼ������Ҫ�õ���ʱ��Ž��г�ʼ�����������ν������
	private static Singleton2 instance;

	// default constructor
	private Singleton2() {

	}

	/**
	 * �̲߳���ȫ������ʽ �������ڶ��̻߳����в��ܹ�ʹ�á�
	 * 
	 * @return ����ģʽ�����Ķ���
	 */
	public static Singleton2 getInstance() {

		// ����ʽ��ʹ�õ���ʱ��Ż���г�ʼ��
		// �̲߳���ȫ��line39�߳��п��ܻ�ʧȥ����Ȩ�����´����˶�������ʵ��
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}

	/**
	 * �̰߳�ȫ������ʽ ֱ�Ӷ�������������ͬ�����򵥵���Ч�ʵ͡� ��ʹ��ͬ����ʱ��Ҫע��ֻ����Ҫͬ���Ĳ������ͬ����
	 * 
	 * @return
	 */
	public static synchronized Singleton2 getInstance3() {
		if (null == instance)
			instance = new Singleton2();

		return instance;
	}

	/**
	 * ˫��У����
	 * 
	 * @return
	 */
	public static Singleton2 getInstance2() {

		// ��ʱ���instanceӦ��ʹ�� volatile�ؼ�������
		if (null == instance) {
			// ʹ���ڲ������м���
			// ���⻰��������ʹ��Java�ṩ���̰߳�ȫ�����ݽṹ���Ȳ�ʹ���ڲ���Ҳʹ����������
			synchronized (Singleton2.class) {

				// ���еڶ��μ��
				if (null == instance)
					instance = new Singleton2();

			}
		}

		return instance;
	}

}
