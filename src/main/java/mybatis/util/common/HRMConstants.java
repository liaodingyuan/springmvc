/**
 * 
 */
package mybatis.util.common;

/**
 * <p>
 * Title:HRMConstants
 * </p>
 * <p>
 * Description:常量类
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年8月12日
 */
public class HRMConstants {

	private HRMConstants() {

	}

	public static final String USERTABLE = "user_inf";
	public static final String DEPTTABLE = "dept_inf";
	public static final String JOBTABLE = "job_inf";
	public static final String EMPLOYEETABLE = "employee_inf";
	public static final String NOTICETABLE = "notice_inf";
	public static final String DOCUMENT = "document_inf";

	// 登录
	public static final String LOGIN = "loginForm";
	// 用户的session对象
	public static final String USER_SESSION = "user_session";
	// 默认每页4条数据，分页
	public static final int PAGE_DEFAULT_SIZE = 4;

}
