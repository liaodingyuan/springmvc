/**
 * 
 */
package liaody.test;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.entity.UserInfo;
import liaody.serviceI.UserMapperI;
import liaody.utils.MyBatisUtil;

/**
 * <p>
 * Title:TestCRUDByAnnotationMapper
 * </p>
 * <p>
 * Description:ʹ�� ע�ⷽʽʵ����ɾ�Ĳ�
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��29��
 */
public class TestCRUDByAnnotationMapper {

	@Test
	public void addUser() {
		// ���ִ�����֮����Զ�commit
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		// �õ�UserMapperI�ӿڵ�ʵ�������UserMapper�ӿڵ�ʵ���������sqlSession.getMapper(UserMapperI.class)��̬����
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		UserInfo tmpUser = new UserInfo();
		tmpUser.setUsername("����");
		tmpUser.setPassword("123");
		tmpUser.setUserEmail("634748078@qq.com");
		tmpUser.setAge(12);
		tmpUser.setUserId(1);
		mapper.addUser(tmpUser);
		// ��ҪʱopenSession��ʹ�����֮����commitȻ��close
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		// openSession
		SqlSession session = MyBatisUtil.getSqlSession(true);
		// �õ�UserMapping�ӿڵ�ʵ���࣬��SqlSession��̬������
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		UserInfo user = new UserInfo();
		user.setPassword("2333");
		user.setUsername("liaody");
		user.setUserId(2);
		user.setAge(52);
		user.setUserEmail("123@qq.com");
		int retResult = mapper.updateUser(user);
		session.commit();
		session.close();
		System.out.println(retResult);
	}

	@Test
	public void deleteUser() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		UserInfo user = new UserInfo();
		user.setUserId(1);
		int retResult = mapper.deleteById(user.getUserId());
		session.close();
		System.out.println(retResult);
	}

	@Test
	public void getUserById() {

		SqlSession session = MyBatisUtil.getSqlSession(true);
		// ʹ��session.getMapper������̬���ɽӿ����ʵ��
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		UserInfo user = mapper.getUserById(2);
		System.out.println(user);
		session.close();

	}

	@Test
	public void getAllUser() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		List<UserInfo> userList = mapper.getAllUsers();
		for (UserInfo userInfo : userList) {
			System.out.println(userInfo);
		}
		session.close();
	}

}
