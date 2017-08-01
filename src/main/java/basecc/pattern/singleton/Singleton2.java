/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton2
 * </p>
 * <p>
 * Description:懒汉式单例模式
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public class Singleton2 {

	// 并不进行初始化，需要用到的时候才进行初始化，这就是所谓的懒汉
	private static Singleton2 instance;

	// default constructor
	private Singleton2() {

	}

	/**
	 * 线程不安全的懒汉式 致命：在多线程环境中不能够使用。
	 * 
	 * @return 单例模式产生的对象
	 */
	public static Singleton2 getInstance() {

		// 懒汉式：使用到的时候才会进行初始化
		// 线程不安全，line39线程有可能会失去控制权，导致创建了多个对象的实例
		if (null == instance) {
			instance = new Singleton2();
		}
		return instance;
	}

	/**
	 * 线程安全的懒汉式 直接对整个方法进行同步，简单但是效率低。 在使用同步的时候，要注意只对需要同步的步骤进行同步。
	 * 
	 * @return
	 */
	public static synchronized Singleton2 getInstance3() {
		if (null == instance)
			instance = new Singleton2();

		return instance;
	}

	/**
	 * 双重校验锁
	 * 
	 * @return
	 */
	public static Singleton2 getInstance2() {

		// 这时候的instance应该使用 volatile关键字申明
		if (null == instance) {
			// 使用内部锁进行加锁
			// 题外话：尽可能使用Java提供的线程安全的数据结构，既不使用内部锁也使用重入锁。
			synchronized (Singleton2.class) {

				// 进行第二次检查
				if (null == instance)
					instance = new Singleton2();

			}
		}

		return instance;
	}

}
