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
 * Description: ����sqlӳ����Ľӿڣ�ʹ��ע����������Ҫִ�еĵ�SQL
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��28��
 */
public interface UserMapperI {

	// ʹ��ע��@Insertע��ָ��add����Ҫִ�е�sql
	@Insert(value = {
			"insert into userinfo(username,password,userEmail,age) values(#{username},#{password},#{userEmail},#{age})" })
	public int addUser(UserInfo userinfo);

	// ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�sql
	@Delete(value = { "delete from userinfo where userId =#{userId}" })
	public int deleteById(int userId);

	// ʹ��@Selectע��ָ��getUserById����Ҫִ�е�sql
	@Select(value = { "select * from userinfo where userId = #{userId}" })
	public UserInfo getUserById(int userId);

	// ʹ��ע��@Updateָ������updateUser����Ҫִ�е�sql
	@Update(value = {
			"update userinfo set username=#{username},password=#{password},userEmail=#{userEmail},age=#{age} where userId =#{userId}" })
	public int updateUser(UserInfo userinfo);

	// ʹ��Selectע��ָ��getAllUsers����Ҫִ�е�sql
	// ���ص�UserInfo����ʹ��List����
	@Select(value = { "select * from userinfo" })
	public List<UserInfo> getAllUsers();
}
