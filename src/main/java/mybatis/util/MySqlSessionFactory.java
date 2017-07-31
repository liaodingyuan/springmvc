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
 * Description:ʹ���ڲ������SqlSessionFactory�ĵ���ģʽ��
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��30��
 */
public class MySqlSessionFactory {
	// ��ֹ�ⲿ����MySqlSessionFactory����ʵ��
	private MySqlSessionFactory() {

	}
	// ʹ�þ�̬�ڲ���ʵ�ֵĵ���ģʽ
	private static class innserClass {
		// ��̬��ʼ����������JVM����֤�̵߳İ�ȫ
		private static final SqlSessionFactory factory = craeteSqlSessionFactory();

		/**
		 * ����SqlSessionFactory����
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
	 * ��ȡSqlSeesionFactory
	 * 
	 * @return
	 */
	public static SqlSessionFactory getSqlSessionFactoryInstance() {

		return innserClass.factory;

	}
}
