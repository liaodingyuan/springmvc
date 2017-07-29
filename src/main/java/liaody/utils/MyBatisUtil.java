/**
 * 
 */
package liaody.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import liaody.constantscodes.ConstantCodes;

/**
 * <p>
 * Title:MyBatisUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月28日
 */
public class MyBatisUtil {
	
	// 饿汉式单例模式
	public  static final SqlSessionFactory sqlSessionFactory = getSqlSessionFactory() ;

	public MyBatisUtil() {

	}

	/**
	 * 获取SqlSessionFactory
	 * 仅适用于测试使用，一般情况下应该使用单例模式保证只有一个SqlSeesionFactory
	 * @return SqlSessionFactory
	 */
	private static SqlSessionFactory getSqlSessionFactory() {
		String resource = ConstantCodes.MYBATIS_CONFIG_FILE;
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}

	/**
	 * 获取SqlSession
	 * 
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	/**
	 * 获取SqlSession
	 * 
	 * @param isAutoCommit
	 *            true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务 false
	 *            表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) {
		return sqlSessionFactory.openSession(isAutoCommit);
	}
}
