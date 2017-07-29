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
 * Description:测试mybatis链接数据库是否正常
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月22日
 */
public class MybatisTest {

	public static void main(String[] args) throws IOException {

		// 加载放置在类路径下的mybatis-config.xml文件
		InputStream inputStream = Resources.getResourceAsStream(ConstantCodes.MYBATIS_CONFIG_FILE);
		// 这里只是测试，应该使用单例模式创建SqlSressionFactory。它是线程安全的。
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 执行持久化的对象，是执行持久化操作的对象。是但显成效，线程不安全，不能发共享，绝对不能将SqlSeresion
		// 作为作为类的静态变量也不能够作为实例域。
		// 也不能够将它的实例引用放在任何类型的管理范围之中，比如Servlet的HttpSession中。
		// 使用SqlSeesion对象完毕之后需要使用finally将它关闭。
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
