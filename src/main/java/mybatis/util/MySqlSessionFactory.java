/**
 * 
 */
package mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>
 * Title:MySqlSessionFactory
 * </p>
 * <p>
 * Description:使用内部类产生SqlSessionFactory的单例模式。
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月30日
 */
public class MySqlSessionFactory {
	// 禁止外部创建MySqlSessionFactory对象实例
	private MySqlSessionFactory() {

	}
	// 使用静态内部类实现的单例模式
	private static class innserClass {
		// 静态初始化容器，由JVM来保证线程的安全
		private static final SqlSessionFactory factory = craeteSqlSessionFactory();

		/**
		 * 创建SqlSessionFactory对象
		 * @return
		 */
		private static SqlSessionFactory craeteSqlSessionFactory() {

			InputStream input;
			SqlSessionFactory factory = null;
			try {
				input = Resources.getResourceAsStream("mybatis-config.xml");
				 factory = new SqlSessionFactoryBuilder().build(input);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return factory;

		}

	}

	/**
	 * 获取SqlSeesionFactory
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactoryInstance() {

		return innserClass.factory;

	}
}
