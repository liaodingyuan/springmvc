/**
 * 
 */
package mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.chart9.domain.Person;
import mybatis.chart9.mapper.PersonMapper;
import mybatis.util.MySqlSessionFactory;

/**
 * <p>
 * Title:MybatisTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��30��
 */
public class MybatisTest {

	// һ��һ���Թ�������
	@Test
	public void oneToOne() throws IOException {
		InputStream input = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ʹ�õ��Ǵ��������
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		// ֱ�ӵ��ýӿڵķ���
		Person person = mapper.selectPersonById(4);
		System.out.println(person);
		sqlSession.commit();
		sqlSession.close();
	}

	// ����һ�Զ��ϵ
	@Test
	public void oneToMany() {

		SqlSession sqlSession = MySqlSessionFactory.getSqlSessionFactoryInstance().openSession();
	}

}
