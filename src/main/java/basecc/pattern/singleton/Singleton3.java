/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton3
 * </p>
 * <p>
 * Description:ʹ���ڲ���ʵ�ֵ���ģʽ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class Singleton3 {

	private Singleton3() {

	}

	// ���ⲿ�౻��ʼ��ʱ���ڲ��ಢû�б���ʼ��
	// ֻ��Inner�౻�������õ�ʱ��
	private static class Inner {
		// ���ʵ����instance��������Դ�����������ӳټ��أ�����һ���棬�Ҳ�ϣ����Singleton3�����ʱ��ʵ��������Ϊ�Ҳ���ȷ��Singleton3�໹�����������ĵط�������ʹ�ôӶ�
		// �����أ���ô���ʱ��ʵ����instance��Ȼ�ǲ����ʵġ�
		private static Singleton3 instance = new Singleton3();

	}

	/**
	 * ���ص���ģʽ����
	 * 
	 * @return
	 */
	public static Singleton3 getInstance() {
		return Inner.instance;
	}
}
