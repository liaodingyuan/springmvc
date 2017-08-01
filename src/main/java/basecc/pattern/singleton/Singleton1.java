/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton1
 * </p>
 * <p>
 * Description:饿汉是单例模式。
 * 缺点：如果初始化过程。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public class Singleton1 {

	// 所谓的饿汉式，就是用户还没有调用到的时候，类加载时期就已经创建完毕了
	private static Singleton1 instance;

	// 一个初始化的过程要记得
	static {
		instance = new Singleton1();
	}

	// 禁止用户创建对象的实例，注意如果使用反射机制的话这种机制会失效，可以创建用户的实例
	private Singleton1() {

	}
	
	/**
	 * 返回类的实例
	 * 
	 * @return
	 */
	public static Singleton1 getInstance() {
		return instance;
	}

}
