/**
 * 
 */
package liaody.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Before;
import org.junit.Test;

import liaody.entity.UserInfo;
import liaody.entity.mapper.ManyDataMapper;
import liaody.pattern.SingleSqlSessionFactory;

/**
 * <p>
 * Title:ManyDataMapperTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018��3��8��
 */
public class ManyDataMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// ��ʾ���в��Դ���ǰִ��,��sqlSessionFactory��ֵ
	@Before
	public void InitialContext() throws IOException {
		// SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = SingleSqlSessionFactory.createSqlSessionFactory();
		// this.sqlSessionFactory=sqlSessionFactory;

	}

	// ͨ��id��ѯ�û�
	@Test
	public void findUserById() {

		List<UserInfo> manyDataList = new ArrayList<UserInfo>();
		
		long start = System.currentTimeMillis();
	
		for (int index = 0; index < 1000; index++) {
			UserInfo data = new UserInfo();
			data.setUserId(index);
			data.setPassword("testp");
			data.setUserEmail("yyy@test.com");
			data.setAge(200);
			data.setUsername("huangjiayi");
			manyDataList.add(data);
		}

		// ��ȡsqlsession
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			// ��ȡmapper�ӿڴ������
			ManyDataMapper manyDataMapper = sqlSession.getMapper(ManyDataMapper.class);
			manyDataMapper.saveOrUpdateDate(manyDataList);
			sqlSession.commit();

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/60);
	}
}
