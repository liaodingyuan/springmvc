/**
 * 
 */
package mybatis.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import mybatis.util.common.HRMConstants;

/**
* <p>Title:UserDynaSqlProvider </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��8��12��
*/
public class UserDynaSqlProvider {
	
// ��ҳ��̬��ѯ
	public String selectWithParam(Map<String,Object> params) {
		
		String sql = new SQL() {
			{
				SELECT("*");
//				FROM HRMConstants.USERTABLE;
				if(params.get("user")!=null) {
					
				}
				
			}
		}.toString();
		return sql;
	}

}
