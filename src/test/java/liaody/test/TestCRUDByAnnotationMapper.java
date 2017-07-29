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
 * Description:使用 注解方式实现增删改查
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月29日
 */
public class TestCRUDByAnnotationMapper {

	@Test
	public void addUser() {
		// 语句执行完毕之后会自动commit
		SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		// 得到UserMapperI接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		UserInfo tmpUser = new UserInfo();
		tmpUser.setUsername("陈婷");
		tmpUser.setPassword("123");
		tmpUser.setUserEmail("634748078@qq.com");
		tmpUser.setAge(12);
		tmpUser.setUserId(1);
		mapper.addUser(tmpUser);
		// 需要时openSession，使用完成之后想commit然后close
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		// openSession
		SqlSession session = MyBatisUtil.getSqlSession(true);
		// 得到UserMapping接口的实现类，由SqlSession动态构建的
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
		// 使用session.getMapper方法动态生成接口类的实例
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
