/**
 * 
 */
package basecc.pattern2;

/**
 * <p>
 * Title:Singleton
 * </p>
 * <p>
 * Description:ʹ���ڲ��ഴ������ģʽ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��5��3��
 */
public class Singleton {
	// ˽�еĹ��췽��
	private Singleton() {

	}

	// static final ��
	private static final class InnerClass {
		private static final Singleton INSTANCE = new Singleton();

	}

	// public static getInstance
	public static Singleton getInstance() {
		return InnerClass.INSTANCE;
	}

}
