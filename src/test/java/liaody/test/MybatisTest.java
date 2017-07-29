/**
 * 
 */
package liaody.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import liaody.constantscodes.ConstantCodes;
import liaody.entity.UserInfo;

/**
 * <p>
 * Title:MybatisTest
 * </p>
 * <p>
 * Description:����mybatis�������ݿ��Ƿ�����
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��22��
 */
public class MybatisTest {

	public static void main(String[] args) throws IOException {

		// ���ط�������·���µ�mybatis-config.xml�ļ�
		InputStream inputStream = Resources.getResourceAsStream(ConstantCodes.MYBATIS_CONFIG_FILE);
		// ����ֻ�ǲ��ԣ�Ӧ��ʹ�õ���ģʽ����SqlSressionFactory�������̰߳�ȫ�ġ�
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ִ�г־û��Ķ�����ִ�г־û������Ķ����ǵ��Գ�Ч���̲߳���ȫ�����ܷ��������Բ��ܽ�SqlSeresion
		// ��Ϊ��Ϊ��ľ�̬����Ҳ���ܹ���Ϊʵ����
		// Ҳ���ܹ�������ʵ�����÷����κ����͵Ĺ���Χ֮�У�����Servlet��HttpSession�С�
		// ʹ��SqlSeesion�������֮����Ҫʹ��finally�����رա�
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("liaody");
		userInfo.setPassword("hyron@2017");
		userInfo.setUserEmail("6347480748@qq.com");
		userInfo.setAge(20);
		// userInfo.setProfilePicture(null);
		sqlSession.insert("liaody.entity.mapper.UserInfoMapper.save", userInfo);
		sqlSession.commit();
		sqlSession.close();

	}

}
