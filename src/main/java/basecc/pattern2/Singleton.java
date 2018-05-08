/**
 * 
 */
package basecc.pattern2;

/**
 * <p>
 * Title:Singleton
 * </p>
 * <p>
 * Description:使用内部类创建单例模式
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月3日
 */
public class Singleton {
	// 私有的构造方法
	private Singleton() {

	}

	// static final 类
	private static final class InnerClass {
		private static final Singleton INSTANCE = new Singleton();

	}

	// public static getInstance
	public static Singleton getInstance() {
		return InnerClass.INSTANCE;
	}

}
