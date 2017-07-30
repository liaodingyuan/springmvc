/**
 * 
 */
package liaody.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.entity.Order;
import liaody.utils.MyBatisUtil;

/**
 * <p>
 * Title:Test3
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
public class Test3 {

	@Test
	public void testGetOrderById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * liaody.entity.mapper.OrderMapper��OrderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUser1��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUser1";// ӳ��sql�ı�ʶ�ַ���
		// ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
		Order order = sqlSession.selectOne(statement, 1);// ��ѯorders����idΪ1�ļ�¼
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(order);// ��ӡ�����null��Ҳ����û�в�ѯ����Ӧ�ļ�¼
	}

	@Test
	public void testGetOrderById2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * liaody.entity.mapper.OrderMapper��OrderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUserUseAliase��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUserUseAliase";// ӳ��sql�ı�ʶ�ַ���
		// ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
		Order order = sqlSession.selectOne(statement, 1);// ��ѯorders����idΪ1�ļ�¼
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(order);// ��ӡ�����Order [id=1, orderNo=aaaa, price=23.0]
	}

	@Test
	public void testGetOrderById3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * ӳ��sql�ı�ʶ�ַ�����
		 * liaody.entity.mapper.OrderMapper��OrderMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
		 * getUserUseResultType��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUserUseResultType";// ӳ��sql�ı�ʶ�ַ���
		// ִ�в�ѯ����������ѯ����Զ���װ��Order���󷵻�
		Order order = sqlSession.selectOne(statement, 1);// ��ѯorders����idΪ1�ļ�¼
		// ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
		sqlSession.close();
		System.out.println(order);// ��ӡ�����Order [id=1, orderNo=aaaa, price=23.0]
	}
}
