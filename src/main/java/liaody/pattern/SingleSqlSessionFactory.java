/**
 * 
 */
package liaody.pattern;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * <p>
 * Title:SingleSqlSressionFactory
 * </p>
 * <p>
 * Description: 使用单例模式残生SqlSesssionFactory
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月28日
 */
public class SingleSqlSessionFactory {

	// private static final SingleSqlSressionFactory sqlSessionFactory = null;;

	// 私有化的构造方法
	private SingleSqlSessionFactory() {

	}

	// 内部类
	private class InnerSingleSqlSressionFactory {

		public InnerSingleSqlSressionFactory() {
			super();
		}

		public void createSqlSessionFactory() throws IOException {

			// 加载放置在类路径下的mybatis-config.xml文件
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// 这里只是测试，应该使用单例模式创建SqlSressionFactory。它是线程安全的。
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}

	}

}
