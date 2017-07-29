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
 * Description: ʹ�õ���ģʽ����SqlSesssionFactory
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��28��
 */
public class SingleSqlSessionFactory {

	// private static final SingleSqlSressionFactory sqlSessionFactory = null;;

	// ˽�л��Ĺ��췽��
	private SingleSqlSessionFactory() {

	}

	// �ڲ���
	private class InnerSingleSqlSressionFactory {

		public InnerSingleSqlSressionFactory() {
			super();
		}

		public void createSqlSessionFactory() throws IOException {

			// ���ط�������·���µ�mybatis-config.xml�ļ�
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			// ����ֻ�ǲ��ԣ�Ӧ��ʹ�õ���ģʽ����SqlSressionFactory�������̰߳�ȫ�ġ�
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}

	}

}
