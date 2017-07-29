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
 * @date 2017��7��28��
 */
public class MyBatisUtil {
	
	// ����ʽ����ģʽ
	public  static final SqlSessionFactory sqlSessionFactory = getSqlSessionFactory() ;

	public MyBatisUtil() {

	}

	/**
	 * ��ȡSqlSessionFactory
	 * �������ڲ���ʹ�ã�һ�������Ӧ��ʹ�õ���ģʽ��ֻ֤��һ��SqlSeesionFactory
	 * @return SqlSessionFactory
	 */
	private static SqlSessionFactory getSqlSessionFactory() {
		String resource = ConstantCodes.MYBATIS_CONFIG_FILE;
		InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}

	/**
	 * ��ȡSqlSession
	 * 
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	/**
	 * ��ȡSqlSession
	 * 
	 * @param isAutoCommit
	 *            true ��ʾ������SqlSession������ִ����SQL֮����Զ��ύ���� false
	 *            ��ʾ������SqlSession������ִ����SQL֮�󲻻��Զ��ύ������ʱ����Ҫ�����ֶ�����sqlSession.commit()�ύ����
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(boolean isAutoCommit) {
		return sqlSessionFactory.openSession(isAutoCommit);
	}
}
