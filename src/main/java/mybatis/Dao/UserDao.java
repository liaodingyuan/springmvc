/**
 * 
 */
package mybatis.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import mybatis.Dao.provider.UserDynaSqlProvider;
import mybatis.domain.User;
import mybatis.util.common.HRMConstants;

/**
 * <p>
 * Title:UserDao
 * </p>
 * <p>
 * Description:User的CRUD
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月12日
 */
public interface UserDao {

	// 根据登录名和密码查询员工
	@Select(value = "SELECT * FROM " + HRMConstants.USERTABLE
			+ " WHERE loginname=#{loginname} ang password = #{password}")
	User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

	// 根据id查询用户
	@Select(value = "SELECT * FROM " + HRMConstants.USERTABLE + " WHERE id=#{id}")
	User selectById(Integer id);

	// 根据id删除用户
	@Delete(value = "DELETE FROM " + HRMConstants.USERTABLE + " WHERE id=#{id}")
	void deleteById(Integer id);
	// 动态修改用户
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	void update(User user);	
	// 动态查询
	
	// 根据参数查询用户总数
	// 动态插入用户
}
