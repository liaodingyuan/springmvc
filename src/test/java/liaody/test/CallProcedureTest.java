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
 * @date 2017��7��29��
 */
public class CallProcedureTest {
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUserCount��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "liaody.entity.mapper.ProcedureMapper.getUserCount";// ӳ��sql�ı�ʶ�ַ���
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		sqlSession.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("usercount");
		System.out.println(result);
		sqlSession.close();
	}
}
