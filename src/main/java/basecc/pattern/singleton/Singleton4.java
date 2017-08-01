/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton4
 * </p>
 * <p>
 * Description: 有两个问题需要注意：
 * 1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
 * 2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
 * 对第一个问题修复的办法是getInstance1
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月1日
 */
public class Singleton4 {
	
	// 保证每个实例采用的是同一个类加载器
	public Class getInstance1(String name) throws ClassNotFoundException {
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		if(null == classLoader)
			classLoader = Singleton4.class.getClassLoader();
		
		return (classLoader.loadClass(name));
	}
	

}
