/**
 * 
 */
package liaody.serviceI;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import liaody.entity.UserInfo;

/**
 * <p>
 * Title:UserMapperI
 * </p>
 * <p>
 * Description: 定义sql映射出的接口，使用注解致命方法要执行的的SQL
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月28日
 */
public interface UserMapperI {

	// 使用注解@Insert注解指明add方法要执行的sql
	@Insert(value = {
			"insert into userinfo(username,password,userEmail,age) values(#{username},#{password},#{userEmail},#{age})" })
	public int addUser(UserInfo userinfo);

	// 使用@Delete注解指明deleteById方法要执行的sql
	@Delete(value = { "delete from userinfo where userId =#{userId}" })
	public int deleteById(int userId);

	// 使用@Select注解指明getUserById方法要执行的sql
	@Select(value = { "select * from userinfo where userId = #{userId}" })
	public UserInfo getUserById(int userId);

	// 使用注解@Update指明方法updateUser方法要执行的sql
	@Update(value = {
			"update userinfo set username=#{username},password=#{password},userEmail=#{userEmail},age=#{age} where userId =#{userId}" })
	public int updateUser(UserInfo userinfo);

	// 使用Select注解指明getAllUsers方法要执行的sql
	// 返回的UserInfo集合使用List接收
	@Select(value = { "select * from userinfo" })
	public List<UserInfo> getAllUsers();
}
