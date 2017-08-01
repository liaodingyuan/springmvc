/**
 * 
 */
package basecc.pattern.singleton;

/**
 * <p>
 * Title:Singleton4
 * </p>
 * <p>
 * Description: ������������Ҫע�⣺
 * 1.��������ɲ�ͬ����װ����װ�룬�Ǳ��п��ܴ��ڶ���������ʵ�����ٶ�����Զ�˴�ȡ������һЩservlet������ÿ��servletʹ����ȫ��ͬ����װ�����������Ļ����������servlet����һ�������࣬���ǾͶ����и��Ե�ʵ����
 * 2.���Singletonʵ����java.io.Serializable�ӿڣ���ô������ʵ���Ϳ��ܱ����л��͸�ԭ��������������������л�һ��������Ķ��󣬽�������ԭ����Ǹ���������ͻ��ж���������ʵ����
 * �Ե�һ�������޸��İ취��getInstance1
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��1��
 */
public class Singleton4 {
	
	// ��֤ÿ��ʵ�����õ���ͬһ���������
	public Class getInstance1(String name) throws ClassNotFoundException {
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		if(null == classLoader)
			classLoader = Singleton4.class.getClassLoader();
		
		return (classLoader.loadClass(name));
	}
	

}
