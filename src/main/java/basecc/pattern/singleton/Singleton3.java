/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton3
 * </p>
 * <p>
 * Description:使用内部类实现单例模式
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public class Singleton3 {

	private Singleton3() {

	}

	// 当外部类被初始化时，内部类并没有被初始化
	// 只有Inner类被主动调用的时候
	private static class Inner {
		// 如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，我不希望在Singleton3类加载时就实例化，因为我不能确保Singleton3类还可能在其他的地方被主动使用从而
		// 被加载，那么这个时候实例化instance显然是不合适的。
		private static Singleton3 instance = new Singleton3();

	}

	/**
	 * 返回单例模式对象
	 * 
	 * @return
	 */
	public static Singleton3 getInstance() {
		return Inner.instance;
	}
}
