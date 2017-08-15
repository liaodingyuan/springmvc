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
 * Description:User��CRUD
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��8��12��
 */
public interface UserDao {

	// ���ݵ�¼���������ѯԱ��
	@Select(value = "SELECT * FROM " + HRMConstants.USERTABLE
			+ " WHERE loginname=#{loginname} ang password = #{password}")
	User selectByLoginnameAndPassword(@Param("loginname") String loginname, @Param("password") String password);

	// ����id��ѯ�û�
	@Select(value = "SELECT * FROM " + HRMConstants.USERTABLE + " WHERE id=#{id}")
	User selectById(Integer id);

	// ����idɾ���û�
	@Delete(value = "DELETE FROM " + HRMConstants.USERTABLE + " WHERE id=#{id}")
	void deleteById(Integer id);
	// ��̬�޸��û�
	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	void update(User user);	
	// ��̬��ѯ
	
	// ���ݲ�����ѯ�û�����
	// ��̬�����û�
}
