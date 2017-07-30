/**
 * 
 */
package liaody.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.utils.MyBatisUtil;

/**
 * <p>
 * Title:CallProcedureTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月29日
 */
public class CallProcedureTest {
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "liaody.entity.mapper.ProcedureMapper.getUserCount";// 映射sql的标识字符串
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		sqlSession.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result);
		sqlSession.close();
	}
}
