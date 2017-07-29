/**
 * 
 */
package liaody.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.entity.UserInfo;
import liaody.utils.MyBatisUtil;

/**
 * <p>
 * Title:TestCURDXmlMapper
 * </p>
 * <p>
 * Description: ��ʹ��mybatis�������ݵ���ɾ�Ĳ���в��ԡ�����xml�����ļ�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��28��
 */
public class TestCURDXmlMapper {

	@Test
	public void testAdd() {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// ӳ��sql���ַ���
		String sqlStatement = "liaody.entity.mapper.UserMapper.addUser";
		UserInfo user = new UserInfo();
		user.setUsername("testUser1");
		user.setPassword("123456");
		user.setUserEmail("012@qq.com");
		user.setAge(23);

		int retResult = sqlSession.insert(sqlStatement, user);
		// ���û�������Զ�commit����Ҫ�����ֶ�commit
		sqlSession.commit();
		sqlSession.close();
		System.out.println(retResult);

	}

	@Test
	public void deleteUser() {
		SqlSession session = MyBatisUtil.getSqlSession(true);

		// ʹ���ַ�����λSQL���
		String sqlStatement = "liaody.entity.mapper.UserMapper.deleteUser";
		session.delete(sqlStatement, 4);
		session.delete(sqlStatement, 5);
		session.close();
	}

	@Test
	public void updateUser() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		String sqlStatement = "liaody.entity.mapper.UserMapper.updateUser";
		UserInfo user = new UserInfo();
		user.setUsername("Τ��");
		user.setUserId(8);
		user.setPassword("fuck you");
		user.setUserEmail("test@qq.com");
		user.setAge(20);
		session.update(sqlStatement, user);
		session.close();

	}

	@Test
	public void getUserById() {
		// �����Զ��ύ����Ҫ�ֶ�����commit
		SqlSession session = MyBatisUtil.getSqlSession();
		String sqlStatement = "liaody.entity.mapper.UserMapper.getUserById";
		UserInfo user = session.selectOne(sqlStatement, 8);
		System.out.println(user);
		session.close();

	}

	@Test
	public void getAllUsers() {
		SqlSession session = MyBatisUtil.getSqlSession(true);

		String sqlStatement = "liaody.entity.mapper.UserMapper.getAllUsers";

		List<UserInfo> userList = session.selectList(sqlStatement);

		for (UserInfo userInfo : userList) {
			System.out.println(userInfo);
		}

		session.close();

	}
}
